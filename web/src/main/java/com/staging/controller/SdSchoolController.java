package com.staging.controller;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.staging.common.Pager;
import com.staging.common.ServerResponse;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.entity.SchoolType;
import com.staging.entity.SdSchool;
import com.staging.service.SchoolTypeService;
import com.staging.service.SdSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-20
 */
@Controller
@RequestMapping("/sdSchool")
public class SdSchoolController {

    @Autowired
    private SdSchoolService sdSchoolService;

    @Autowired
    private SchoolTypeService schoolTypeService;


    @PostMapping("pager")
    @ResponseBody
    public Pager pager(Integer page,Integer limit, SchoolType schoolType){
        EntityWrapper schoolTypeEntityWrapper = new EntityWrapper();
        //判断学校类型有没有传入
        if(!StringUtils.isEmpty(schoolType.getName())){
            schoolTypeEntityWrapper.eq("name",schoolType.getName());
        }
        SchoolType schoolTypeOne = schoolTypeService.selectOne(schoolTypeEntityWrapper);
        if(!StringUtils.isEmpty(schoolTypeOne)){
            SdSchool sdSchool = new SdSchool();
            sdSchool.setSchoolTypeid(schoolTypeOne.getId());
            return sdSchoolService.selectSdSchoolVoPager(new Pager(page,limit),sdSchool);
        }
        return null;
    }

    @PostMapping("save")
    @ResponseBody
    public ServerResponse save(SdSchool sdSchool){
        int result = sdSchoolService.selectCount(new EntityWrapper<SdSchool>().eq("school_name",sdSchool.getSchoolName()));
        if(result!=0){
            return ServerResponse.createByError("学校已存在");
        }
        sdSchool.setSchoolCreattime(Calendar.getInstance().getTime());
        return sdSchoolService.insert(sdSchool)?ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_SUCCESS_SAVE):ServerResponse.createBySuccess(ServerResponseConstant.SERVERRESPONSE_ERROR_SAVE);
    }

    public String page(){
        return "school/school";
    }

}

