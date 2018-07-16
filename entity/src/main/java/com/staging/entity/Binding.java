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
@TableName("t_binding")
public class Binding extends Model<Binding> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 绑定的邮箱
     */
    @TableField("binding_email")
    private String bindingEmail;
    /**
     * 绑定的手机号码
     */
    @TableField("binding_phone")
    private String bindingPhone;
    /**
     * 关联用户id
     */
    private Integer userid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Binding{" +
        "id=" + id +
        ", bindingEmail=" + bindingEmail +
        ", bindingPhone=" + bindingPhone +
        ", userid=" + userid +
        "}";
    }
}
