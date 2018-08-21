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
@TableName("t_video")
public class Video extends Model<Video> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 视频标题
     */
    private String title;
    /**
     * 分类
     */
    @TableField("classz_id")
    private String classzId;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 上传时间
     */
    @TableField("up_date")
    private Date upDate;
    /**
     * 下载时间
     */
    @TableField("down_date")
    private Date downDate;
    /**
     * 下载次数
     */
    private Integer dcount;
    /**
     * 观看次数
     */
    private Integer watchcount;
    /**
     * 简介
     */
    private String synopsis;
    /**
     * 视频格式
     */
    @TableField("video_format")
    private String videoFormat;
    /**
     * 视频大小
     */
    private String size;
    /**
     * 视频路径
     */
    @TableField("video_path")
    private String videoPath;
    /**
     * 图片路径
     */
    @TableField("img_path")
    private String imgPath;
    /**
     * 审核状态 1未审核，2审核通过，3审核未通过
     */
    private Integer ischecked;
    /**
     * 点赞
     */
    @TableField("video_like")
    private Integer videoLike;
    /**
     * 审核未通过原因
     */
    @TableField("not_des")
    private String notDes;
    /**
     * 审核时间
     */
    @TableField("check_date")
    private Date checkDate;
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

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClasszId() {
        return classzId;
    }

    public void setClasszId(String classzId) {
        this.classzId = classzId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public Date getDownDate() {
        return downDate;
    }

    public void setDownDate(Date downDate) {
        this.downDate = downDate;
    }

    public Integer getDcount() {
        return dcount;
    }

    public void setDcount(Integer dcount) {
        this.dcount = dcount;
    }

    public Integer getWatchcount() {
        return watchcount;
    }

    public void setWatchcount(Integer watchcount) {
        this.watchcount = watchcount;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getIschecked() {
        return ischecked;
    }

    public void setIschecked(Integer ischecked) {
        this.ischecked = ischecked;
    }

    public Integer getVideoLike() {
        return videoLike;
    }

    public void setVideoLike(Integer videoLike) {
        this.videoLike = videoLike;
    }

    public String getNotDes() {
        return notDes;
    }

    public void setNotDes(String notDes) {
        this.notDes = notDes;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Video{" +
        "title=" + title +
        ", id=" + id +
        ", classzId=" + classzId +
        ", uid=" + uid +
        ", upDate=" + upDate +
        ", downDate=" + downDate +
        ", dcount=" + dcount +
        ", watchcount=" + watchcount +
        ", synopsis=" + synopsis +
        ", videoFormat=" + videoFormat +
        ", size=" + size +
        ", videoPath=" + videoPath +
        ", imgPath=" + imgPath +
        ", ischecked=" + ischecked +
        ", videoLike=" + videoLike +
        ", notDes=" + notDes +
        ", checkDate=" + checkDate +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", provinceId=" + provinceId +
        "}";
    }

}
