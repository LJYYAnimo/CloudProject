package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.News;
import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface NewsMapper extends BaseMapper<News> {

    List<News> queryPage(Pager pager);

    List<News> queryPageTitle(@Param("pager")Pager pager,@Param("news") News news);

    int queryPageCount(@Param("news") News news);
}
