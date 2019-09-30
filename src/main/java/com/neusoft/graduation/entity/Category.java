package com.neusoft.graduation.entity;

/**
 * @ClassName category
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/22 11:42
 * Version 1.0
 **/
public class Category {
    private int categoryId;//商品类别id
    private String categoryName;//商品类别名称

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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
}
