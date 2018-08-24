package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.Book;
import com.baomidou.mybatisplus.service.IService;
import com.staging.entity.vo.BookVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface BookService extends IService<Book> {

    List<BookVo> queryPageBook(Pager pager, BookVo bookVo);

    int queryPageCount( BookVo bookVo);
}
