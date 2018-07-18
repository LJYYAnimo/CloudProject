package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.entity.*;
import com.staging.entity.vo.RolePermissionVo;
import com.staging.service.*;
import com.staging.shiro.config.constant.ShiroConstant;
import com.staging.shiro.config.token.CustomToken;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/user")
@Api(tags = "1.0", description = "用户管理", value = "用户管理")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private UserTypeService userTypeService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    @ApiOperation("用户登录")
    @ResponseBody
    public ServerResponse login(@RequestBody User user) {
        Subject subject = ShiroUtils.getSubJect();
        //使用自定义Token
        CustomToken token = new CustomToken(user.getUserName(), user.getUserPassword());
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", user.getUserName());
            token.clear();
            return ServerResponse.createByError(e.getMessage());
        } catch (IncorrectCredentialsException e){
            log.error("对用户[{}]进行登录验证,验证未通过,用户密码错误", user.getUserName());
            token.clear();
            return ServerResponse.createByError("密码错误");
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("save")
    @ApiOperation("用户注册")
    @ResponseBody
    public ServerResponse save(@RequestBody User user){
        log.info("当前注册账号[{}]---注册信息:[{}]",user.getUserName(),user);
        User userResult = userService.selectOne(new EntityWrapper<User>().eq(("userName"),user.getUserName()));
        if(userResult!=null){
            return ServerResponse.createByError("账号已存在");
        }
        //加密密码
        user.setCreatTime(Calendar.getInstance().getTime());
        user.setSalt(ShiroUtils.md5(user.getUserName(),user.getUserPassword()));
        String password = ShiroUtils.md5(user.getUserPassword(),user.getSalt());
        user.setUserPassword(password);
        boolean result = userService.insert(user);
        if(result==true){
            return ServerResponse.createBySuccess("注册成功");
        }
        return ServerResponse.createByError("注册失败");
    }


    @PostMapping("pager")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui ,UserType userType,EntityWrapper<User> entityWrapper){
        Page<User> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        UserType utp = userTypeService.selectOne(new EntityWrapper<UserType>().eq("name",userType.getName()));
        if(!StringUtils.isEmpty(utp)){
            entityWrapper.eq("user_type",utp.getId());
        }
        pageEntity = userService.selectPage(pageEntity,entityWrapper);
        PagerLayui p = new PagerLayui();
        p.setRows(pageEntity.getRecords());
        p.setTotal(pageEntity.getTotal());
        return p;
    }

    @GetMapping("page")
    public String page(ModelMap map){
        map.addAttribute("userTypeList",userTypeService.selectList(new EntityWrapper<>()));
        return "user/user";
    }


    @GetMapping("home")
    public String home(ModelMap map){
        Session session = ShiroUtils.getSession();
        User user = (User) session.getAttribute(ShiroConstant.USER);
        UserRole userRole = userRoleService.selectOne(new EntityWrapper<UserRole>().eq("uid",user.getId()));
        Role role = null;
        if(!StringUtils.isEmpty(userRole)){
            role= roleService.selectById(userRole.getRid());
        }
        //如果当前登录用户没有赋予角色 则Return
        if(StringUtils.isEmpty(role)&!user.getUserName().equals(ShiroConstant.ROLE)){
            return null;
        }
        RolePermissionVo permissionVo = new RolePermissionVo();
        //如果该用户的账号等于自己设定的常量账号
        if(user.getUserName().equals(ShiroConstant.ROLE )||role.getRole().equals(ShiroConstant.MAXROLE)) {
            permissionVo.setRoles(roleService.selectList(new EntityWrapper<>()));
            permissionVo.setPermissionVoList(ShiroUtils.getPermissionVo(permissionService.selectList(new EntityWrapper<>())));
            map.addAttribute("permissionVo",permissionVo);
        }else {
            //这里只考虑了一个用户的情况下 如果多用户需要改sql
            List<Role> roles = new ArrayList<>();
            roles.add(role);
            permissionVo.setRoles(roles);
            List<RolePermission> list = rolePermissionService.selectList(new EntityWrapper<RolePermission>().eq("rid", role.getId()));
            List<Permission> permissions = new ArrayList<>();
            for (RolePermission rolePermission : list) {
                permissions.add(permissionService.selectById(rolePermission.getPid()));
            }
            permissionVo.setPermissionVoList(ShiroUtils.getPermissionVo(permissions));
            map.addAttribute("permissionVo", permissionVo);
        }
        return "home";
    }
}

