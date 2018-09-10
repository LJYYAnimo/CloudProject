package com.staging.service;

import com.staging.common.Pager;
import com.staging.entity.Video;
import com.baomidou.mybatisplus.service.IService;
import com.staging.entity.vo.VideoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
public interface VideoService extends IService<Video> {

    List<VideoVo> queryPageVideo(Pager pager, VideoVo videoVo);

    int queryPageCount( VideoVo videoVo);

}
