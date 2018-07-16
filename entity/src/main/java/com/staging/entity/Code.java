package com.staging.entity;

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
@TableName("t_code")
public class Code extends Model<Code> {

    private static final long serialVersionUID = 1L;

    private Integer userid;
    private String pincode;
    private String smscode;
    private String bindingEmail;
    private String bindingPhone;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }

    public String getBindingEmail() {
        return bindingEmail;
    }

    public void setBindingEmail(String bindingEmail) {
        this.bindingEmail = bindingEmail;
    }

    public String getBindingPhone() {
        return bindingPhone;
    }

    public void setBindingPhone(String bindingPhone) {
        this.bindingPhone = bindingPhone;
    }

    @Override
    protected Serializable pkVal() {
        return this.userid;
    }

    @Override
    public String toString() {
        return "Code{" +
        "userid=" + userid +
        ", pincode=" + pincode +
        ", smscode=" + smscode +
        ", bindingEmail=" + bindingEmail +
        ", bindingPhone=" + bindingPhone +
        "}";
    }
}
