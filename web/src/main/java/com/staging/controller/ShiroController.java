package com.staging.controller;

import com.staging.common.ServerResponse;
import com.staging.shiro.config.realm.AuthRealm;
import com.staging.shiro.config.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
 * @Date : 2018/7/12
 */
@RestController
@RequestMapping("/")
public class ShiroController {

    final AuthRealm authRealm;

    @Autowired
    public ShiroController(AuthRealm authRealm) {
        this.authRealm = authRealm;
    }

    @GetMapping("cache")
    public ServerResponse getAuthorizationCache(){
        return ServerResponse.createBySuccess(authRealm.getAuthorizationCache().get(ShiroUtils.getSubJect().getPrincipals()));
    }


    /**
     * 权限不足跳转页面
     * @return
     */
    @GetMapping("denied")
    public String denied(){
        return "denied";
    }



}
