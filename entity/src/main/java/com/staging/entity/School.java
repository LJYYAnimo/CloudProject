package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@TableName("t_school")
public class School extends Model<School> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学校名
     */
    @TableField("school_name")
    private String schoolName;
    /**
     * 学校所在的县
     */
    @TableField("school_address")
    private Integer schoolAddress;
    /**
     * 学校类型
     */
    @TableField("school_type")
    private Integer schoolType;
    /**
     * 创建时间
     */
    @TableField("creat_time")
    private Date creatTime;
    /**
     * 区id
     */
    @TableField("area_id")
    private Integer areaId;
    /**
     * 市id
     */
    @TableField("city_id")
    private Integer cityId;
    /**
     * 是否是直属学校
     */
    @TableField("directly_states")
    private Integer directlyStates;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(Integer schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public Integer getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(Integer schoolType) {
        this.schoolType = schoolType;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDirectlyStates() {
        return directlyStates;
    }

    public void setDirectlyStates(Integer directlyStates) {
        this.directlyStates = directlyStates;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "School{" +
        "id=" + id +
        ", schoolName=" + schoolName +
        ", schoolAddress=" + schoolAddress +
        ", schoolType=" + schoolType +
        ", creatTime=" + creatTime +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", directlyStates=" + directlyStates +
        "}";
    }
}
