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
@TableName("t_community_comment")
public class CommunityComment extends Model<CommunityComment> {

    private static final long serialVersionUID = 1L;

    /**
     * 社区评论id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date udate;
    /**
     * 发布人id
     */
    private Integer userid;
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
     * 对应文章id
     */
    @TableField("article_id")
    private Integer articleId;


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

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "CommunityComment{" +
        "id=" + id +
        ", content=" + content +
        ", udate=" + udate +
        ", userid=" + userid +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", articleId=" + articleId +
        "}";
    }
}
