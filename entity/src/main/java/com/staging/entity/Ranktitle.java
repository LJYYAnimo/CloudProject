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
@TableName("t_ranktitle")
public class Ranktitle extends Model<Ranktitle> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 经验值起始
     */
    private Integer startExperience;
    /**
     * 经验值结束
     */
    private Integer endExperience;
    /**
     * 头衔
     */
    private String rank;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartExperience() {
        return startExperience;
    }

    public void setStartExperience(Integer startExperience) {
        this.startExperience = startExperience;
    }

    public Integer getEndExperience() {
        return endExperience;
    }

    public void setEndExperience(Integer endExperience) {
        this.endExperience = endExperience;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Ranktitle{" +
        "id=" + id +
        ", startExperience=" + startExperience +
        ", endExperience=" + endExperience +
        ", rank=" + rank +
        "}";
    }
}
