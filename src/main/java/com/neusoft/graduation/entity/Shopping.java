package com.neusoft.graduation.entity;

/**
 * @ClassName Shopping
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/25 20:10
 * Version 1.0
 **/
public class Shopping {
    private int shoppingId;
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
    private String shoppingImg;
    private double shoppingTotal;
    private String createDate;

    public Shopping() {
    }

    public Shopping(int shoppingId, int userId, String userName, int goodsId, String goodsName, String realName, int goodsCount, double sellPrice, int addressId, String addressDetail, String phone, int statue, String shoppingImg, double shoppingTotal, String createDate) {
        this.shoppingId = shoppingId;
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
        this.shoppingImg = shoppingImg;
        this.shoppingTotal = shoppingTotal;
        this.createDate = createDate;
    }

    public int getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(int shoppingId) {
        this.shoppingId = shoppingId;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public String getShoppingImg() {
        return shoppingImg;
    }

    public void setShoppingImg(String shoppingImg) {
        this.shoppingImg = shoppingImg;
    }

    public double getShoppingTotal() {
        return shoppingTotal;
    }

    public void setShoppingTotal(double shoppingTotal) {
        this.shoppingTotal = shoppingTotal;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "shoppingId=" + shoppingId +
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
                ", shoppingImg='" + shoppingImg + '\'' +
                ", shoppingTotal=" + shoppingTotal +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
