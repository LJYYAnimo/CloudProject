package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-12
 */
@TableName("t_permission")
@Data
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 导航栏标题
     */
    private String name;
    /**
     * 图标
     */
    private String icon;
    /**
     * 父id
     */
    private Integer pid;
    /**
     * 权限地址
     */
    @TableField("jur_url")
    private String jurUrl;
    /**
     * 权限类型
     */
    @TableField("jur_type")
    private String jurType;
    /**
     * 相当于注解的权限
     */
    @TableField("jur_per")
    private String jurPer;
    /**
     * 图标的class样式
     */
    @TableField("icon_class")
    private String iconClass;
    /**
     * 权限信息描述
     */
    private String des;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
