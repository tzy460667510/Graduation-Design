package com.neusoft.graduation.controller;

import com.neusoft.graduation.dao.UserDao;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/22 18:01
 * Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public User findUser(@RequestParam(value = "userId") Long userId){
        return userService.findById(userId);
    }

}
