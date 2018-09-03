package com.staging.entity;

import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("t_entity")
public class Entity extends Model<Entity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;
    /**
     * 实物名
     */
    @TableField("entityName")
    private String entityName;
    /**
     * 所需积分
     */
    @TableField("theIntegral")
    private Integer theIntegral;
    /**
     * 实物数量
     */
    @TableField("entityNum")
    private Integer entityNum;
    /**
     * 实物封面
     */
    @TableField("entityCover")
    private String entityCover;
    /**
     * 实物简介
     */
    @TableField("entityIntro")
    private String entityIntro;
    /**
     * 实物兑换开始时间
     */
    @TableField("entityStartTime")
    private Date entityStartTime;
    /**
     * 实物兑换结束时间
     */
    @TableField("entityOverTime")
    private Date entityOverTime;
    /**
     * 公开与否
     */
    @TableField("openOrNot")
    private Integer openOrNot;
    /**
     * 创建时间
     */
    @TableField("creatTime")
    private Date creatTime;
    /**
     * 1-省，2-市，3-区县，4-学校
     */
    @TableField("sign")
    private String sign;


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

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Integer getTheIntegral() {
        return theIntegral;
    }

    public void setTheIntegral(Integer theIntegral) {
        this.theIntegral = theIntegral;
    }

    public Integer getEntityNum() {
        return entityNum;
    }

    public void setEntityNum(Integer entityNum) {
        this.entityNum = entityNum;
    }

    public String getEntityCover() {
        return entityCover;
    }

    public void setEntityCover(String entityCover) {
        this.entityCover = entityCover;
    }

    public String getEntityIntro() {
        return entityIntro;
    }

    public void setEntityIntro(String entityIntro) {
        this.entityIntro = entityIntro;
    }

    public Date getEntityStartTime() {
        return entityStartTime;
    }

    public void setEntityStartTime(Date entityStartTime) {
        this.entityStartTime = entityStartTime;
    }

    public Date getEntityOverTime() {
        return entityOverTime;
    }

    public void setEntityOverTime(Date entityOverTime) {
        this.entityOverTime = entityOverTime;
    }

    public Integer getOpenOrNot() {
        return openOrNot;
    }

    public void setOpenOrNot(Integer openOrNot) {
        this.openOrNot = openOrNot;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Entity{" +
        "id=" + id +
        ", userId=" + userId +
        ", entityName=" + entityName +
        ", theIntegral=" + theIntegral +
        ", entityNum=" + entityNum +
        ", entityCover=" + entityCover +
        ", entityIntro=" + entityIntro +
        ", entityStartTime=" + entityStartTime +
        ", entityOverTime=" + entityOverTime +
        ", openOrNot=" + openOrNot +
        ", creatTime=" + creatTime +
        ", sign=" + sign +
        "}";
    }
}
