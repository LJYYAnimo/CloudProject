package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.Video;
import com.staging.entity.vo.VideoVo;
import com.staging.mapper.VideoMapper;
import com.staging.service.VideoService;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<VideoVo> queryPageVideo(Pager pager, VideoVo videoVo) {
        return videoMapper.queryPageVideo(pager,videoVo);
    }

    @Override
    public int queryPageCount(VideoVo videoVo) {
        return videoMapper.queryPageCount(videoVo);
    }
}
