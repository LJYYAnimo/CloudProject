package com.staging.entity.vo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Animo123
 * @since 2018-07-06
 */
@Data
public class VideoVo  {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 视频标题
     */
    private String title;

    /**
     * 分类
     */
    private String classzId;

    /**
     * 分类名称
     */
    private String classzName;
    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户名称
     */
    private Integer userName;

    /**
     * 上传时间
     */

    private Date upDate;
    /**
     * 下载时间
     */

    private Date downDate;
    /**
     * 下载次数
     */
    private Integer dcount;
    /**
     * 观看次数
     */
    private Integer watchcount;
    /**
     * 简介
     */
    private String synopsis;
    /**
     * 视频格式
     */

    private String videoFormat;
    /**
     * 视频大小
     */
    private String size;
    /**
     * 视频路径
     */

    private String videoPath;
    /**
     * 图片路径
     */

    private String imgPath;
    /**
     * 审核状态 1未审核，2审核通过，3审核未通过
     */
    private Integer ischecked;
    /**
     * 点赞
     */

    private Integer videoLike;
    /**
     * 审核未通过原因
     */

    private String notDes;
    /**
     * 审核时间
     */

    private Date checkDate;
    /**
     * 区id
     */

    private Integer areaId;
    /**
     * 市id
     */

    private Integer cityId;


}
