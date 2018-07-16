package com.staging.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("t_city")
public class City extends Model<City> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，市id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 市名
     */
    private String cname;
    /**
     * 市级横幅
     */
    @TableField("city_banner")
    private String cityBanner;
    /**
     * 市级logo
     */
    @TableField("city_logo")
    private String cityLogo;
    /**
     * 关联省级表的id
     */
    private Integer pid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCityBanner() {
        return cityBanner;
    }

    public void setCityBanner(String cityBanner) {
        this.cityBanner = cityBanner;
    }

    public String getCityLogo() {
        return cityLogo;
    }

    public void setCityLogo(String cityLogo) {
        this.cityLogo = cityLogo;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "City{" +
        "id=" + id +
        ", cname=" + cname +
        ", cityBanner=" + cityBanner +
        ", cityLogo=" + cityLogo +
        ", pid=" + pid +
        "}";
    }
}
