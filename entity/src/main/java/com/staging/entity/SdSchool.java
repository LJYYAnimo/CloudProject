package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
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
 * @since 2018-07-20
 */
@TableName("t_sd_school")
public class SdSchool extends Model<SdSchool> {

    private static final long serialVersionUID = 1L;

    /**
     * 学校id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 学校名
     */
    @TableField("school_name")
    private String schoolName;
    /**
     * 学校loge
     */
    @TableField("school_loge")
    private String schoolLoge;
    /**
     * 学校类型(关联学校类型表的id)
     */
    @TableField("school_typeid")
    private Integer schoolTypeid;
    /**
     * 学校地址(省级别)
     */
    @TableField("school_province")
    private String schoolProvince;
    /**
     * 学校地址(市级别)
     */
    @TableField("school_city")
    private String schoolCity;
    /**
     * 学校地址(县区级别)
     */
    @TableField("school_area")
    private String schoolArea;
    /**
     * 学校详细地址
     */
    @TableField("detailed_address")
    private String detailedAddress;
    /**
     * 学校网站
     */
    @TableField("school_website")
    private String schoolWebsite;
    /**
     * 学校简介
     */
    @TableField("school_about")
    private String schoolAbout;
    /**
     *
     ＊ 审核状态(0未审核,1通过，2未通过)
     */
    @TableField("audit_status")
    private Integer auditStatus;
    /**
     * 审核未通过原因
     */
    @TableField("sc_des")
    private String scDes;
    /**
     * 学校入驻申请时间
     */
    @TableField("school_creatTime")
    private Date schoolCreattime;
    /**
     * 学校封面地址
     */
    @TableField("school_cover")
    private String schoolCover;
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

    public String getScDes() {
        return scDes;
    }

    public void setScDes(String scDes) {
        this.scDes = scDes;
    }

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

    public String getSchoolLoge() {
        return schoolLoge;
    }

    public void setSchoolLoge(String schoolLoge) {
        this.schoolLoge = schoolLoge;
    }

    public Integer getSchoolTypeid() {
        return schoolTypeid;
    }

    public void setSchoolTypeid(Integer schoolTypeid) {
        this.schoolTypeid = schoolTypeid;
    }

    public String getSchoolProvince() {
        return schoolProvince;
    }

    public void setSchoolProvince(String schoolProvince) {
        this.schoolProvince = schoolProvince;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getSchoolArea() {
        return schoolArea;
    }

    public void setSchoolArea(String schoolArea) {
        this.schoolArea = schoolArea;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getSchoolWebsite() {
        return schoolWebsite;
    }

    public void setSchoolWebsite(String schoolWebsite) {
        this.schoolWebsite = schoolWebsite;
    }

    public String getSchoolAbout() {
        return schoolAbout;
    }

    public void setSchoolAbout(String schoolAbout) {
        this.schoolAbout = schoolAbout;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getSchoolCreattime() {
        return schoolCreattime;
    }

    public void setSchoolCreattime(Date schoolCreattime) {
        this.schoolCreattime = schoolCreattime;
    }

    public String getSchoolCover() {
        return schoolCover;
    }

    public void setSchoolCover(String schoolCover) {
        this.schoolCover = schoolCover;
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
        return "SdSchool{" +
        "id=" + id +
        ", schoolName=" + schoolName +
        ", schoolLoge=" + schoolLoge +
        ", schoolTypeid=" + schoolTypeid +
        ", schoolProvince=" + schoolProvince +
        ", schoolCity=" + schoolCity +
        ", schoolArea=" + schoolArea +
        ", detailedAddress=" + detailedAddress +
        ", schoolWebsite=" + schoolWebsite +
        ", schoolAbout=" + schoolAbout +
        ", auditStatus=" + auditStatus +
        ", schoolCreattime=" + schoolCreattime +
        ", schoolCover=" + schoolCover +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", directlyStates=" + directlyStates +
        ", scDes=" + scDes +
        "}";
    }
}
