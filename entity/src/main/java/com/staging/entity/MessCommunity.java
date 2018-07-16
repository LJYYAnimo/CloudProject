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
@TableName("t_mess_community")
public class MessCommunity extends Model<MessCommunity> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date creatDate;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 我的消息id
     */
    private Integer messageId;
    /**
     * 通知标题
     */
    private String title;
    /**
     * 作品课件视频等id
     */
    private Integer loadId;
    /**
     * 评论内容
     */
    private String comment;
    /**
     * 评论作者
     */
    private String ctauthor;
    /**
     * 点赞作者
     */
    private String cdauthor;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLoadId() {
        return loadId;
    }

    public void setLoadId(Integer loadId) {
        this.loadId = loadId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCtauthor() {
        return ctauthor;
    }

    public void setCtauthor(String ctauthor) {
        this.ctauthor = ctauthor;
    }

    public String getCdauthor() {
        return cdauthor;
    }

    public void setCdauthor(String cdauthor) {
        this.cdauthor = cdauthor;
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
        return "MessCommunity{" +
        "id=" + id +
        ", content=" + content +
        ", creatDate=" + creatDate +
        ", userId=" + userId +
        ", messageId=" + messageId +
        ", title=" + title +
        ", loadId=" + loadId +
        ", comment=" + comment +
        ", ctauthor=" + ctauthor +
        ", cdauthor=" + cdauthor +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        "}";
    }
}
