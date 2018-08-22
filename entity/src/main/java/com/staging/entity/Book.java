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
@TableName("t_book")
public class Book extends Model<Book> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 书名
     */
    private String title;
    /**
     * 简介
     */
    private String des;
    /**
     * 下载链接
     */
    private String url;
    /**
     * 0-已出版，1-未出版
     */
    private Integer type;
    /**
     * 图片路径
     */
    private String img;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 审核状态，1-未审核，2-审核通过，3-审核不通过
     */
    @TableField("book_audit")
    private Integer bookAudit;
    /**
     * 审核不通过原因
     */
    @TableField("book_unreason")
    private String bookUnreason;
    /**
     * 审核时间
     */
    @TableField("audit_time")
    private Date auditTime;
    /**
     * 书籍类型-1收费我要购买0免费
     */
    @TableField("book_type")
    private Integer bookType;
    /**
     * 关联用户表里的id
     */
    @TableField("user_id")
    private Integer userId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBookAudit() {
        return bookAudit;
    }

    public void setBookAudit(Integer bookAudit) {
        this.bookAudit = bookAudit;
    }

    public String getBookUnreason() {
        return bookUnreason;
    }

    public void setBookUnreason(String bookUnreason) {
        this.bookUnreason = bookUnreason;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "Book{" +
        "id=" + id +
        ", title=" + title +
        ", des=" + des +
        ", url=" + url +
        ", type=" + type +
        ", img=" + img +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", bookAudit=" + bookAudit +
        ", bookUnreason=" + bookUnreason +
        ", auditTime=" + auditTime +
        ", bookType=" + bookType +
        ", userId=" + userId +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", provinceId=" + provinceId +
        "}";
    }
}
