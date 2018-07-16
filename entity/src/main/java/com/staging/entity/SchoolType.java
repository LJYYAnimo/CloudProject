package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.staging.common.validated.Groups;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@TableName("t_school_type")
public class SchoolType extends Model<SchoolType> {

    private static final long serialVersionUID = 1L;

    /**
     * 学校类型id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(groups = Groups.Update.class)
    private Integer id;
    /**
     * 学校类型
     */
    @NotBlank(message = "学校类型不能为空",groups = Groups.Default.class)
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SchoolType{" +
        "id=" + id +
        ", name=" + name +
        "}";
    }
}
