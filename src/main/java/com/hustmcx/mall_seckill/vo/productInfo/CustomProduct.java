package com.hustmcx.mall_seckill.vo.productInfo;

import com.hustmcx.mall_seckill.model.ProductInfo;

public class CustomProduct extends ProductInfo {
    private int startSkPrice;//秒杀价格 查询范围开始
    private int endSkPrice;//秒杀价格 查询范围结束

    private int startOriginalPrice;//商品原价 查询范围开始
    private int endOriginalPrice;//商品原价 查询范围结束

    private String startApplyDate;//申请时间 查询范围开始时间
    private String endApplyDate;//申请时间 查询范围结束时间

    private String startAuditDate;//审核时间 查询范围开始时间
    private String endAuditDate;//审核时间 查询范围结束时间

    private String startStartTime;//秒杀开始时间 查询范围开始时间
    private String endStartTime;//秒杀开始时间 查询范围结束时间

    private String startEndTime;//秒杀结束时间 查询范围开始时间
    private String endEndTime;//秒杀结束时间 查询范围结束时间

    private int startProductCount;//秒杀商品数 开始范围
    private int endProductCount;//秒杀商品数 结束范围

    private int startStockCount;//库存 开始范围
    private int endStockCount;//库存结 束范围

    public int getStartSkPrice() {
        return startSkPrice;
    }

    public void setStartSkPrice(int startSkPrice) {
        this.startSkPrice = startSkPrice;
    }

    public int getEndSkPrice() {
        return endSkPrice;
    }

    public void setEndSkPrice(int endSkPrice) {
        this.endSkPrice = endSkPrice;
    }

    public int getStartOriginalPrice() {
        return startOriginalPrice;
    }

    public void setStartOriginalPrice(int startOriginalPrice) {
        this.startOriginalPrice = startOriginalPrice;
    }

    public int getEndOriginalPrice() {
        return endOriginalPrice;
    }

    public void setEndOriginalPrice(int endOriginalPrice) {
        this.endOriginalPrice = endOriginalPrice;
    }

    public String getStartApplyDate() {
        return startApplyDate;
    }

    public void setStartApplyDate(String startApplyDate) {
        this.startApplyDate = startApplyDate;
    }

    public String getEndApplyDate() {
        return endApplyDate;
    }

    public void setEndApplyDate(String endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    public String getStartAuditDate() {
        return startAuditDate;
    }

    public void setStartAuditDate(String startAuditDate) {
        this.startAuditDate = startAuditDate;
    }

    public String getEndAuditDate() {
        return endAuditDate;
    }

    public void setEndAuditDate(String endAuditDate) {
        this.endAuditDate = endAuditDate;
    }

    public String getStartStartTime() {
        return startStartTime;
    }

    public void setStartStartTime(String startStartTime) {
        this.startStartTime = startStartTime;
    }

    public String getEndStartTime() {
        return endStartTime;
    }

    public void setEndStartTime(String endStartTime) {
        this.endStartTime = endStartTime;
    }

    public String getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(String startEndTime) {
        this.startEndTime = startEndTime;
    }

    public String getEndEndTime() {
        return endEndTime;
    }

    public void setEndEndTime(String endEndTime) {
        this.endEndTime = endEndTime;
    }

    public int getStartProductCount() {
        return startProductCount;
    }

    public void setStartProductCount(int startProductCount) {
        this.startProductCount = startProductCount;
    }

    public int getEndProductCount() {
        return endProductCount;
    }

    public void setEndProductCount(int endProductCount) {
        this.endProductCount = endProductCount;
    }

    public int getStartStockCount() {
        return startStockCount;
    }

    public void setStartStockCount(int startStockCount) {
        this.startStockCount = startStockCount;
    }

    public int getEndStockCount() {
        return endStockCount;
    }

    public void setEndStockCount(int endStockCount) {
        this.endStockCount = endStockCount;
    }

    @Override
    public String toString() {
        return "CustomProduct{" +
                "startSkPrice=" + startSkPrice +
                ", endSkPrice=" + endSkPrice +
                ", startOriginalPrice=" + startOriginalPrice +
                ", endOriginalPrice=" + endOriginalPrice +
                ", startApplyDate='" + startApplyDate + '\'' +
                ", endApplyDate='" + endApplyDate + '\'' +
                ", startAuditDate='" + startAuditDate + '\'' +
                ", endAuditDate='" + endAuditDate + '\'' +
                ", startStartTime='" + startStartTime + '\'' +
                ", endStartTime='" + endStartTime + '\'' +
                ", startEndTime='" + startEndTime + '\'' +
                ", endEndTime='" + endEndTime + '\'' +
                ", startProductCount=" + startProductCount +
                ", endProductCount=" + endProductCount +
                ", startStockCount=" + startStockCount +
                ", endStockCount=" + endStockCount +
                '}';
    }
}
