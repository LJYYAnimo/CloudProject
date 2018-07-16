package com.staging.mapper;

import com.staging.entity.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> queryByRid(int rid);

}
