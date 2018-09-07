package com.staging.shiro.config.utils;

import com.staging.entity.Permission;
import com.staging.entity.Role;
import com.staging.entity.User;
import com.staging.entity.vo.PermissionVo;
import com.staging.entity.vo.SearchPermissionVO;
import com.staging.shiro.config.constant.ShiroConstant;
import com.staging.shiro.config.realm.AuthRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

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
     *
     * @param password
     * @param salt
     * @return
     */
    public static String md5(String password, String salt) {
        return new SimpleHash(ShiroConstant.ENCRYPT_MD5, password, salt, ShiroConstant.ENNCRYPT_TOTAL).toString();
    }

    /**
     * 获取session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取Subject
     *
     * @return
     */
    public static Subject getSubJect() {
        return SecurityUtils.getSubject();
    }


    /**
     * 循环角色
     *
     * @param list
     * @return
     */
    public static Set<String> circulationRole(List<Role> list) {
        Set<String> roleSet = new HashSet<>();
        for (Role role : list) {
            roleSet.add(role.getRole());
        }
        return roleSet;
    }

    /**
     * 循环权限
     *
     * @param permissions
     * @return
     */
    public static Set<String> circulationPermission(List<Permission> permissions) {
        Set<String> permissionSet = new HashSet<>();
        for (Permission permission : permissions) {
            if (StringUtils.isEmpty(permission.getJurUrl()) || StringUtils.isEmpty(permission.getJurPer())) {
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
     */

    public static User getUserSession() {
        Session session = ShiroUtils.getSession();
        //获取当前登陆用户
        Object object = session.getAttribute(ShiroConstant.USER);
        return object != null ? (User) object : null;
    }

    /**
     *
     * @Title: clearAuth
     * @Description: TODO 清空所有资源权限
     * @return void    返回类型
     */
    public static void clearAuth(){
        RealmSecurityManager rsm = (RealmSecurityManager)SecurityUtils.getSecurityManager();
        AuthRealm realm = (AuthRealm)rsm.getRealms().iterator().next();
        realm.clearAuthz();
    }


    /**
     * 组装前台自己要的树结构
     *
     * @param permissions
     * @return
     */
    public static List<PermissionVo> getPermissionVo(List<Permission> permissions) {
        //创建最外层的VO
        List<PermissionVo> permissionVoList = new ArrayList<>();
        int id ;
        int pid;
        for (Permission permission : permissions) {
            //里面放第一个目录和目录下的导航栏list
            PermissionVo permissionVo = new PermissionVo();
            //类型为1  就是最上层
            if (Integer.valueOf(permission.getJurType()) == 1) {
                permissionVo.setPermission(permission);
                //把当前目录的id值放入进去
                id = permission.getId();
                List<SearchPermissionVO> voList = new ArrayList<>();
                for(Permission permission1 : permissions){
                    SearchPermissionVO vo = new SearchPermissionVO();
                    if(permission1.getpId() == id && Integer.valueOf(permission1.getJurType())== 2){
                        vo.setPermission(permission1);
                        pid = permission1.getId();
                        List<Permission> list= new ArrayList<>();
                        for(Permission permission2 : permissions){
                            if(permission2.getpId() == pid && Integer.valueOf(permission2.getJurType())==3){
                                list.add(permission2);
                            }
                        }
                        vo.setPermissions(list);
                    }
                    if(vo.getPermission()!=null)
                        voList.add(vo);
                }
                permissionVo.setSearchPermissionVOS(voList);
            }
            if(permissionVo.getPermission()!=null)
            permissionVoList.add(permissionVo);
        }
        return permissionVoList;
    }
}
