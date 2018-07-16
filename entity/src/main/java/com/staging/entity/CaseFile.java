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
@TableName("t_case_file")
public class CaseFile extends Model<CaseFile> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 展示图片
     */
    private String img;
    /**
     * 课程简介
     */
    private String des;
    /**
     * 下载次数
     */
    private Integer downloadnum;
    /**
     * 系列课件id
     */
    private Integer seriesid;
    /**
     * 文件路径
     */
    private String fileadress;
    /**
     * 作者id
     */
    private Integer authorid;
    /**
     * 观看次数
     */
    private Integer viewnum;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改时间
     */
    private Date updatetime;
    /**
     * 课件的缩小版简介
     */
    private String about;
    /**
     * 审核状态，1-未审核，2-审核通过，3-审核不通过
     */
    @TableField("case_audit")
    private Integer caseAudit;
    /**
     * 不通过原因
     */
    @TableField("case_unreason")
    private String caseUnreason;
    /**
     * 审核时间
     */
    @TableField("audit_date")
    private Date auditDate;
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
     * 课件积分
     */
    private Integer caseFileIntegral;
    private String stl;


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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getDownloadnum() {
        return downloadnum;
    }

    public void setDownloadnum(Integer downloadnum) {
        this.downloadnum = downloadnum;
    }

    public Integer getSeriesid() {
        return seriesid;
    }

    public void setSeriesid(Integer seriesid) {
        this.seriesid = seriesid;
    }

    public String getFileadress() {
        return fileadress;
    }

    public void setFileadress(String fileadress) {
        this.fileadress = fileadress;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getCaseAudit() {
        return caseAudit;
    }

    public void setCaseAudit(Integer caseAudit) {
        this.caseAudit = caseAudit;
    }

    public String getCaseUnreason() {
        return caseUnreason;
    }

    public void setCaseUnreason(String caseUnreason) {
        this.caseUnreason = caseUnreason;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public Integer getCaseFileIntegral() {
        return caseFileIntegral;
    }

    public void setCaseFileIntegral(Integer caseFileIntegral) {
        this.caseFileIntegral = caseFileIntegral;
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
        return "CaseFile{" +
        "id=" + id +
        ", title=" + title +
        ", img=" + img +
        ", des=" + des +
        ", downloadnum=" + downloadnum +
        ", seriesid=" + seriesid +
        ", fileadress=" + fileadress +
        ", authorid=" + authorid +
        ", viewnum=" + viewnum +
        ", createtime=" + createtime +
        ", updatetime=" + updatetime +
        ", about=" + about +
        ", caseAudit=" + caseAudit +
        ", caseUnreason=" + caseUnreason +
        ", auditDate=" + auditDate +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", provinceId=" + provinceId +
        ", caseFileIntegral=" + caseFileIntegral +
        ", stl=" + stl +
        "}";
    }
}
