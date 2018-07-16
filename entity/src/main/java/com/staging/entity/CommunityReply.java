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
@TableName("t_community_reply")
public class CommunityReply extends Model<CommunityReply> {

    private static final long serialVersionUID = 1L;

    /**
     * 社区评论回复id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 社区回复人id
     */
    @TableField("reply_userId")
    private String replyUserid;
    /**
     * 社区回复时间
     */
    @TableField("reply_time")
    private Date replyTime;
    /**
     * 对应一级评论id
     */
    @TableField("comm_id")
    private String commId;


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

    public String getReplyUserid() {
        return replyUserid;
    }

    public void setReplyUserid(String replyUserid) {
        this.replyUserid = replyUserid;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public String getCommId() {
        return commId;
    }

    public void setCommId(String commId) {
        this.commId = commId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CommunityReply{" +
        "id=" + id +
        ", content=" + content +
        ", replyUserid=" + replyUserid +
        ", replyTime=" + replyTime +
        ", commId=" + commId +
        "}";
    }
}
