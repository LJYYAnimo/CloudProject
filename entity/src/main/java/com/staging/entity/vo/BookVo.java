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
 * @Date : 2018/8/22
 */
@Data
public class BookVo {

    private Integer id;
    /**
     * 书名
     */
    private String title;
    /**
     * 简介
     */
    private String des;
    /**
     * 下载链接
     */
    private String url;
    /**
     * 0-已出版，1-未出版
     */
    private Integer type;
    /**
     * 图片路径
     */
    private String img;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 审核状态，1-未审核，2-审核通过，3-审核不通过
     */
    private Integer bookAudit;
    /**
     * 审核不通过原因
     */
    private String bookUnreason;
    /**
     * 审核时间
     */
    private Date auditTime;
    /**
     * 书籍类型-1收费我要购买0免费
     */
    private Integer bookType;
    /**
     * 关联用户表里的id
     */
    private Integer userId;
    /**
     * 关联用户表里的id
     */
    private Integer userName;
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
}
