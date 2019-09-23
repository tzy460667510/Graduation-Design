package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/22 16:09
 * Version 1.0
 **/
@Component
public interface UserDao {
    /**
     * 获取用户列表信息
     * @return
     */
    public List<User> findAllUser();

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 根据用户姓名查询用户
     * @param name
     * @return
     */
    public User findUserByName(String name);
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int AddUser(User user);

    List<User> findAll();
    User findById(Long id);
}
