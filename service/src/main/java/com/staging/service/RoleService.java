package com.staging.service;

import com.staging.common.ServerResponse;
import com.staging.entity.Role;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户id查询角色id
     * @param id
     * @return
     */
    ServerResponse queryByUid(int id);

}
