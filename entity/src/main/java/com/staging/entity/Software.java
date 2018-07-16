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
 * @since 2018-07-06
 */
@TableName("t_software")
public class Software extends Model<Software> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 软件名
     */
    @TableField("software_name")
    private String softwareName;
    /**
     * 软件适用
     */
    @TableField("software_apply")
    private String softwareApply;
    /**
     * 软件简绍
     */
    @TableField("software_about")
    private String softwareAbout;
    /**
     * 软件查看详情
     */
    @TableField("software_details")
    private String softwareDetails;
    /**
     * 软件32位下载地址
     */
    @TableField("software_32")
    private String software32;
    /**
     * 软件64位下载地址
     */
    @TableField("software_64")
    private String software64;
    /**
     * 软件模式
     */
    @TableField("software_model")
    private String softwareModel;
    /**
     * 软件图片
     */
    @TableField("software_img")
    private String softwareImg;
    /**
     * 文章详情中的第一段文章介绍
     */
    @TableField("about_head")
    private String aboutHead;
    /**
     * 文章创建时间
     */
    private Date creatTime;
    /**
     * 文章修改时间
     */
    private Date updateCreatTime;
    /**
     * 学校id对应t_school表
     */
    private Integer schoolId;
    /**
     * 软件审核状态 1-未审核，2-审核通过，3-审核不通过
     */
    @TableField("software_audit")
    private Integer softwareAudit;
    /**
     * 审核时间
     */
    @TableField("audit_time")
    private Date auditTime;
    /**
     * 审核不通过原因
     */
    @TableField("audit_unreason")
    private String auditUnreason;
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
     * 省id
     */
    @TableField("province_id")
    private Integer provinceId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public String getSoftwareApply() {
        return softwareApply;
    }

    public void setSoftwareApply(String softwareApply) {
        this.softwareApply = softwareApply;
    }

    public String getSoftwareAbout() {
        return softwareAbout;
    }

    public void setSoftwareAbout(String softwareAbout) {
        this.softwareAbout = softwareAbout;
    }

    public String getSoftwareDetails() {
        return softwareDetails;
    }

    public void setSoftwareDetails(String softwareDetails) {
        this.softwareDetails = softwareDetails;
    }

    public String getSoftware32() {
        return software32;
    }

    public void setSoftware32(String software32) {
        this.software32 = software32;
    }

    public String getSoftware64() {
        return software64;
    }

    public void setSoftware64(String software64) {
        this.software64 = software64;
    }

    public String getSoftwareModel() {
        return softwareModel;
    }

    public void setSoftwareModel(String softwareModel) {
        this.softwareModel = softwareModel;
    }

    public String getSoftwareImg() {
        return softwareImg;
    }

    public void setSoftwareImg(String softwareImg) {
        this.softwareImg = softwareImg;
    }

    public String getAboutHead() {
        return aboutHead;
    }

    public void setAboutHead(String aboutHead) {
        this.aboutHead = aboutHead;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateCreatTime() {
        return updateCreatTime;
    }

    public void setUpdateCreatTime(Date updateCreatTime) {
        this.updateCreatTime = updateCreatTime;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getSoftwareAudit() {
        return softwareAudit;
    }

    public void setSoftwareAudit(Integer softwareAudit) {
        this.softwareAudit = softwareAudit;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditUnreason() {
        return auditUnreason;
    }

    public void setAuditUnreason(String auditUnreason) {
        this.auditUnreason = auditUnreason;
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

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Software{" +
        "id=" + id +
        ", softwareName=" + softwareName +
        ", softwareApply=" + softwareApply +
        ", softwareAbout=" + softwareAbout +
        ", softwareDetails=" + softwareDetails +
        ", software32=" + software32 +
        ", software64=" + software64 +
        ", softwareModel=" + softwareModel +
        ", softwareImg=" + softwareImg +
        ", aboutHead=" + aboutHead +
        ", creatTime=" + creatTime +
        ", updateCreatTime=" + updateCreatTime +
        ", schoolId=" + schoolId +
        ", softwareAudit=" + softwareAudit +
        ", auditTime=" + auditTime +
        ", auditUnreason=" + auditUnreason +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", provinceId=" + provinceId +
        "}";
    }
}
