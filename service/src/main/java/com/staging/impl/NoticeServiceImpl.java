package com.staging.impl;

import com.staging.entity.Notice;
import com.staging.mapper.NoticeMapper;
import com.staging.service.NoticeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
