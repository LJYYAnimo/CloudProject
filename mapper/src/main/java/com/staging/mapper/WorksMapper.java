package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.News;
import com.staging.entity.Works;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.staging.entity.vo.WorksVo;
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
public interface WorksMapper extends BaseMapper<Works> {

    List<WorksVo> queryPageWorks(@Param("pager")Pager pager, @Param("worksVo") WorksVo worksVo);

}
