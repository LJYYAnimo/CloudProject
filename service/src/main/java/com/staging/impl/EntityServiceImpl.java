package com.staging.impl;

import com.staging.common.Pager;
import com.staging.entity.Entity;
import com.staging.entity.vo.EntityVo;
import com.staging.mapper.EntityMapper;
import com.staging.service.EntityService;
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
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements EntityService {

    @Autowired
    private EntityMapper entityMapper;

    @Override
    public List<EntityVo> queryPageEntity(Pager pager, EntityVo entityVo) {
        return entityMapper.queryPageEntity(pager,entityVo);
    }

    @Override
    public int queryPageCount(EntityVo entityVo) {
        return entityMapper.queryPageCount(entityVo);
    }
}
