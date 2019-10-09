package com.neusoft.graduation.entity;

/**
 * @ClassName Order
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/9 21:20
 * Version 1.0
 **/
public class Order {
    private int orderId;
    private int userId;
    private String userName;
    private int goodsId;
    private String goodsName;
    private int goodsCount;
    private int addressId;
    private String addressDetail;
    private int statue;
    private String orderImg;
    private double orderTotal;
    private String createDate;

    public Order() {
    }

    public Order(int orderId, int userId, String userName, int goodsId, String goodsName, int goodsCount, int addressId, String addressDetail, int statue, String orderImg, double orderTotal, String createDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.userName = userName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCount = goodsCount;
        this.addressId = addressId;
        this.addressDetail = addressDetail;
        this.statue = statue;
        this.orderImg = orderImg;
        this.orderTotal = orderTotal;
        this.createDate = createDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public String getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(String orderImg) {
        this.orderImg = orderImg;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCount=" + goodsCount +
                ", addressId=" + addressId +
                ", addressDetail='" + addressDetail + '\'' +
                ", statue=" + statue +
                ", orderImg='" + orderImg + '\'' +
                ", orderTotal=" + orderTotal +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
