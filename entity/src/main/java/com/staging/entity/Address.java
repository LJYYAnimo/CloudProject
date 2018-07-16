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
@TableName("t_address")
public class Address extends Model<Address> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 县级
     */
    @TableField("school_address")
    private String schoolAddress;
    /**
     * 对应市的id
     */
    private Integer cid;
    /**
     * 区县横幅
     */
    @TableField("address_banner")
    private String addressBanner;
    /**
     * 区县logo
     */
    @TableField("address_logo")
    private String addressLogo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getAddressBanner() {
        return addressBanner;
    }

    public void setAddressBanner(String addressBanner) {
        this.addressBanner = addressBanner;
    }

    public String getAddressLogo() {
        return addressLogo;
    }

    public void setAddressLogo(String addressLogo) {
        this.addressLogo = addressLogo;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Address{" +
        "id=" + id +
        ", schoolAddress=" + schoolAddress +
        ", cid=" + cid +
        ", addressBanner=" + addressBanner +
        ", addressLogo=" + addressLogo +
        "}";
    }
}
