package com.neusoft.graduation.service;

import com.neusoft.graduation.dao.UserDao;
import com.neusoft.graduation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/22 18:39
 * Version 1.0
 **/
public interface UserService {

    public List<User> findAll();

    public User findById(Long id);
}
