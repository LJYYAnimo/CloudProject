package com.staging.impl;

import com.staging.entity.UserType;
import com.staging.mapper.UserTypeMapper;
import com.staging.service.UserTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户类型表 服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-18
 */
@Service
public class UserTypeServiceImpl extends ServiceImpl<UserTypeMapper, UserType> implements UserTypeService {

}
