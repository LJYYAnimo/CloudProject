package com.staging.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

/**
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 *
 * @Description :
 * ---------------------------------
 * @Author : liB QQ:1245018781
 * @Date : 2018/7/31
 */
@Data
public class WorksVo {

    /**
     * id
     */

    private Integer id;
    /**
     * 作品标题
     */

    private String worksTitle;
    /**
     * 作品类型id
     */

    private Integer worksTypeid;

    /**
     * 作品类型名称
     */
    private String worksTypeidName;

    /**
     * 作品标签
     */

    private String worksLabel;
    /**
     * 作品指导老师
     */

    private String worksTeacher;
    /**
     * 作品简介
     */

    private String worksAbout;
    /**
     * 作品地址
     */

    private String worksAddress;
    /**
     * 作品图片地址
     */

    private String worksPhotoaddress;
    /**
     * 作品创建时间
     */

    private Date worksDate;
    /**
     * 关联用户表的id
     */

    private Integer userId;

    /**
     * 关联的用户名称
     */

    private Integer userName;

    /**
     * 审核状态，1-未审核，2-审核通过，3-审核不通过
     */

    private Integer worksAudit;
    /**
     * 审核时间
     */

    private Date auditDate;
    /**
     * 学校类型id
     */

    private Integer schoolTypeid;

    /**
     * 所属学校
     */

    private Integer schoolTypeName;

    /**
     * 审核不通过的原因
     */

    private String noCheckedReason;
    /**
     * 区id
     */

    private Integer areaId;
    /**
     * 市id
     */

    private Integer cityId;
    /**
     * 省id
     */

    private Integer provinceId;
    /**
     * 作品所需积分
     */
    private Integer worksIntegral;
    private String stl;
}
