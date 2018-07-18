package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.validated.Groups;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.service.SchoolService;
import com.staging.service.SchoolTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/schoolType")
@Validated
@Api(tags = "1.0", description = "学校类型", value = "学校类型")
public class SchoolTypeController {

    @Autowired
    private SchoolTypeService cityService;

    @Autowired
    private SchoolService schoolService;

    @PostMapping("save")
    @ApiOperation(value = "类型添加")
    @ResponseBody
    public ServerResponse save(@Validated(value = Groups.Default.class)SchoolType schoolType){
        if(cityService.insert(schoolType)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    @PostMapping("delete")
    @ApiOperation(value = "删除类型")
    @ResponseBody
    public ServerResponse delete(@RequestBody SchoolType schoolType){
        int  result =  schoolService.selectCount(new EntityWrapper<School>().eq("school_type",schoolType.getId()));
        if(result!=0){
            return ServerResponse.createByError("该类型下还有学校不能删除");
        }
        if(cityService.deleteById(schoolType.getId())){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_DELET);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_DELET);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新类型")
    @ResponseBody
    public ServerResponse update(@Validated(value = {Groups.Default.class, Groups.Update.class})@RequestBody SchoolType schoolType){
        if(cityService.updateAllColumnById(schoolType)){
            return ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_UPDATE);
        }
        return ServerResponse.createByError(ServerResponseConstant.SERVERRESPONSE_ERROR_UPDATE);
    }

    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = cityService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    @GetMapping("page")
    public String page(){
        return "school/schoolType";
    }

}

