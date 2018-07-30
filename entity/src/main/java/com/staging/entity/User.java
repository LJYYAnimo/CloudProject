package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@TableName("t_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;
    /**
     * 用户密码
     */
    @TableField("userPassword")
    private String userPassword;
    /**
     * 创建时间
     */
    @TableField("creatTime")
    private Date creatTime;
    /**
     * 邮箱 @JsonIgnore
     */
    private String email;
    /**
     * 年级
     */
    private String grade;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 学校
     */
    private Integer school;
    /**
     * 性别 1为男，0为女
     */
    private Integer sex;
    /**
     * 生日
     */
    private Date brithday;

    private Integer qq;
    /**
     * 真实姓名
     */
    @TableField("realName")
    private String realName;
    /**
     * 个性签名
     */
    private String des;
    /**
     * 省份
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 县
     */
    private String address;
    /**
     * 详细地址
     */
    @TableField("betterAddress")
    private String betterAddress;
    /**
     * 指导老师姓名
     */
    @TableField("teacherName")
    private String teacherName;
    /**
     * 指导老师邮箱
     */
    @TableField("teacherEmail")
    private String teacherEmail;
    /**
     * 指导老师手机号码
     */
    @TableField("teacherPhone")
    private String teacherPhone;
    /**
     * 用户头像
     */
    private String img;
    /**
     * 学校类型，1小学，2中学
     */
    @TableField("schoolTypeId")
    private Integer schoolTypeId;
    /**
     * 粉丝数
     */
    @TableField("fans_num")
    private Integer fansNum;
    /**
     * 关注数
     */
    @TableField("watch_num")
    private Integer watchNum;
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
    /**
     * 直属学校用户
     */
    @TableField("directly_states")
    private Integer directlyStates;
    /**
     * 积分数
     */
    private Integer credits;
    /**
     * 经验值
     */
    private Integer experience;
    /**
     * 班级
     */
    private String clazz;

    private String salt;

    @TableField("user_type")
    private Integer userType;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getSchool() {
        return school;
    }

    public void setSchool(Integer school) {
        this.school = school;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBetterAddress() {
        return betterAddress;
    }

    public void setBetterAddress(String betterAddress) {
        this.betterAddress = betterAddress;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getSchoolTypeId() {
        return schoolTypeId;
    }

    public void setSchoolTypeId(Integer schoolTypeId) {
        this.schoolTypeId = schoolTypeId;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Integer getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Integer watchNum) {
        this.watchNum = watchNum;
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

    public Integer getDirectlyStates() {
        return directlyStates;
    }

    public void setDirectlyStates(Integer directlyStates) {
        this.directlyStates = directlyStates;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
