package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.validated.Groups;
import com.staging.entity.*;
import com.staging.service.CaseTypeService;
import com.staging.service.VideoClasszService;
import com.staging.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-08-16
 */
@RestController
@RequestMapping("/videoClassz")
public class VideoClasszController {

    @Autowired
    private VideoClasszService videoClasszService;

    @Autowired
    private VideoService videoService;



    @PostMapping("pager")
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = videoClasszService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    @PostMapping("updateStatus")
    public ServerResponse updateStatus(@Validated(value = {Groups.Default.class, Groups.Update.class}) VideoClassz videoClassz){
        if(!StringUtils.isEmpty(videoClassz)&&videoClasszService.updateAllColumnById(videoClassz)&&!StringUtils.isEmpty(videoClassz.getStatus())){
            return videoClassz.getStatus()==0?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                    videoClassz.getStatus()==1?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_ACTIVATE):
                            ServerResponse.createBySuccess("操作失败");
        }
        return ServerResponse.createByError("操作失败");
    }

    @PostMapping("save")
    public ServerResponse save(@Validated(value = Groups.Default.class)VideoClassz videoClassz){
        int result = videoClasszService.selectCount(new EntityWrapper<VideoClassz>().eq("name",videoClassz.getName()));
        if(result==1){
            return ServerResponse.createByError("已有这类型了");
        }
        videoClassz.setStatus(1);
        if(videoClasszService.insert(videoClassz)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("delete")
    public ServerResponse delete(VideoClassz videoClassz){
        int  result =  videoService.selectCount(new EntityWrapper<Video>().eq("classz_id",videoClassz.getId()));
        if(result!=0){
            return ServerResponse.createByError("该类型下还有视频不能删除");
        }
        if(videoClasszService.deleteById(videoClassz.getId())){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("update")
    public ServerResponse update(@Validated(value = {Groups.Default.class, Groups.Update.class}) VideoClassz videoClassz){
        if(videoClasszService.updateAllColumnById(videoClassz)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }
}

