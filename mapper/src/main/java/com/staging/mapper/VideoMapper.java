package com.staging.mapper;

import com.staging.common.Pager;
import com.staging.entity.Video;
import com.baomidou.mybatisplus.mapper.BaseMapper;
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
public interface VideoMapper extends BaseMapper<Video> {

    List<VideoVo> queryPageVideo(@Param("pager")Pager pager, @Param("videoVo") VideoVo videoVo);

    int queryPageCount(@Param("videoVo") VideoVo videoVo);
}
