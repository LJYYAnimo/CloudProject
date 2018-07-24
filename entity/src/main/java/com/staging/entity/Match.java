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
@TableName("t_match")
public class Match extends Model<Match> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 发布到首页的标题
     */
    private String title;
    private String des;
    /**
     * 比赛开始时间
     */
    @TableField("startTime")
    private Date startTime;
    /**
     * 比赛结束时间
     */
    @TableField("endTime")
    private Date endTime;
    /**
     * 比赛banner
     */
    private String image;
    /**
     * 比赛通知
     */
    private String notice;
    /**
     * 比赛表彰
     */
    private String commend;
    /**
     * 新建时间
     */
    @TableField("createTime")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("updateTime")
    private Date updateTime;
    /**
     * 比赛奖金
     */
    @TableField("match_bonus")
    private Integer matchBonus;
    /**
     * 比赛类型
     */
    @TableField("match_type")
    private String matchType;
    /**
     * 参赛人数
     */
    @TableField("matcherCount")
    private Integer matcherCount;
    /**
     * 参赛简介
     */
    @TableField("match_about")
    private String matchAbout;
    /**
     * 大赛介绍
     */
    @TableField("match_introduction")
    private String matchIntroduction;
    /**
     * 大赛规则
     */
    @TableField("match_rules")
    private String matchRules;
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getCommend() {
        return commend;
    }

    public void setCommend(String commend) {
        this.commend = commend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getMatchBonus() {
        return matchBonus;
    }

    public void setMatchBonus(Integer matchBonus) {
        this.matchBonus = matchBonus;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public Integer getMatcherCount() {
        return matcherCount;
    }

    public void setMatcherCount(Integer matcherCount) {
        this.matcherCount = matcherCount;
    }

    public String getMatchAbout() {
        return matchAbout;
    }

    public void setMatchAbout(String matchAbout) {
        this.matchAbout = matchAbout;
    }

    public String getMatchIntroduction() {
        return matchIntroduction;
    }

    public void setMatchIntroduction(String matchIntroduction) {
        this.matchIntroduction = matchIntroduction;
    }

    public String getMatchRules() {
        return matchRules;
    }

    public void setMatchRules(String matchRules) {
        this.matchRules = matchRules;
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

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Match{" +
        "id=" + id +
        ", title=" + title +
        ", des=" + des +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", image=" + image +
        ", notice=" + notice +
        ", commend=" + commend +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", matchBonus=" + matchBonus +
        ", matchType=" + matchType +
        ", matcherCount=" + matcherCount +
        ", matchAbout=" + matchAbout +
        ", matchIntroduction=" + matchIntroduction +
        ", matchRules=" + matchRules +
        ", areaId=" + areaId +
        ", cityId=" + cityId +
        ", provinceId=" + provinceId +
        "}";
    }
}
