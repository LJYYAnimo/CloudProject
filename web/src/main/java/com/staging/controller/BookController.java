package com.staging.controller;


import com.staging.common.PagerLayui;
import com.staging.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  书籍管理前端控制器
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Controller
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @PostMapping("pager")
    @ResponseBody
    public PagerLayui pager(PagerLayui pagerLayui){
        return null;
    }

    /**
     * 查看所有书籍页面
     * @return
     */
    @GetMapping("page")
    public String page(){
        return "book/book";
    }

}

