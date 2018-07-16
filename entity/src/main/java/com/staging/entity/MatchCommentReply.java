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
@TableName("t_match_comment_reply")
public class MatchCommentReply extends Model<MatchCommentReply> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 父级id
     */
    private Integer pid;
    /**
     * 关联match_comment表的id
     */
    @TableField("match_comment_id")
    private Integer matchCommentId;
    /**
     * 用户id
     */
    @TableField("match_user_two_id")
    private Integer matchUserTwoId;
    /**
     * 评论回复
     */
    @TableField("match_content_two")
    private String matchContentTwo;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getMatchCommentId() {
        return matchCommentId;
    }

    public void setMatchCommentId(Integer matchCommentId) {
        this.matchCommentId = matchCommentId;
    }

    public Integer getMatchUserTwoId() {
        return matchUserTwoId;
    }

    public void setMatchUserTwoId(Integer matchUserTwoId) {
        this.matchUserTwoId = matchUserTwoId;
    }

    public String getMatchContentTwo() {
        return matchContentTwo;
    }

    public void setMatchContentTwo(String matchContentTwo) {
        this.matchContentTwo = matchContentTwo;
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
        return "MatchCommentReply{" +
        "id=" + id +
        ", pid=" + pid +
        ", matchCommentId=" + matchCommentId +
        ", matchUserTwoId=" + matchUserTwoId +
        ", matchContentTwo=" + matchContentTwo +
        ", creatTime=" + creatTime +
        "}";
    }
}
