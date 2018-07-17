package com.staging.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.ServerResponse;
import com.staging.common.enums.MenuEnum;
import com.staging.entity.*;
import com.staging.entity.vo.PermissionVo;
import com.staging.entity.vo.RolePermissionVo;
import com.staging.service.*;
import com.staging.shiro.config.constant.ShiroConstant;
import com.staging.shiro.config.realm.AuthRealm;
import com.staging.shiro.config.utils.ShiroUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @Date : 2018/7/12
 */
@Controller
@RequestMapping("/")
public class ShiroController {

    final AuthRealm authRealm;

    @Autowired
    public ShiroController(AuthRealm authRealm) {
        this.authRealm = authRealm;
    }

    @GetMapping("cache")
    @ResponseBody
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
