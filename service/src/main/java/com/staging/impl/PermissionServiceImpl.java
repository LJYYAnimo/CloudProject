package com.staging.impl;

import com.staging.common.ServerResponse;
import com.staging.entity.Permission;
import com.staging.mapper.PermissionMapper;
import com.staging.service.PermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {


    @Override
    public List<Permission> queryByRid(int rid) {
        List<Permission> list = baseMapper.queryByRid(rid);
        if(StringUtils.isEmpty(list)){
            return null;
        }
        return list;
    }


}
