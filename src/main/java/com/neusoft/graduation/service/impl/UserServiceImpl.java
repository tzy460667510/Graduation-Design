package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.UserDao;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/23 11:16
 * Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public User queryUserByUserId(int id) {
        return userDao.queryUserByUserId(id);
    }

    @Override
    public User queryUserByUserName(String name) {
        return userDao.queryUserByUserName(name);
    }

    @Override
    public User queryUserByRealName(String name) {
        return userDao.queryUserByRealName(name);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUserByUserId(User user) {
        return userDao.updateUserByUserId(user);
    }

    @Override
    public int deleteUserByUserId(int id) {
        return userDao.deleteUserByUserId(id);
    }
}
