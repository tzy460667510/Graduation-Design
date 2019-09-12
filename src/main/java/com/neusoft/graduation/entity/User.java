package com.neusoft.graduation.entity;

/**
 * @ClassName User
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/11 19:41
 * Version 1.0
 **/
public class User {
    private int userId;//用户Id
    private String userName;//用户的平台昵称
    private String password;//密码
    private String realName;//真实姓名
    private String address;//地址--区别于收货地址
    private String email;//邮箱--便于后期邮箱验证
    private String phone;//电话--便于后期短信验证
    private String createDate;//创建日期
    private String sculpture;//头像地址url
    private int roleId;//角色Id，与Role表相连
    private int addressId;//收货地址Id，与Address表相连
    private String remark1;//备注1
    private String remark2;//备注2
    private String remark3;//备注3

    public User() {
    }

    public User(int userId, String userName, String password, String realName, String address, String email, String phone, String createDate, String sculpture, int roleId, int addressId, String remark1, String remark2, String remark3) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.createDate = createDate;
        this.sculpture = sculpture;
        this.roleId = roleId;
        this.addressId = addressId;
        this.remark1 = remark1;
        this.remark2 = remark2;
        this.remark3 = remark3;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getSculpture() {
        return sculpture;
    }

    public void setSculpture(String sculpture) {
        this.sculpture = sculpture;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createDate='" + createDate + '\'' +
                ", sculpture='" + sculpture + '\'' +
                ", roleId=" + roleId +
                ", addressId=" + addressId +
                ", remark1='" + remark1 + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", remark3='" + remark3 + '\'' +
                '}';
    }
}
