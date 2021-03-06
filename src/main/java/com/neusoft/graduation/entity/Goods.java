package com.neusoft.graduation.entity;

/**
 * @ClassName Goods
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/23 16:29
 * Version 1.0
 **/
public class Goods {
    private int goodsId;//商品id
    private String goodsName;//商品名称
    private String goodsImg;//商品图片
    private int categoryId;//类别id关联类别表
    private String categoryName;//类别名称
    private String details;//商品详情
    private double originalPrice;//商品进价
    private double sellPrice;//商品售价
    private int inventory;//库存
    private String createDate;//创建时间

    public Goods() {
    }

    public Goods(int goodsId, String goodsName, String goodsImg, int categoryId, String categoryName, String details, double originalPrice, double sellPrice, int inventory, String createDate) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.details = details;
        this.originalPrice = originalPrice;
        this.sellPrice = sellPrice;
        this.inventory = inventory;
        this.createDate = createDate;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", details='" + details + '\'' +
                ", originalPrice=" + originalPrice +
                ", sellPrice=" + sellPrice +
                ", inventory=" + inventory +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
