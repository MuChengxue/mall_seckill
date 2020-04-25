package com.hustmcx.mall_seckill.model;


import java.util.Date;

public class ProductInfo {
//    id product_id product_title product_pic original_price kill_price seller_id add_time
//    audit_time audit_state start_time  end_time product_count store_count description

    private int id;
    private int productId;
    private String productTitle;
    private String productPic;
    private int originalPrice;
    private int killPrice;
    private int sellerId;
    private Date applyTime;
    private Date auditTime;
    private int auditState;//1 未审核；2 审核通过；3 审核不通过

    private Date startTime;
    private Date endTime;
    private String startTimeString;
    private String endTimeString;

    private int productCount;
    private int storeCount;
    private String description;


    public String getStartTimeString() {
        return startTimeString;
    }

    public void setStartTimeString(String startTimeString) {
        this.startTimeString = startTimeString;
    }

    public String getEndTimeString() {
        return endTimeString;
    }

    public void setEndTimeString(String endTimeString) {
        this.endTimeString = endTimeString;
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

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public int getKillPrice() {
        return killPrice;
    }

    public void setKillPrice(int killPrice) {
        this.killPrice = killPrice;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(int storeCount) {
        this.storeCount = storeCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductInfo{" +
                "id=" + id +
                ", productId=" + productId +
                ", productTitle='" + productTitle + '\'' +
                ", productPic='" + productPic + '\'' +
                ", originalPrice=" + originalPrice +
                ", killPrice=" + killPrice +
                ", sellerId=" + sellerId +
                ", addTime=" + applyTime +
                ", auditTime=" + auditTime +
                ", auditState=" + auditState +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", productCount=" + productCount +
                ", storeCount=" + storeCount +
                ", description='" + description + '\'' +
                '}';
    }
}
