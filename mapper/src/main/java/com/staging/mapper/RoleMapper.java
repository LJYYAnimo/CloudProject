package com.staging.mapper;

import com.staging.entity.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 根据用户id去查询角色表和用户关联表的数据
     */
    Role queryByUid(int id);
}
