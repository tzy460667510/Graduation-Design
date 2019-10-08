package com.neusoft.graduation.service;

import com.neusoft.graduation.entity.Admin;

import java.util.List;

/**
 * @ClassName AdminService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/24 19:55
 * Version 1.0
 **/
public interface AdminService {
    /**
     * 获取管理员列表信息
     * @return
     */
    List<Admin> queryAllAdmin();

    /**
     * 根据管理员id查询管理员
     * @param id
     * @return
     */
    Admin queryAdminByAdminId(int id);

    /**
     * 根据管理员姓名查询管理员
     * @param name
     * @return
     */
    Admin queryAdminByAdminName(String name);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 修改管理员信息
     * @param admin
     * @return
     */
    int updateAdminByAdminId(Admin admin);

    /**
     * 删除管理员信息
     * @param id
     * @return
     */
    int deleteAdminByAdminId(int id);
    /**
     * 管理员登录
     * @param name
     * @param password
     * @return
     */
    Admin AdminLogin(String name,String password);

}
