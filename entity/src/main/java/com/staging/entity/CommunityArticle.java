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
@TableName("t_community_article")
public class CommunityArticle extends Model<CommunityArticle> {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "article_id", type = IdType.AUTO)
    private Integer articleId;
    /**
     * 社区文章内容
     */
    @TableField("article_content")
    private String articleContent;
    /**
     * 社区文章表情
     */
    @TableField("article_exp")
    private String articleExp;
    /**
     * 社区文章图片
     */
    @TableField("article_pic")
    private String articlePic;
    /**
     * 社区文章时间
     */
    @TableField("article_time")
    private Date articleTime;
    /**
     * 社区文章发表人id
     */
    @TableField("article_userId")
    private Integer articleUserid;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleExp() {
        return articleExp;
    }

    public void setArticleExp(String articleExp) {
        this.articleExp = articleExp;
    }

    public String getArticlePic() {
        return articlePic;
    }

    public void setArticlePic(String articlePic) {
        this.articlePic = articlePic;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Integer getArticleUserid() {
        return articleUserid;
    }

    public void setArticleUserid(Integer articleUserid) {
        this.articleUserid = articleUserid;
    }

    @Override
    protected Serializable pkVal() {
        return this.articleId;
    }

    @Override
    public String toString() {
        return "CommunityArticle{" +
        "articleId=" + articleId +
        ", articleContent=" + articleContent +
        ", articleExp=" + articleExp +
        ", articlePic=" + articlePic +
        ", articleTime=" + articleTime +
        ", articleUserid=" + articleUserid +
        "}";
    }
}
