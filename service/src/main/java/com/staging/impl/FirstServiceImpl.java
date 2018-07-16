package com.staging.impl;

import com.staging.entity.First;
import com.staging.mapper.FirstMapper;
import com.staging.service.FirstService;
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
public class FirstServiceImpl extends ServiceImpl<FirstMapper, First> implements FirstService {

}
