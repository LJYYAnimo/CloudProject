package com.staging.entity;

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
@TableName("t_userorder")
public class Userorder extends Model<Userorder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号-主键
     */
    @TableId("order_Id")
    private String orderId;
    /**
     * 订单对应的物品id
     */
    @TableField("order_work_id")
    private String orderWorkId;
    /**
     * 物品数量
     */
    @TableField("order_Num")
    private Integer orderNum;
    /**
     * 作品兑换需要的积分
     */
    @TableField("order_Integral")
    private String orderIntegral;
    /**
     * 订单下单人的id
     */
    @TableField("order_userId")
    private Integer orderUserid;
    /**
     * 订单状态0-购物车 1-未发货 2-已发货 3-确认收货
     */
    @TableField("order_status")
    private String orderStatus;
    /**
     * 订单生成时间
     */
    @TableField("order_time")
    private Date orderTime;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderWorkId() {
        return orderWorkId;
    }

    public void setOrderWorkId(String orderWorkId) {
        this.orderWorkId = orderWorkId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderIntegral() {
        return orderIntegral;
    }

    public void setOrderIntegral(String orderIntegral) {
        this.orderIntegral = orderIntegral;
    }

    public Integer getOrderUserid() {
        return orderUserid;
    }

    public void setOrderUserid(Integer orderUserid) {
        this.orderUserid = orderUserid;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

    @Override
    public String toString() {
        return "Userorder{" +
        "orderId=" + orderId +
        ", orderWorkId=" + orderWorkId +
        ", orderNum=" + orderNum +
        ", orderIntegral=" + orderIntegral +
        ", orderUserid=" + orderUserid +
        ", orderStatus=" + orderStatus +
        ", orderTime=" + orderTime +
        "}";
    }
}
