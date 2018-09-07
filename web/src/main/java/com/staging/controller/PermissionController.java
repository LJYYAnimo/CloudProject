package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.entity.Permission;
import com.staging.entity.Role;
import com.staging.entity.RolePermission;
import com.staging.entity.vo.PermissionIdsVo;
import com.staging.service.PermissionService;
import com.staging.service.RolePermissionService;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
@Api(tags = "1.0", description = "权限管理", value = "权限管理")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

    @PostMapping("pager")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = permissionService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    @PostMapping("update")
    @ResponseBody
    public ServerResponse update(Permission permission){
        boolean result = permissionService.updateById(permission);
        if(result){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    /**
     *  授权
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public ServerResponse save(PermissionIdsVo permissionIdsVo){
        boolean result = rolePermissionService.delete(new EntityWrapper<RolePermission>().eq("rid",permissionIdsVo.getRid()));
        if(result){
            String[] id = permissionIdsVo.getIds().split(",");
            List<RolePermission> rolePermissions = new ArrayList<>();
            for(String i: id){
                rolePermissions.add(new RolePermission(permissionIdsVo.getRid(),Integer.valueOf(i)));
            }
            boolean res = rolePermissionService.insertBatch(rolePermissions);
            if(res){
                ShiroUtils.clearAuth();
                return ServerResponse.createBySuccess("授权成功");
            }
            return ServerResponse.createByError("授权失败");
        }
        return ServerResponse.createByError("角色ID无效");
    }

    @PostMapping("getPermission")
    @ResponseBody
    public ServerResponse getPermission(Role role){
        List<RolePermission> rolePermissions = rolePermissionService.selectList(new EntityWrapper<RolePermission>().eq("rid",role.getId()));
        if(rolePermissions.size()==0){
            return ServerResponse.createByError();
        }
        List<Integer> list = new ArrayList<>();
        for(RolePermission selectBatchIds : rolePermissions){
            list.add(selectBatchIds.getPid());
        }
        return ServerResponse.createBySuccess(ShiroUtils.getPermissionVo(permissionService.selectBatchIds(list)));
    }

    /**
     * 权限地址
     * @return
     */
    @GetMapping("page")
    public String page(ModelMap map){
        List<Permission> list = permissionService.selectList(new EntityWrapper<Permission>().eq("p_id",0));
        map.addAttribute("permissionList",list);
        return "permission/permission";
    }

}

