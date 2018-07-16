package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@TableName("t_works_type")
public class WorksType extends Model<WorksType> {

    private static final long serialVersionUID = 1L;

    /**
     * 作品id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作品类型
     */
    @TableField("works_type")
    private String worksType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorksType() {
        return worksType;
    }

    public void setWorksType(String worksType) {
        this.worksType = worksType;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorksType{" +
        "id=" + id +
        ", worksType=" + worksType +
        "}";
    }
}
