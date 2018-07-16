package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.service.SchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@Controller
@RequestMapping("/school")
@Api(tags = "1.0", description = "所有学校", value = "所有学校")
public class SchoolController {

    private final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private SchoolService schoolService;

    /**
     *
     * @param pagerLayui
     * @param schoolType
     * @param entityWrapper
     * @return
     */
    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui, SchoolType schoolType, EntityWrapper<School> entityWrapper){
        logger.info("进入学校分页查询:"+schoolType.toString());
        Page<School> pageEntity = new Page(pagerLayui.getPage(), pagerLayui.getLimit());
        if(null!=schoolType.getId()){
            entityWrapper.eq("school_type",schoolType.getId());
        }
        pageEntity= schoolService.selectPage(pageEntity,entityWrapper);
        PagerLayui p = new PagerLayui();
        p.setRows(pageEntity.getRecords());
        p.setTotal(pageEntity.getTotal());
        return p;
    }

    @GetMapping("page")
    public String page(){
        return "school/school";
    }

}

