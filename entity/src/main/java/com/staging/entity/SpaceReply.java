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
@TableName("t_space_reply")
public class SpaceReply extends Model<SpaceReply> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 回复人id，等于控制id
     */
    private String replyId;
    /**
     * 回复内容
     */
    private String connect;
    /**
     * 被评论空间的id
     */
    private Integer spaceid;
    /**
     * 评论时间
     */
    private Date replyDate;
    /**
     * 控制id对应1级评论id
     */
    private String controlId;


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

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String replyId) {
        this.replyId = replyId;
    }

    public String getConnect() {
        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public Integer getSpaceid() {
        return spaceid;
    }

    public void setSpaceid(Integer spaceid) {
        this.spaceid = spaceid;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public String getControlId() {
        return controlId;
    }

    public void setControlId(String controlId) {
        this.controlId = controlId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SpaceReply{" +
        "id=" + id +
        ", userId=" + userId +
        ", replyId=" + replyId +
        ", connect=" + connect +
        ", spaceid=" + spaceid +
        ", replyDate=" + replyDate +
        ", controlId=" + controlId +
        "}";
    }
}
