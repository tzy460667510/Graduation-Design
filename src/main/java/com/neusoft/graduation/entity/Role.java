package com.neusoft.graduation.entity;

/**
 * @ClassName Role
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/20 10:40
 * Version 1.0
 **/
public class Role {
    private int roleId;//角色id
    private String roleName;//角色名称

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
