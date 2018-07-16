package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
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
@TableName("t_thedailytable")
public class Thedailytable extends Model<Thedailytable> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 每日登录签到
     */
    private Integer everydayLogin;
    /**
     * 点赞作品
     */
    private Integer praiseWorks;
    /**
     * 评论作品，课件
     */
    private Integer comment;
    /**
     * 收藏作品
     */
    private Integer collectWorks;
    /**
     * 关注作者
     */
    private Integer attentionAuthor;
    /**
     * 下载作品
     */
    private Integer downloadWorks;
    /**
     * 下载课件
     */
    private Integer downloadCourseware;
    /**
     * 上传作品
     */
    private Integer uploadingWorks;
    /**
     * 上传课件
     */
    private Integer uploadingCourseware;
    /**
     * 上传视频
     */
    private Integer uploadingVideo;
    /**
     * 创建时间
     */
    private Date creatTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEverydayLogin() {
        return everydayLogin;
    }

    public void setEverydayLogin(Integer everydayLogin) {
        this.everydayLogin = everydayLogin;
    }

    public Integer getPraiseWorks() {
        return praiseWorks;
    }

    public void setPraiseWorks(Integer praiseWorks) {
        this.praiseWorks = praiseWorks;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Integer getCollectWorks() {
        return collectWorks;
    }

    public void setCollectWorks(Integer collectWorks) {
        this.collectWorks = collectWorks;
    }

    public Integer getAttentionAuthor() {
        return attentionAuthor;
    }

    public void setAttentionAuthor(Integer attentionAuthor) {
        this.attentionAuthor = attentionAuthor;
    }

    public Integer getDownloadWorks() {
        return downloadWorks;
    }

    public void setDownloadWorks(Integer downloadWorks) {
        this.downloadWorks = downloadWorks;
    }

    public Integer getDownloadCourseware() {
        return downloadCourseware;
    }

    public void setDownloadCourseware(Integer downloadCourseware) {
        this.downloadCourseware = downloadCourseware;
    }

    public Integer getUploadingWorks() {
        return uploadingWorks;
    }

    public void setUploadingWorks(Integer uploadingWorks) {
        this.uploadingWorks = uploadingWorks;
    }

    public Integer getUploadingCourseware() {
        return uploadingCourseware;
    }

    public void setUploadingCourseware(Integer uploadingCourseware) {
        this.uploadingCourseware = uploadingCourseware;
    }

    public Integer getUploadingVideo() {
        return uploadingVideo;
    }

    public void setUploadingVideo(Integer uploadingVideo) {
        this.uploadingVideo = uploadingVideo;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Thedailytable{" +
        "id=" + id +
        ", userId=" + userId +
        ", everydayLogin=" + everydayLogin +
        ", praiseWorks=" + praiseWorks +
        ", comment=" + comment +
        ", collectWorks=" + collectWorks +
        ", attentionAuthor=" + attentionAuthor +
        ", downloadWorks=" + downloadWorks +
        ", downloadCourseware=" + downloadCourseware +
        ", uploadingWorks=" + uploadingWorks +
        ", uploadingCourseware=" + uploadingCourseware +
        ", uploadingVideo=" + uploadingVideo +
        ", creatTime=" + creatTime +
        "}";
    }
}
