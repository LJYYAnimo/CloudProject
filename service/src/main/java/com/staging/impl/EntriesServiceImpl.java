package com.staging.impl;

import com.staging.entity.Entries;
import com.staging.mapper.EntriesMapper;
import com.staging.service.EntriesService;
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
public class EntriesServiceImpl extends ServiceImpl<EntriesMapper, Entries> implements EntriesService {

}
