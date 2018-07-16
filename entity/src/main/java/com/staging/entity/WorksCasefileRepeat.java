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
@TableName("t_works_casefile_repeat")
public class WorksCasefileRepeat extends Model<WorksCasefileRepeat> {

    private static final long serialVersionUID = 1L;

    /**
     * 标识下载作品的重复id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 下载用户的id
     */
    private Integer userId;
    /**
     * 作品id
     */
    private Integer worksId;
    /**
     * 创建时间
     */
    private Date creatTime;
    /**
     * 0-作品 1-课件
     */
    private Integer code;


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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorksCasefileRepeat{" +
        "id=" + id +
        ", userId=" + userId +
        ", worksId=" + worksId +
        ", creatTime=" + creatTime +
        ", code=" + code +
        "}";
    }
}
