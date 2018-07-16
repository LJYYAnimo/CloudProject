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
@TableName("t_province")
public class Province extends Model<Province> {

    private static final long serialVersionUID = 1L;

    /**
     * 省id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 省名
     */
    @TableField("province_name")
    private String provinceName;
    /**
     * 省的横幅
     */
    @TableField("province_banner")
    private String provinceBanner;
    /**
     * 省的logo
     */
    @TableField("province_logo")
    private String provinceLogo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceBanner() {
        return provinceBanner;
    }

    public void setProvinceBanner(String provinceBanner) {
        this.provinceBanner = provinceBanner;
    }

    public String getProvinceLogo() {
        return provinceLogo;
    }

    public void setProvinceLogo(String provinceLogo) {
        this.provinceLogo = provinceLogo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Province{" +
        "id=" + id +
        ", provinceName=" + provinceName +
        ", provinceBanner=" + provinceBanner +
        ", provinceLogo=" + provinceLogo +
        "}";
    }
}
