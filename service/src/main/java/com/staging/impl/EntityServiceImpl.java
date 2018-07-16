package com.staging.impl;

import com.staging.entity.Entity;
import com.staging.mapper.EntityMapper;
import com.staging.service.EntityService;
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
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements EntityService {

}
