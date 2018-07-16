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
@TableName("t_logo_button")
public class LogoButton extends Model<LogoButton> {

    private static final long serialVersionUID = 1L;

    /**
     * 0为全部放行，1不放行
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 按钮标识id，0为未审核，与审核通过的放行，1审核通过的放行
     */
    @TableField("button_id")
    private Integer buttonId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getButtonId() {
        return buttonId;
    }

    public void setButtonId(Integer buttonId) {
        this.buttonId = buttonId;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LogoButton{" +
        "id=" + id +
        ", buttonId=" + buttonId +
        "}";
    }
}
