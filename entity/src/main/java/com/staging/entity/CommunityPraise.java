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
@TableName("t_community_praise")
public class CommunityPraise extends Model<CommunityPraise> {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞id
     */
    @TableId(value = "praise_id", type = IdType.AUTO)
    private Integer praiseId;
    /**
     * 被点赞的文章id
     */
    @TableField("article_id")
    private Integer articleId;
    /**
     * 点赞人的userid
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 点赞时间
     */
    @TableField("praise_time")
    private Date praiseTime;


    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPraiseTime() {
        return praiseTime;
    }

    public void setPraiseTime(Date praiseTime) {
        this.praiseTime = praiseTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.praiseId;
    }

    @Override
    public String toString() {
        return "CommunityPraise{" +
        "praiseId=" + praiseId +
        ", articleId=" + articleId +
        ", userId=" + userId +
        ", praiseTime=" + praiseTime +
        "}";
    }
}
