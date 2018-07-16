package com.staging.impl;

import com.staging.entity.Userorder;
import com.staging.mapper.UserorderMapper;
import com.staging.service.UserorderService;
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
public class UserorderServiceImpl extends ServiceImpl<UserorderMapper, Userorder> implements UserorderService {

}
