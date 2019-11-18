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
    private String realName;
    private int goodsCount;
    private double sellPrice;
    private int addressId;
    private String addressDetail;
    private String phone;
    private int statue;
    private String orderImg;
    private double orderTotal;
    private String createDate;

    public Order() {
    }

    public Order(int orderId, int userId, String userName, int goodsId, String goodsName, String realName, int goodsCount, double sellPrice, int addressId, String addressDetail, String phone, int statue, String orderImg, double orderTotal, String createDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.userName = userName;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.realName = realName;
        this.goodsCount = goodsCount;
        this.sellPrice = sellPrice;
        this.addressId = addressId;
        this.addressDetail = addressDetail;
        this.phone = phone;
        this.statue = statue;
        this.orderImg = orderImg;
        this.orderTotal = orderTotal;
        this.createDate = createDate;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
                ", realName='" + realName + '\'' +
                ", goodsCount=" + goodsCount +
                ", sellPrice=" + sellPrice +
                ", addressId=" + addressId +
                ", addressDetail='" + addressDetail + '\'' +
                ", phone='" + phone + '\'' +
                ", statue=" + statue +
                ", orderImg='" + orderImg + '\'' +
                ", orderTotal=" + orderTotal +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
