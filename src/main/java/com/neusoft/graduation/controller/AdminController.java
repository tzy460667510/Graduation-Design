package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AdminController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/7 19:48
 * Version 1.0
 **/
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    //管理员列表页面
    @GetMapping("/admins")
    public String adminList(Model model) {
        List<Admin> admins = adminService.queryAllAdmin();
        model.addAttribute("admins", admins);
        return "admin/list";
    }

    //来到管理员添加页面
    @GetMapping("/admin")
    public String toAddPage(Model model) {
        List<Admin> admins = adminService.queryAllAdmin();
        System.out.println(admins);
        model.addAttribute("admins", admins);
        return "admin/add";
    }

    //管理员添加
    @PostMapping("/admin")
    public String addAdmin(Admin admin) {
        System.out.println(admin);
        adminService.addAdmin(admin);
        return "redirect:/admins";
    }

    //来到修改页面，查出当前管理员信息，在页面回显
    @GetMapping("/admin/{adminId}")
    public String toEditPage(@PathVariable("adminId") Integer id, Model model) {
        Admin admin = adminService.queryAdminByAdminId(id);
        model.addAttribute("admin", admin);
        System.out.println(admin);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "admin/add";
    }

    //管理员修改；需要提交adminId；
    @PutMapping("/admin")
    public String updateAdmin(Admin admin) {
        System.out.println("修改的管理员数据：" + admin);
        adminService.updateAdminByAdminId(admin);
        return "redirect:/admins";
    }

    //用户的删除
    @DeleteMapping("/admin/{adminId}")
    public String deleteAdmin(@PathVariable("adminId") Integer id) {
        adminService.deleteAdminByAdminId(id);
        return "redirect:/admins";
    }
}
