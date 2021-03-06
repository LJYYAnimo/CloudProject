package com.staging.entity.vo;
import lombok.Data;

@Data
public class PermissionIdsVo {

    /**
     * 前台传入的权限id
     */
    private String ids;

    /**
     * 角色id
     */
    private Integer rid;

}
