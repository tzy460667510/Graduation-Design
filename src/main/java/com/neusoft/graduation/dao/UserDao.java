package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
    List<User> queryAllUser();

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    User queryUserByUserId(int id);

    /**
     * 根据用户姓名查询用户
     * @param name
     * @return
     */
    User queryUserByUserName(String name);

    /**
     * 根据用户真实姓名查询用户
     * @param name
     * @return
     */
    User queryUserByRealName(String name);
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserByUserId(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    int deleteUserByUserId(int id);

}
