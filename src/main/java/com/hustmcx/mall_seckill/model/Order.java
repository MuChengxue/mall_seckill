package com.hustmcx.mall_seckill.model;

import java.util.Date;

public class Order {

    private int id;//主键
    private int productId;//秒杀商品id
    private int payAmount;//支付金额
    private int userId;//用户id
    private int sellerId;//商家id
    private Date createTime;//创建时间
    private Date payTime;//支付时间
    private int payStatus;//支付转态 1,未支付 2,已支付，3，退款成功,4。用户发起退款申请 5，退款失败
    private String receiveAddress;//收货人地址
    private String receiveName;//收货人姓名
    private String receivePhone;//收货人电话
    private String transactionSerial;//交易流水号
    private int orderAmount;//数量
    private int payType;//1代表支付宝  2代表微信  3代表银联

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", payAmount=" + payAmount +
                ", userId=" + userId +
                ", sellerId=" + sellerId +
                ", createTime=" + createTime +
                ", payTime=" + payTime +
                ", payStatus=" + payStatus +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", receiveName='" + receiveName + '\'' +
                ", receivePhone='" + receivePhone + '\'' +
                ", transactionSerial='" + transactionSerial + '\'' +
                ", orderAmount=" + orderAmount +
                ", payType=" + payType +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    public String getTransactionSerial() {
        return transactionSerial;
    }

    public void setTransactionSerial(String transactionSerial) {
        this.transactionSerial = transactionSerial;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }
}
