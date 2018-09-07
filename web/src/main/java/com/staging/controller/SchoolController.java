package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.entity.User;
import com.staging.service.SchoolService;
import com.staging.service.SchoolTypeService;
import com.staging.shiro.config.constant.ShiroConstant;
import com.staging.shiro.config.utils.ShiroUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/school")
public class SchoolController {

    private final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private SchoolService schoolService;

    @Autowired
    private SchoolTypeService schoolTypeService;

    /**
     *
     * @param pager
     * @param schoolType
     * @param school
     * @return
     */
    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(PagerLayui pager, SchoolType schoolType, School school){
        SchoolType sct = schoolTypeService.selectOne(new EntityWrapper<SchoolType>().eq("name",schoolType.getName()));
        school.setSchoolType(sct.getId());
        return schoolService.selectSchool(new Pager(pager.getPage(),pager.getLimit()), school);
    }

    @GetMapping("page")
    public String page(ModelMap map){
        map.addAttribute("schoolTypes",schoolTypeService.selectList(new EntityWrapper<>()));
        return "school/school";
    }

}

