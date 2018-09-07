package com.staging.shiro.config.utils;

import com.staging.entity.Permission;
import com.staging.entity.Role;
import com.staging.entity.User;
import com.staging.entity.vo.PermissionVo;
import com.staging.shiro.config.constant.ShiroConstant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Animo on 2017-12-07.
 */
public class ShiroUtils {
    /**
     * shiro密码加密
     * @param password
     * @param salt
     * @return
     */
    public static String md5(String password, String salt) {
        return new SimpleHash(ShiroConstant.ENCRYPT_MD5, password, salt, ShiroConstant.ENNCRYPT_TOTAL).toString();
    }

    /**
     * 获取session
     * @return
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取Subject
     * @return
     */
    public static Subject getSubJect(){
        return SecurityUtils.getSubject();
    }


    /**
     * 循环角色
     * @param list
     * @return
     */
    public static Set<String> circulationRole(List<Role> list){
        Set<String> roleSet = new HashSet<>();
        for(Role role :list){
            roleSet.add(role.getRole());
        }
        return roleSet;
    }

    /**
     * 循环权限
     * @param permissions
     * @return
     */
    public static Set<String> circulationPermission(List<Permission> permissions){
        Set<String> permissionSet = new HashSet<>();
        for(Permission permission :permissions){
            if(StringUtils.isEmpty(permission.getJurUrl()) || StringUtils.isEmpty(permission.getJurPer())){
                continue;
            }
            permissionSet.add(permission.getJurPer());
        }
        return permissionSet;
    }
    
    /**
     * @Author: 95DBC
     * @Date: 2018/7/31 11:18
     * @Description:返回Session数据
     *
     */
    
    public static User getUserSession(){
        Session session = ShiroUtils.getSession();
        //获取当前登陆用户
        Object object = session.getAttribute(ShiroConstant.USER);
        return object!=null?(User)object:null;
    }

    /**
     * 组装前台自己要的树结构
     * @param permissions
     * @return
     */
    public static List<PermissionVo> getPermissionVo(List<Permission> permissions){
        List<PermissionVo> permissionVoList = new ArrayList<>();
        for(Permission permission : permissions){
            PermissionVo permissionVo;
            //如果父id为0  这个就是目录
            if(permission.getpId()==0){
                permissionVo = new PermissionVo();
                permissionVo.setPermission(permission);
                List<Permission> permissionList = new ArrayList<>();
                for(Permission permission1 : permissions){
                    if(permission1.getpId()==permission.getId()){
                        permissionList.add(permission1);
                    }
                }
                permissionVo.setPermissionList(permissionList);
                permissionVoList.add(permissionVo);
            }
        }
        return permissionVoList;
    }
}
