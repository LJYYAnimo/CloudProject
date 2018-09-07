package com.staging.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.common.validated.Groups;
import com.staging.entity.CaseType;
import com.staging.entity.WorksType;
import com.staging.service.CaseTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-08-09
 */
@Controller
@RequestMapping("/caseType")
@Api(tags = "1.0", description = "课件类型管理", value = "课件类型管理")
public class CaseTypeController {

    @Autowired
    private CaseTypeService caseTypeService;

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转课件类型管理页面
     *
     */
    @GetMapping("page")
    public String page(){
        return "caseType/caseType";
    }

    @PostMapping("pager")
    @ApiOperation("分页查询课件类型")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = caseTypeService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    @PostMapping("update")
    @ApiOperation(value = "冻结激活")
    @ResponseBody
    public ServerResponse update(@Validated(value = {Groups.Default.class, Groups.Update.class}) CaseType caseType){
        if(!StringUtils.isEmpty(caseType)&&caseTypeService.updateAllColumnById(caseType)&&!StringUtils.isEmpty(caseType.getStatus())){
            return caseType.getStatus()==0?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_FREEZE):
                    caseType.getStatus()==1?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_ACTIVATE):
                            ServerResponse.createBySuccess("操作失败");
        }
        return ServerResponse.createByError("操作失败");
    }
}

