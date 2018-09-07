package com.staging.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
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
@ExcelTarget("permission")
@TableName("t_permission")
@Data
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 导航栏标题
     */
    @Excel(name = "导航栏标题", orderNum = "1", width = 25,needMerge = true)
    private String name;
    /**
     * 图标
     */
    @Excel(name = "图标", orderNum = "1", width = 25,needMerge = true)
    private String icon;
    /**
     * 父id
     */
    @TableField("p_id")
    @Excel(name = "父ID", orderNum = "1", width = 25,needMerge = true)
    private Integer pId;
    /**
     * 权限地址
     */
    @Excel(name = "权限地址", orderNum = "1", width = 25,needMerge = true)
    @TableField("jur_url")
    private String jurUrl;
    /**
     * 权限类型
     */
    @Excel(name = "权限类型", orderNum = "1", width = 25,needMerge = true)
    @TableField("jur_type")
    private String jurType;
    /**
     * 相当于注解的权限
     */
    @Excel(name = "权限注解", orderNum = "1", width = 25,needMerge = true)
    @TableField("jur_per")
    private String jurPer;
    /**
     * 图标的class样式
     */
    @Excel(name = "Class图标", orderNum = "1", width = 25,needMerge = true)
    @TableField("icon_class")
    private String iconClass;
    /**
     * 权限信息描述
     */
    @Excel(name = "描述", orderNum = "1", width = 25,needMerge = true)
    private String des;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpId() {
        return pId;
    }
}
