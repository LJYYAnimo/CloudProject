package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.entity.Role;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/role")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page<Role> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        pageEntity= roleService.selectPage(pageEntity);
        PagerLayui p = new PagerLayui();
        p.setRows(pageEntity.getRecords());
        p.setTotal(pageEntity.getTotal());
        return p;
    }

    @GetMapping("page")
    public String page(){
        return "role/role";
    }

}

