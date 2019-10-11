package com.neusoft.graduation.controller;

import com.neusoft.graduation.dao.UserDao;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/22 18:01
 * Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //查询所有用户返回列表页面
    @GetMapping("/users")
    public String userList(Model model) {
        List<User> users = userService.queryAllUser();
        //放在请求域中
        model.addAttribute("users", users);
        //thymeleaf默认就会拼串
        return "user/list";
    }

    @GetMapping("/userDetail/{userName}")
    public String toDetailPage(@PathVariable("userName") String name, Model model) {
        System.out.println(name);
        User user = userService.queryUserByUserName(name);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user/detail";
    }

    @GetMapping("/userDetail")
    public String goodsDetail(@PathVariable("userName") String name, Model model) {
        User user = userService.queryUserByUserName(name);
        model.addAttribute("user", user);
        return "user/detail";
    }

    //来到用户添加页面
    @GetMapping("/userAdd")
    public String toAddPage(Model model) {
        List<User> users = userService.queryAllUser();
        model.addAttribute("users", users);
        return "user/add";
    }

    //用户添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定：要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/userAdd")
    public String addUser(User user, Map<String, Object> map) {
        String userName = user.getUserName();
        userService.addUser(user);
        return "redirect:/users";

    }

    //来到修改页面，查出当前用户，在页面回显
    @GetMapping("/userUpdate/{userId}")
    public String toEditPage(@PathVariable("userId") Integer id, Model model) {
        User user = userService.queryUserByUserId(id);
        model.addAttribute("user", user);
        System.out.println(user);
        return "user/update";
    }

    //用户修改；需要提交userId；
    @PutMapping("/userUpdate")
    public String updateUser(User user) {
        System.out.println("修改后的用户数据：" + user);
        userService.updateUserByUserId(user);
        return "redirect:/users";
    }

    //用户的删除
    @DeleteMapping("/user/{userId}")
    public String deleteEmployee(@PathVariable("userId") Integer id) {
        userService.deleteUserByUserId(id);
        return "redirect:/users";
    }
}
