package com.staging.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.PagerLayui;
import com.staging.service.ProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/province")
@Api(tags = "1.0", description = "省级", value = "省级")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        Page page = provinceService.selectPage(new Page<>(pagerLayui.getPage(), pagerLayui.getLimit()));
        PagerLayui p = new PagerLayui();
        p.setRows(page.getRecords());
        p.setTotal(page.getTotal());
        return p;
    }

    @GetMapping("page")
    public String page(){
        return "province/province";
    }
}

