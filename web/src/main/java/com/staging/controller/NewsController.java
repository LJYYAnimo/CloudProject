package com.staging.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.staging.common.Pager;
import com.staging.common.PagerLayui;
import com.staging.common.constant.ServerResponseConstant;
import com.staging.entity.News;
import com.staging.entity.School;
import com.staging.entity.SchoolType;
import com.staging.impl.NewsServiceImpl;
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
@RequestMapping("/news")
@Api(tags = "1.0", description = "所有资讯", value = "所有资讯")
public class NewsController {

    private final Logger logger = LoggerFactory.getLogger(SchoolController.class);

    @Autowired
    private NewsServiceImpl newsService;

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:39
     * @Description:跳转资讯管理的页面
     *
     */
    @GetMapping("page")
    public String page(){
        return "news/news";
    }

    /**
     * @Author: 95DBC
     * @Date: 2018/7/11 16:40
     * @Description:添加资讯管理的页面
     *
     */
    @GetMapping("addUpdateNews")
    public String addUpdateNews(){
        return "news/addUpdateNews";
    }

    /**
     *  TODO 资讯搜索后期可能会增加多个字段查询
     * 模糊搜索某个字段的所有资讯和查询所有资讯
     * @param
     * @return
     */
    @PostMapping("pager")
    @ApiOperation("分页查询")
    @ResponseBody
    public Pager pager(Integer page,Integer limit,News news,EntityWrapper<News> entityWrapper){
        logger.info("进入资讯分页查询:"+news.toString());
        Pager p = new Pager(page,limit);
        if(!"".equals(news.getTitle())&&null!=news.getTitle()){
            entityWrapper.like("title",news.getTitle());
        }
        p.setRows(newsService.queryPageTitle(p,news));
        p.setTotal(Long.valueOf(newsService.selectCount(entityWrapper)));
        return p;
    }
}

