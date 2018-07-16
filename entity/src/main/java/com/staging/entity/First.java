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
@TableName("t_first")
public class First extends Model<First> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 首次登陆
     */
    private Integer theFirstLanding;
    /**
     * 首次登陆时间
     */
    private Date theFirstLandingTime;
    /**
     * 注册
     */
    private Integer register;
    /**
     * 注册获取积分时间
     */
    private Date registerTime;
    /**
     * 完善基础信息
     */
    private Integer perfectBasicInformation;
    /**
     * 首次完善基础信息获取积分时间
     */
    private Date perfectBasicInformationTime;
    /**
     * 完善联系方式
     */
    private Integer perfectContactInformation;
    /**
     * 首次完善联系方式获取积分与经验值时间
     */
    private Date perfectContactInformationTime;
    /**
     * 绑定邮箱
     */
    private Integer bindEmailAddress;
    /**
     * 首次绑定邮箱获取积分与经验值时间
     */
    private Date bindEmailAddressTime;
    /**
     * 绑定手机号码
     */
    private Integer bindMobilePhoneNumber;
    /**
     * 首次绑定手机号码获取积分与经验值时间
     */
    private Date bindMobilePhoneNumberTime;
    /**
     * 上传头像
     */
    private Integer uploadPic;
    /**
     * 首次上传头像获得积分与经验值时间
     */
    private Date uploadPicTime;


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

    public Integer getTheFirstLanding() {
        return theFirstLanding;
    }

    public void setTheFirstLanding(Integer theFirstLanding) {
        this.theFirstLanding = theFirstLanding;
    }

    public Date getTheFirstLandingTime() {
        return theFirstLandingTime;
    }

    public void setTheFirstLandingTime(Date theFirstLandingTime) {
        this.theFirstLandingTime = theFirstLandingTime;
    }

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Integer getPerfectBasicInformation() {
        return perfectBasicInformation;
    }

    public void setPerfectBasicInformation(Integer perfectBasicInformation) {
        this.perfectBasicInformation = perfectBasicInformation;
    }

    public Date getPerfectBasicInformationTime() {
        return perfectBasicInformationTime;
    }

    public void setPerfectBasicInformationTime(Date perfectBasicInformationTime) {
        this.perfectBasicInformationTime = perfectBasicInformationTime;
    }

    public Integer getPerfectContactInformation() {
        return perfectContactInformation;
    }

    public void setPerfectContactInformation(Integer perfectContactInformation) {
        this.perfectContactInformation = perfectContactInformation;
    }

    public Date getPerfectContactInformationTime() {
        return perfectContactInformationTime;
    }

    public void setPerfectContactInformationTime(Date perfectContactInformationTime) {
        this.perfectContactInformationTime = perfectContactInformationTime;
    }

    public Integer getBindEmailAddress() {
        return bindEmailAddress;
    }

    public void setBindEmailAddress(Integer bindEmailAddress) {
        this.bindEmailAddress = bindEmailAddress;
    }

    public Date getBindEmailAddressTime() {
        return bindEmailAddressTime;
    }

    public void setBindEmailAddressTime(Date bindEmailAddressTime) {
        this.bindEmailAddressTime = bindEmailAddressTime;
    }

    public Integer getBindMobilePhoneNumber() {
        return bindMobilePhoneNumber;
    }

    public void setBindMobilePhoneNumber(Integer bindMobilePhoneNumber) {
        this.bindMobilePhoneNumber = bindMobilePhoneNumber;
    }

    public Date getBindMobilePhoneNumberTime() {
        return bindMobilePhoneNumberTime;
    }

    public void setBindMobilePhoneNumberTime(Date bindMobilePhoneNumberTime) {
        this.bindMobilePhoneNumberTime = bindMobilePhoneNumberTime;
    }

    public Integer getUploadPic() {
        return uploadPic;
    }

    public void setUploadPic(Integer uploadPic) {
        this.uploadPic = uploadPic;
    }

    public Date getUploadPicTime() {
        return uploadPicTime;
    }

    public void setUploadPicTime(Date uploadPicTime) {
        this.uploadPicTime = uploadPicTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "First{" +
        "id=" + id +
        ", userId=" + userId +
        ", theFirstLanding=" + theFirstLanding +
        ", theFirstLandingTime=" + theFirstLandingTime +
        ", register=" + register +
        ", registerTime=" + registerTime +
        ", perfectBasicInformation=" + perfectBasicInformation +
        ", perfectBasicInformationTime=" + perfectBasicInformationTime +
        ", perfectContactInformation=" + perfectContactInformation +
        ", perfectContactInformationTime=" + perfectContactInformationTime +
        ", bindEmailAddress=" + bindEmailAddress +
        ", bindEmailAddressTime=" + bindEmailAddressTime +
        ", bindMobilePhoneNumber=" + bindMobilePhoneNumber +
        ", bindMobilePhoneNumberTime=" + bindMobilePhoneNumberTime +
        ", uploadPic=" + uploadPic +
        ", uploadPicTime=" + uploadPicTime +
        "}";
    }
}
