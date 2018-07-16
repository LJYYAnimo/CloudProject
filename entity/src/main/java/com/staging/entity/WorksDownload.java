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
@TableName("t_works_download")
public class WorksDownload extends Model<WorksDownload> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 作品id
     */
    private Integer worksId;
    /**
     * 作品封面
     */
    private String worksImg;
    /**
     * 作品用戶
     */
    private String worksName;
    /**
     * 作品积分
     */
    private Integer worksIntegral;
    private Date creatDate;
    /**
     * 1-作品，2-课件
     */
    private Integer status;
    /**
     * 作品名称
     */
    private String worksTitle;
    /**
     * 作品地址
     */
    private String worksAddress;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 作品用户id
     */
    private Integer worksUserId;


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

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    public String getWorksImg() {
        return worksImg;
    }

    public void setWorksImg(String worksImg) {
        this.worksImg = worksImg;
    }

    public String getWorksName() {
        return worksName;
    }

    public void setWorksName(String worksName) {
        this.worksName = worksName;
    }

    public Integer getWorksIntegral() {
        return worksIntegral;
    }

    public void setWorksIntegral(Integer worksIntegral) {
        this.worksIntegral = worksIntegral;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWorksTitle() {
        return worksTitle;
    }

    public void setWorksTitle(String worksTitle) {
        this.worksTitle = worksTitle;
    }

    public String getWorksAddress() {
        return worksAddress;
    }

    public void setWorksAddress(String worksAddress) {
        this.worksAddress = worksAddress;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getWorksUserId() {
        return worksUserId;
    }

    public void setWorksUserId(Integer worksUserId) {
        this.worksUserId = worksUserId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorksDownload{" +
        "id=" + id +
        ", userId=" + userId +
        ", worksId=" + worksId +
        ", worksImg=" + worksImg +
        ", worksName=" + worksName +
        ", worksIntegral=" + worksIntegral +
        ", creatDate=" + creatDate +
        ", status=" + status +
        ", worksTitle=" + worksTitle +
        ", worksAddress=" + worksAddress +
        ", roleId=" + roleId +
        ", worksUserId=" + worksUserId +
        "}";
    }
}
