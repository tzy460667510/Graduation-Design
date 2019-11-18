package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.AdminService;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/26 15:20
 * Version 1.0
 **/
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Map<String, Object> map, HttpSession session) {
        Admin admin = adminService.queryAdminByAdminName(username);
        try {
            if (!StringUtils.isEmpty(username) && admin.getPassword().equals(password)) {
                //登录成功,防止表单重复提交，可以重定向到主页
                session.setAttribute("loginUser", username);
                System.out.println("登录成功");
                return "redirect:/main.html";
            } else {
                //登录失败
                map.put("msg", "用户名密码错误");
                return "login";
            }
        } catch (Exception e) {
            //登录失败
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

    @GetMapping("/client/tologin")
    public String touserLogin() {
        return "client/login";
    }

    @PostMapping("/client/user/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            Map<String, Object> map, HttpSession session) {
        User user = userService.queryUserByUserName(username);
        try {
            if (!StringUtils.isEmpty(username) && user.getPassword().equals(password)) {
                //登录成功,防止表单重复提交，可以重定向到主页
                session.setAttribute("loginUser", username);
                System.out.println("登录成功");
                return "redirect:/client";
            } else {
                //登录失败
                map.put("msg", "用户名密码错误");
                return "client/login";
            }
        } catch (Exception e) {
            //登录失败
            map.put("msg", "用户名密码错误");
            return "client/login";
        }
    }

    @GetMapping("/client/toregister")
    public String touserRegister() {
        return "client/register";
    }

    @PostMapping("/client/user/register")
    public String addUser(User user, Map<String, Object> map, Model model) {
        System.out.println(user);
        userService.addUser(user);
        return "client/login";
    }
}
