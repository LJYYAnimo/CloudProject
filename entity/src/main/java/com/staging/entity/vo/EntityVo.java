package com.staging.entity.vo;

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
 * @Date : 2018/8/28
 */
@Data
public class EntityVo {

    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户名称
     */
    private Integer userName;
    /**
     * 实物名
     */
    private String entityName;
    /**
     * 所需积分
     */
    private Integer theIntegral;
    /**
     * 实物数量
     */
    private Integer entityNum;
    /**
     * 实物封面
     */
    private String entityCover;
    /**
     * 实物简介
     */
    private String entityIntro;
    /**
     * 实物兑换开始时间
     */
    private Date entityStartTime;
    /**
     * 实物兑换结束时间
     */
    private Date entityOverTime;
    /**
     * 公开与否
     */
    private Integer openOrNot;
    /**
     * 创建时间
     */
    private Date creatTime;
    /**
     * 1-省，2-市，3-区县，4-学校
     */
    private String sign;
}
