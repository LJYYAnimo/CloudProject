package com.staging.controller;


import com.baomidou.mybatisplus.enums.SqlLike;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    /**
     * 用户Service
     */
    @Autowired
    private UserService userService;



    /**
     * 用户角色Service
     */
    @Autowired
    private UserRoleService userRoleService;


    /**
     * 用户类型Service
     */
    @Autowired
    private UserTypeService userTypeService;

    /**
     * 省Service
     */
    private ProvinceService provinceService;

    /**
     * 市Service
     */
    private CityService cityService;

    /**
     * 区Service
     */
    private AddressService addressService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public ServerResponse login(User user) {
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
        } catch(LockedAccountException e){
            log.error("对用户[{}]进行登录验证,验证未通过,没有分配权限", user.getUserName());
            token.clear();
            return ServerResponse.createByError(e.getMessage());
        }
        return ServerResponse.createBySuccess();
    }

    /**
     * 用户注册 TODO 用户注册判断注册类型默认赋值角色权限
     * @param user
     * @return
     */
    @PostMapping("save")
    public ServerResponse save(User user){
        log.info("当前注册账号[{}]---注册信息:[{}]",user.getUserName(),user);
        User userResult = userService.selectOne(new EntityWrapper<User>().eq(("userName"),user.getUserName()));
        if(userResult!=null){
            return ServerResponse.createByError("账号已存在");
        }
        //前台添加单个学生用户的情况下
        if(!StringUtils.isEmpty(user.getProvinceId())){
            if(!StringUtils.isEmpty(user.getProvince())){
                 user.setProvince(provinceService.selectById(user.getProvinceId()).getProvinceName());
            }
        }
        if(!StringUtils.isEmpty(user.getCityId())){
            if(!StringUtils.isEmpty(user.getCity())){
                user.setCity(cityService.selectById(user.getCityId()).getCname());
            }
        }
        if(!StringUtils.isEmpty(user.getAreaId())){
            if(!StringUtils.isEmpty(user.getAddress())){
                user.setAddress(addressService.selectById(user.getAreaId()).getAddressName());
            }
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
    public PagerLayui pager(PagerLayui pagerLayui ,UserType userType,User user, EntityWrapper<User> entityWrapper){
        Page<User> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        UserType utp = userTypeService.selectOne(new EntityWrapper<UserType>().eq("name",userType.getName()));
        if(!StringUtils.isEmpty(utp)){
            entityWrapper.eq("user_type",utp.getId());
            if(!StringUtils.isEmpty(user)){
                if(!StringUtils.isEmpty(user.getUserName())){
                    entityWrapper.like("userName",user.getUserName(), SqlLike.DEFAULT);
                }if(!StringUtils.isEmpty(user.getEmail())){
                    entityWrapper.like("email",user.getEmail(), SqlLike.DEFAULT);
                }if(!StringUtils.isEmpty(user.getPhone())){
                    entityWrapper.like("phone",user.getPhone(), SqlLike.DEFAULT);
                }if(!StringUtils.isEmpty(user.getRealName())){
                    entityWrapper.like("realName",user.getRealName(), SqlLike.DEFAULT);
                }if(!StringUtils.isEmpty(user.getSex())){
                    entityWrapper.eq("sex",user.getSex());
                }
            }
        }
        pageEntity = userService.selectPage(pageEntity,entityWrapper);
        PagerLayui p = new PagerLayui();
        p.setRows(pageEntity.getRecords());
        p.setTotal(pageEntity.getTotal());
        return p;
    }

    @PostMapping("reset")
    @ResponseBody
    public ServerResponse reset(User user){
        String newPassword = ShiroUtils.md5("123456",user.getSalt());
        user.setUserPassword(newPassword);
        return userService.updateById(user)?ServerResponse.createBySuccess("重置密码：123456"):ServerResponse.createByError("重置失败");
    }






    @PostMapping("saveRole")
    public ServerResponse saveRole(UserRole userRole){
        User user = ShiroUtils.getUserSession();
        if(user!=null){
            userRoleService.insert(userRole);
            ShiroUtils.clearAuth();
            return ServerResponse.createBySuccess("授权成功");
        }
        return ServerResponse.createBySuccess("登录超时");
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}

