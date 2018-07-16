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
@TableName("t_works")
public class Works extends Model<Works> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作品标题
     */
    @TableField("works_title")
    private String worksTitle;
    /**
     * 作品类型id
     */
    @TableField("works_typeid")
    private Integer worksTypeid;
    /**
     * 作品标签
     */
    @TableField("works_label")
    private String worksLabel;
    /**
     * 作品指导老师
     */
    @TableField("works_teacher")
    private String worksTeacher;
    /**
     * 作品简介
     */
    @TableField("works_about")
    private String worksAbout;
    /**
     * 作品地址
     */
    @TableField("works_address")
    private String worksAddress;
    /**
     * 作品图片地址
     */
    @TableField("works_photoAddress")
    private String worksPhotoaddress;
    /**
     * 作品创建时间
     */
    @TableField("works_date")
    private Date worksDate;
    /**
     * 关联用户表的id
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 审核状态，1-未审核，2-审核通过，3-审核不通过
     */
    @TableField("works_audit")
    private Integer worksAudit;
    /**
     * 审核时间
     */
    @TableField("audit_date")
    private Date auditDate;
    /**
     * 学校类型id
     */
    @TableField("school_typeid")
    private Integer schoolTypeid;
    /**
     * 审核不通过的原因
     */
    @TableField("no_checked_reason")
    private String noCheckedReason;
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
    /**
     * 作品所需积分
     */
    private Integer worksIntegral;
    private String stl;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorksTitle() {
        return worksTitle;
    }

    public void setWorksTitle(String worksTitle) {
        this.worksTitle = worksTitle;
    }

    public Integer getWorksTypeid() {
        return worksTypeid;
    }

    public void setWorksTypeid(Integer worksTypeid) {
        this.worksTypeid = worksTypeid;
    }

    public String getWorksLabel() {
        return worksLabel;
    }

    public void setWorksLabel(String worksLabel) {
        this.worksLabel = worksLabel;
    }

    public String getWorksTeacher() {
        return worksTeacher;
    }

    public void setWorksTeacher(String worksTeacher) {
        this.worksTeacher = worksTeacher;
    }

    public String getWorksAbout() {
        return worksAbout;
    }

    public void setWorksAbout(String worksAbout) {
        this.worksAbout = worksAbout;
    }

    public String getWorksAddress() {
        return worksAddress;
    }

    public void setWorksAddress(String worksAddress) {
        this.worksAddress = worksAddress;
    }

    public String getWorksPhotoaddress() {
        return worksPhotoaddress;
    }

    public void setWorksPhotoaddress(String worksPhotoaddress) {
        this.worksPhotoaddress = worksPhotoaddress;
    }

    public Date getWorksDate() {
        return worksDate;
    }

    public void setWorksDate(Date worksDate) {
        this.worksDate = worksDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWorksAudit() {
        return worksAudit;
    }

    public void setWorksAudit(Integer worksAudit) {
        this.worksAudit = worksAudit;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Integer getSchoolTypeid() {
        return schoolTypeid;
    }

    public void setSchoolTypeid(Integer schoolTypeid) {
        this.schoolTypeid = schoolTypeid;
    }

    public String getNoCheckedReason() {
        return noCheckedReason;
    }

    public void setNoCheckedReason(String noCheckedReason) {
        this.noCheckedReason = noCheckedReason;
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

    public Integer getWorksIntegral() {
        return worksIntegral;
    }

    public void setWorksIntegral(Integer worksIntegral) {
        this.worksIntegral = worksIntegral;
    }

    public String getStl() {
        return stl;
    }

    public void setStl(String stl) {
        this.stl = stl;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Works{" +
        "id=" + id +
        ", worksTitle=" + worksTitle +
        ", worksTypeid=" + worksTypeid +
        ", worksLabel=" + worksLabel +
        ", worksTeacher=" + worksTeacher +
        ", worksAbout=" + worksAbout +
        ", worksAddress=" + worksAddress +
        ", worksPhotoaddress=" + worksPhotoaddress +
        ", worksDate=" + worksDate +
        ", userId=" + userId +
        ", worksAudit=" + worksAudit +
        ", auditDate=" + auditDate +
        ", schoolTypeid=" + schoolTypeid +
        ", noCheckedReason=" + noCheckedReason +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", provinceId=" + provinceId +
        ", worksIntegral=" + worksIntegral +
        ", stl=" + stl +
        "}";
    }
}
