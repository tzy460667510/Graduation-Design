package com.neusoft.graduation.entity;

/**
 * @ClassName Address
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/20 10:42
 * Version 1.0
 **/
public class Address {
    private int addressId;//地址Id
    private int userId;//用户id
    private int userName;//用户姓名
    private String addressDetail;//用户详细地址

    public Address() {
    }

    public Address(int addressId, int userId, int userName, String addressDetail) {
        this.addressId = addressId;
        this.userId = userId;
        this.userName = userName;
        this.addressDetail = addressDetail;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}
