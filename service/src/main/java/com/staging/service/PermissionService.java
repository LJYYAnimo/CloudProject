package com.staging.service;

import com.staging.common.ServerResponse;
import com.staging.entity.Permission;
import com.baomidou.mybatisplus.service.IService;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import com.staging.entity.Permission;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
public interface PermissionService extends IService<Permission> {

    List<Permission> queryByRid(int rid);
}
