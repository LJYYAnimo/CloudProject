package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import javafx.fxml.FXML;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Data
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
     * 邮箱
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
    private String school;
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
    private String county;
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

}
