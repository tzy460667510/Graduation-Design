package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session) {
        Admin admin = adminService.queryAdminByAdminName(username);
        try {
            if (!StringUtils.isEmpty(username) && admin.getPassword().equals(password)) {
                //登录成功,防止表单重复提交，可以重定向到主页
                session.setAttribute("loginUser",username);
                return "redirect:/main.html";
            }else{
                //登录失败
                map.put("msg","用户名密码错误");
                return "login";
            }
        } catch (Exception e) {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
