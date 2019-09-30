package com.neusoft.graduation;

import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName UserTest
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/24 15:34
 * Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void selectTest(){
        System.out.println(userService.queryAllUser());
        System.out.println(userService.queryUserByUserId(1));
        System.out.println(userService.queryUserByUserName("aaa"));
        System.out.println(userService.queryUserByRealName("1111"));
    }

    @Test
    public void addTest(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String sysdate = sdf.format(date);
        User user = new User();
        user.setUserName("aaaa");
        user.setRealName("tzy");
        user.setCreateDate(sysdate);
        System.out.println(userService.addUser(user));
    }

    @Test
    public void editTest(){
        User user = userService.queryUserByUserId(1);
        System.out.println(user);
        user.setUserId(2);
        user.setUserName("bbbb");
        user.setRealName("tdd");
        System.out.println(user);
        System.out.println(userService.updateUserByUserId(user));
    }

    @Test
    public void deleteTest(){
        System.out.println(userService.deleteUserByUserId(3));
    }
}
