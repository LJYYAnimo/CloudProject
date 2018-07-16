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
@TableName("t_match_comment")
public class MatchComment extends Model<MatchComment> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 大赛活动id
     */
    @TableField("match_id")
    private Integer matchId;
    /**
     * 用户id
     */
    @TableField("match_user_id")
    private Integer matchUserId;
    /**
     * 大赛评论
     */
    @TableField("match_content")
    private String matchContent;
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

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getMatchUserId() {
        return matchUserId;
    }

    public void setMatchUserId(Integer matchUserId) {
        this.matchUserId = matchUserId;
    }

    public String getMatchContent() {
        return matchContent;
    }

    public void setMatchContent(String matchContent) {
        this.matchContent = matchContent;
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
        return "MatchComment{" +
        "id=" + id +
        ", matchId=" + matchId +
        ", matchUserId=" + matchUserId +
        ", matchContent=" + matchContent +
        ", creatTime=" + creatTime +
        "}";
    }
}
