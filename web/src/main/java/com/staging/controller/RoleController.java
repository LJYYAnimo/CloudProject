package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.entity.Role;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.service.RoleService;
import io.swagger.annotations.Api;
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
@Api(tags = "1.0", description = "角色管理", value = "角色管理")
public class RoleController {

    private final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询
     * @param pagerLayui
     * @return
     */
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

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public ServerResponse save(Role role){
        int result = roleService.selectCount(new EntityWrapper<Role>().eq("role",role.getRole()));
        if(result==1){
            return ServerResponse.createByError("数据重复");
        }
        return roleService.insert(role)?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE):ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("delete")
    @ResponseBody
    public ServerResponse delete(Role role){
        if(role.getRole()=="超级管理员"){
            return ServerResponse.createByError("不可删除");
        }
        return roleService.deleteById(role.getId())?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET):ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @GetMapping("page")
    public String page(){
        return "role/role";
    }

}

