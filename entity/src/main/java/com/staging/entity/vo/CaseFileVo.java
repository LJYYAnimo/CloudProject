package com.staging.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
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
 * @Date : 2018/8/7
 */
@Data
public class CaseFileVo {

    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 展示图片
     */
    private String img;
    /**
     * 课程介绍
     */
    private String des;
    /**
     * 下载次数
     */
    private Integer downloadnum;
    /**
     * 课件类型id
     *
     */
    private Integer typeId;
    /**
     * 课件类型名称
     *
     */
    private String typeName;
    /**
     * 课件类型状态 0-冻结  1-激活
     *
     */
    private Integer status;
    /**
     * 文件路径
     */
    private String fileadress;
    /**
     * 作者id
     */
    private Integer authorid;
    /**
     * 作者名称
     */
    private Integer userName;
    /**
     * 观看次数
     */
    private Integer viewnum;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 修改时间
     */
    private Date updatetime;
    /**
     * 课件的缩小版简介
     */
    private String about;
    /**
     * 审核状态，1-未审核，2-审核通过，3-审核不通过
     */

    private Integer caseAudit;
    /**
     * 不通过原因
     */

    private String caseUnreason;
    /**
     * 审核时间
     */

    private Date auditDate;
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
     * 课件积分
     */
    private Integer caseFileIntegral;
    private String stl;
}
