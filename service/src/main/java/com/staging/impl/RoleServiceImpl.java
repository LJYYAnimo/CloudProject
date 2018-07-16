package com.staging.impl;

import com.staging.common.ServerResponse;
import com.staging.entity.Role;
import com.staging.mapper.RoleMapper;
import com.staging.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public ServerResponse queryByUid(int id) {
        Role role = baseMapper.queryByUid(id);
        if(StringUtils.isEmpty(role)){
            return ServerResponse.createBySuccess(role);
        }
        return ServerResponse.createByError("暂无角色");
    }
}
