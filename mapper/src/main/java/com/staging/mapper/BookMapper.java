package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.Book;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.BookVo;
import com.staging.entity.vo.VideoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface BookMapper extends BaseMapper<Book> {


    List<BookVo> queryPageBook(@Param("pager")Pager pager, @Param("bookVo") BookVo bookVo);

    int queryPageCount(@Param("bookVo") BookVo bookVo);

}
