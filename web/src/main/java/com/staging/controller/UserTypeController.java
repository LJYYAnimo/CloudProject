package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.entity.User;
import com.staging.entity.UserType;
import com.staging.service.UserService;
import com.staging.service.UserTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户类型表 前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-18
 */
@Controller
@RequestMapping("/userType")
@Api(tags = "1.0", description = "用户类型管理", value = "用户类型管理")
public class UserTypeController {

    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     * @param pagerLayui
     * @return
     */
    @PostMapping("pager")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = userTypeService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    /**
     * 添加数据
     * @param userType
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public ServerResponse save(UserType userType){
        int res = userTypeService.selectCount(new EntityWrapper<UserType>().eq("name",userType.getName()));
        if(res==1){
            return ServerResponse.createByError("数据重复");
        }
        boolean result = userTypeService.insert(userType);
        if(result){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }
        return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("delete")
    @ResponseBody
    public ServerResponse delete(UserType userType){
        int result = userService.selectCount(new EntityWrapper<User>().eq("user_type",userType.getId()));
        if(result!=0){
            return ServerResponse.createByError("该类型下还有用户不能删除");
        }
        if(userTypeService.deleteById(userType.getId())){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }


    @GetMapping("page")
    public String page(){
        return "user/userType";
    }


}

