package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.Entity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.EntityVo;
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
public interface EntityMapper extends BaseMapper<Entity> {

    List<EntityVo> queryPageEntity(@Param("pager")Pager pager, @Param("entityVo") EntityVo entityVo);

    int queryPageCount(@Param("entityVo") EntityVo entityVo);
}
