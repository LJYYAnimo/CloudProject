package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.Book;
import com.staging.entity.vo.BookVo;
import com.staging.mapper.BookMapper;
import com.staging.service.BookService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookVo> queryPageBook(Pager pager, BookVo bookVo) {
        return bookMapper.queryPageBook(pager,bookVo);
    }

    @Override
    public int queryPageCount(BookVo bookVo) {
        return bookMapper.queryPageCount(bookVo);
    }
}
