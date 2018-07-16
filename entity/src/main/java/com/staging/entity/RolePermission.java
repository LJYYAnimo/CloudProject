package com.staging.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
@TableName("t_role_permission")
public class RolePermission extends Model<RolePermission> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer rid;
    /**
     * 权限id
     */
    private Integer pid;


    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    protected Serializable pkVal() {
        return this.rid;
    }

    @Override
    public String toString() {
        return "RolePermissionVo{" +
        "rid=" + rid +
        ", pid=" + pid +
        "}";
    }
}
