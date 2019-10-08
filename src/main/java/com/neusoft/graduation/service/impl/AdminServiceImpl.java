package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.AdminDao;
import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/24 19:58
 * Version 1.0
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> queryAllAdmin() {
        return adminDao.queryAllAdmin();
    }

    @Override
    public Admin queryAdminByAdminId(int id) {
        return adminDao.queryAdminByAdminId(id);
    }

    @Override
    public Admin queryAdminByAdminName(String name) {
        return adminDao.queryAdminByAdminName(name);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.addAdmin(admin);
    }

    @Override
    public int updateAdminByAdminId(Admin admin) {
        return adminDao.updateAdminByAdminId(admin);
    }

    @Override
    public int deleteAdminByAdminId(int id) {
        return adminDao.deleteAdminByAdminId(id);
    }

    @Override
    public Admin AdminLogin(String name, String password) {
        return adminDao.AdminLogin(name,password);
    }
}
