package com.staging.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("pager")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = permissionService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    /**
     * 权限地址
     * @return
     */
    @GetMapping("page")
    public String page(){
        return "permission/permission";
    }

}

