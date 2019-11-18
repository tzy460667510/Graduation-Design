package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.RoleDao;
import com.neusoft.graduation.entity.Role;
import com.neusoft.graduation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/14 16:24
 * Version 1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryAllRole() {
        return roleDao.queryAllRole();
    }
}
