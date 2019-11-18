package com.neusoft.graduation.entity;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/11 19:44
 * Version 1.0
 **/
public class Admin {
    private int adminId;//管理员id
    private String adminName;//管理员平台昵称
    private String password;//密码
    private int roleId;//角色Id，与Role表相连
    private String roleName;
    private String phone;//电话--便于后期短信验证
    private double sal;//管理员工资--各级别管理员工资不同
    private String createDate;//创建时间--为了后期计算工资
//    private String remark1;//备注1
//    private String remark2;//备注2
//    private String remark3;//备注3

    public Admin() {
    }

//    public Admin(int adminId, String adminName, String password, int roleId, String roleName, String phone, double sal, String createDate, String remark1, String remark2, String remark3) {
//        this.adminId = adminId;
//        this.adminName = adminName;
//        this.password = password;
//        this.roleId = roleId;
//        this.roleName = roleName;
//        this.phone = phone;
//        this.sal = sal;
//        this.createDate = createDate;
//        this.remark1 = remark1;
//        this.remark2 = remark2;
//        this.remark3 = remark3;
//    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public String getRemark1() {
//        return remark1;
//    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

//    public void setRemark1(String remark1) {
//        this.remark1 = remark1;
//    }
//
//    public String getRemark2() {
//        return remark2;
//    }
//
//    public void setRemark2(String remark2) {
//        this.remark2 = remark2;
//    }
//
//    public String getRemark3() {
//        return remark3;
//    }
//
//    public void setRemark3(String remark3) {
//        this.remark3 = remark3;
//    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", phone='" + phone + '\'' +
                ", sal=" + sal +
                ", createDate='" + createDate + '\'' +
//                ", remark1='" + remark1 + '\'' +
//                ", remark2='" + remark2 + '\'' +
//                ", remark3='" + remark3 + '\'' +
                '}';
    }
}
