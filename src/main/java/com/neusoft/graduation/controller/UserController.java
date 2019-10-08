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
    public String userList(Model model){
        List<User> users = userService.queryAllUser();
        //放在请求域中
        model.addAttribute("users",users);
        //thymeleaf默认就会拼串
        return "user/list";
    }

    //来到用户添加页面
    @GetMapping("/user")
    public String toAddPage(Model model){
        List<User> users = userService.queryAllUser();
        model.addAttribute("users",users);
        return "user/add";
    }

    //用户添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定：要求了请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/user")
    public String addUser(User user){
        //保存于用户
        userService.addUser(user);
        //redirect:重定向到一个地址 /代表当前项目路径
        //forward:表示转发到一个地址
        return "redirect:/users";
    }

    //来到修改页面，查出当前用户，在页面回显
    @GetMapping("/user/{userId}")
    public String toEditPage(@PathVariable("userId") Integer id,Model model){
        User user = userService.queryUserByUserId(id);
        model.addAttribute("user",user);
        System.out.println(user);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "user/add";
    }

    //用户修改；需要提交userId；
    @PutMapping("/user")
    public String updateUser(User user){
        System.out.println("修改的用户数据："+user);
        userService.updateUserByUserId(user);
        return "redirect:/users";
    }

    //用户的删除
    @DeleteMapping("/user/{userId}")
    public String deleteEmployee(@PathVariable("userId") Integer id){
        userService.deleteUserByUserId(id);
        return "redirect:/users";
    }
}
