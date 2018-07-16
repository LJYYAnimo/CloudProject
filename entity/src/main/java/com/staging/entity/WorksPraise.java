package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
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
@TableName("t_works_praise")
public class WorksPraise extends Model<WorksPraise> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作品id
     */
    @TableField("works_id")
    private Integer worksId;
    /**
     * 点赞人id
     */
    @TableField("praise_id")
    private Integer praiseId;
    /**
     * 点赞时间
     */
    private Date creatDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorksId() {
        return worksId;
    }

    public void setWorksId(Integer worksId) {
        this.worksId = worksId;
    }

    public Integer getPraiseId() {
        return praiseId;
    }

    public void setPraiseId(Integer praiseId) {
        this.praiseId = praiseId;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "WorksPraise{" +
        "id=" + id +
        ", worksId=" + worksId +
        ", praiseId=" + praiseId +
        ", creatDate=" + creatDate +
        "}";
    }
}
