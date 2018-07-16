package com.staging.impl;

import com.staging.entity.UserCollection;
import com.staging.mapper.UserCollectionMapper;
import com.staging.service.UserCollectionService;
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
public class UserCollectionServiceImpl extends ServiceImpl<UserCollectionMapper, UserCollection> implements UserCollectionService {

}
