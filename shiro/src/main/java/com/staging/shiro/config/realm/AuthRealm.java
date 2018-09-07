package com.staging.shiro.config.realm;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.entity.*;
import com.staging.service.*;
import com.staging.shiro.config.constant.ShiroConstant;
import com.staging.shiro.config.token.CustomToken;
import com.staging.shiro.config.utils.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : Animo QQ:1151757358
 * @Date : 2018/7/11
 */
public class AuthRealm extends AuthorizingRealm{

    private static final Logger log = LoggerFactory.getLogger(AuthRealm.class);

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

    /**
     * 用户登录拦截
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //转换成自定义的token
        CustomToken token = (CustomToken) authenticationToken;
        //获取当事人
        String principal = token.getPrincipal().toString();
        log.info("当前验证用户{}",principal);
        //查询当前用户
        User user = userService.selectOne(new EntityWrapper<User>().eq("userName",principal));
        if(user==null){
            throw new UnknownAccountException("账号不存在");
        }
        UserRole userRole = userRoleService.selectOne(new EntityWrapper<UserRole>()
                .eq("uid",user.getId())
        );
        if(userRole==null && !user.getUserName().equals(ShiroConstant.ROLE)){
            throw new LockedAccountException("用户无权限");
        }
        //因为账号是唯一的 所以user不为空就能获取到数据库加密的密码
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getUserPassword(),ByteSource.Util.bytes(user.getSalt()),getName());
        Session session = ShiroUtils.getSession();
        session.setAttribute(ShiroConstant.USER, user);
        return authenticationInfo;
    }

    /**
     * 获取用户权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("*******************获取权限****************");
        Session session = ShiroUtils.getSession();
        //获取当前登陆用户
        User user = (User) session.getAttribute(ShiroConstant.USER);
        //如果当前登录用户为空 那就没有必要进行下一步
        if(StringUtils.isEmpty(user)){
            return null;
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取该用户和角色的关联信息
        UserRole userRole = userRoleService.selectOne(new EntityWrapper<UserRole>().eq("uid",user.getId()));
        Role role = null;
        if(!StringUtils.isEmpty(userRole)){
            role= roleService.selectById(userRole.getRid());
        }
        //如果当前登录用户没有赋予角色 则Return
        if(StringUtils.isEmpty(role)&!user.getUserName().equals(ShiroConstant.ROLE)){
            return null;
        }
        //如果该用户的账号等于自己设定的常量账号
        if(user.getUserName().equals(ShiroConstant.ROLE )||role.getRole().equals(ShiroConstant.MAXROLE)){
            info.setRoles(ShiroUtils.circulationRole(roleService.selectList(new EntityWrapper<>())));
            info.setStringPermissions(ShiroUtils.circulationPermission(permissionService.selectList(new EntityWrapper<>())));
            return info;
        }else{
            Set<String> roleSet = new HashSet<>();
            roleSet.add(role.getRole());
            info.setRoles(roleSet);
            List<RolePermission> list = rolePermissionService.selectList(new EntityWrapper<RolePermission>().eq("rid",role.getId()));
            List<Permission> permissions = new ArrayList<>();
            for(RolePermission rolePermission : list){
                permissions.add(permissionService.selectById(rolePermission.getPid()));
            }
            info.setStringPermissions(ShiroUtils.circulationPermission(permissions));
            return info;
        }
    }
}
