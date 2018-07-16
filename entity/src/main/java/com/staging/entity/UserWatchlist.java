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
@TableName("t_user_watchlist")
public class UserWatchlist extends Model<UserWatchlist> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 被关注人id
     */
    private Integer bwatchId;
    /**
     * 关注人id
     */
    private Integer watchId;
    /**
     * 关注时间
     */
    private Date creatDateWatch;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBwatchId() {
        return bwatchId;
    }

    public void setBwatchId(Integer bwatchId) {
        this.bwatchId = bwatchId;
    }

    public Integer getWatchId() {
        return watchId;
    }

    public void setWatchId(Integer watchId) {
        this.watchId = watchId;
    }

    public Date getCreatDateWatch() {
        return creatDateWatch;
    }

    public void setCreatDateWatch(Date creatDateWatch) {
        this.creatDateWatch = creatDateWatch;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "UserWatchlist{" +
        "id=" + id +
        ", bwatchId=" + bwatchId +
        ", watchId=" + watchId +
        ", creatDateWatch=" + creatDateWatch +
        "}";
    }
}
