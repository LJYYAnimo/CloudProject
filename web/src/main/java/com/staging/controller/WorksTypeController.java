package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.validated.Groups;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.entity.Works;
import com.staging.entity.WorksType;
import com.staging.service.WorksService;
import com.staging.service.WorksTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@RestController
@RequestMapping("/worksType")
public class WorksTypeController {

    @Autowired
    private WorksTypeService worksTypeService;

    @Autowired
    private WorksService worksService;



    @PostMapping("pager")
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = worksTypeService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    @PostMapping("save")
    public ServerResponse save(@Validated(value = Groups.Default.class)WorksType worksType){
        int result = worksTypeService.selectCount(new EntityWrapper<WorksType>().eq("works_type",worksType.getWorksType()));
        if(result==1){
            return ServerResponse.createByError("数据重复");
        }
        if(worksTypeService.insert(worksType)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("delete")
    public ServerResponse delete(WorksType worksType){
        int  result =  worksService.selectCount(new EntityWrapper<Works>().eq("works_typeid",worksType.getId()));
        if(result!=0){
            return ServerResponse.createByError("该类型下还有作品不能删除");
        }
        if(worksTypeService.deleteById(worksType.getId())){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("update")
    public ServerResponse update(@Validated(value = {Groups.Default.class, Groups.Update.class}) WorksType worksType){
        if(worksTypeService.updateAllColumnById(worksType)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

}

