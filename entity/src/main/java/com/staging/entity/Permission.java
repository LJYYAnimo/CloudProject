package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonValue;
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
public class Permission extends Model<Permission> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 导航栏标题
     */
    private String title;
    /**
     * 图标
     */
    private String icon;
    /**
     * 父id
     */
    @TableField("parent_id")
    private Integer parentId;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getJurUrl() {
        return jurUrl;
    }

    public void setJurUrl(String jurUrl) {
        this.jurUrl = jurUrl;
    }

    public String getJurType() {
        return jurType;
    }

    public void setJurType(String jurType) {
        this.jurType = jurType;
    }

    public String getJurPer() {
        return jurPer;
    }

    public void setJurPer(String jurPer) {
        this.jurPer = jurPer;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", title=" + title +
        ", icon=" + icon +
        ", parentId=" + parentId +
        ", jurUrl=" + jurUrl +
        ", jurType=" + jurType +
        ", jurPer=" + jurPer +
        ", iconClass=" + iconClass +
        ", des=" + des +
        "}";
    }
}
