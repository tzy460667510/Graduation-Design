package com.neusoft.graduation.controller;

import com.neusoft.graduation.component.DesEncryption;
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
    @Autowired
    private DesEncryption desEncryption;

    //查询所有用户返回列表页面
    @GetMapping("/users")
    public String userList(Model model) {
        List<User> users = userService.queryAllUser();
        for (int i = 0; i < users.size(); i++) {
            String password = users.get(i).getPassword();
            String despassword = desEncryption.encryptBasedDes(password);
            users.get(i).setPassword(despassword);
        }
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
    public String addUser(User user, Map<String, Object> map, Model model) {
        if (user.getUserName().isEmpty()) {
            map.put("msg1", "用户名不可为空");
            return "user/add";
        } else if (userService.queryUserByUserName(user.getUserName()) != null) {
            map.put("msg2", "用户名已存在");
            return "user/add";
        } else if (user.getPassword().isEmpty()) {
            map.put("msg3", "用户密码不可为空");
            model.addAttribute("user", user);
            return "user/add";
        } else if (user.getRealName().isEmpty()) {
            map.put("msg4", "用户真实姓名不可为空");
            return "user/add";
        } else if (user.getAddress().isEmpty()) {
            map.put("msg5", "用户地址不可为空");
            return "user/add";
        } else if (user.getEmail().isEmpty()) {
            map.put("msg6", "用户邮箱不可为空");
            return "user/add";
        } else if (user.getPhone().isEmpty()) {
            map.put("msg7", "用户电话不可为空");
            return "user/add";
        } else {
            userService.addUser(user);
            return "redirect:/users";
        }
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

    @GetMapping("")
    public String toClientUser() {
        return null;
    }
}
