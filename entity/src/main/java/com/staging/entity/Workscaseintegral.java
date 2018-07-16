package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_workscaseintegral")
public class Workscaseintegral extends Model<Workscaseintegral> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 作品所需积分
     */
    private Integer worksIntegral;
    /**
     * 课件所需积分
     */
    private Integer caseIntegral;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorksIntegral() {
        return worksIntegral;
    }

    public void setWorksIntegral(Integer worksIntegral) {
        this.worksIntegral = worksIntegral;
    }

    public Integer getCaseIntegral() {
        return caseIntegral;
    }

    public void setCaseIntegral(Integer caseIntegral) {
        this.caseIntegral = caseIntegral;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Workscaseintegral{" +
        "id=" + id +
        ", worksIntegral=" + worksIntegral +
        ", caseIntegral=" + caseIntegral +
        "}";
    }
}
