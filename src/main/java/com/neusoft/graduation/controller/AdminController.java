package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.entity.Role;
import com.neusoft.graduation.service.AdminService;
import com.neusoft.graduation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @Autowired
    private RoleService roleService;

    //管理员列表页面
    @GetMapping("/admins")
    public String adminList(Model model) {
        List<Admin> admins = adminService.queryAllAdmin();
        model.addAttribute("admins", admins);
        return "admin/list";
    }

    @GetMapping("/adminDetail/{adminName}")
    public String toDetailPage(@PathVariable("adminName") String name, Model model) {
        System.out.println(name);
        Admin admin = adminService.queryAdminByAdminName(name);
        System.out.println(admin);
        model.addAttribute("admin", admin);
        return "admin/detail";
    }

    @GetMapping("/adminDetailBySeesion/{loginUser}")
    public String toDetailPage2(@PathVariable("loginUser") String name, Model model) {
        System.out.println(name);
        Admin admin = adminService.queryAdminByAdminName(name);
        System.out.println(admin);
        model.addAttribute("admin", admin);
        return "admin/detail";
    }

    //来到管理员添加页面
    @GetMapping("/adminAdd")
    public String toAddPage(Model model) {
        List<Role> roles = roleService.queryAllRole();
        List<Admin> admins = adminService.queryAllAdmin();
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getRoleName().equals("用户")) {
                roles.remove(i);
            }
        }
        model.addAttribute("roles", roles);
        model.addAttribute("admins", admins);
        return "admin/add";
    }

    //管理员添加
    @PostMapping("/adminAdd")
    public String addAdmin(Admin admin, Model model, Map<String, Object> map) {
        System.out.println(admin);
        List<Role> roles = roleService.queryAllRole();
        for (int i = 0; i < roles.size(); i++) {
            if (roles.get(i).getRoleName().equals(admin.getRoleName())) {
                admin.setRoleId(roles.get(i).getRoleId());
            }
        }
        if (admin.getAdminName().isEmpty()) {
            List<Role> rolex = roleService.queryAllRole();
            for (int i = 0; i < rolex.size(); i++) {
                if (rolex.get(i).getRoleName().equals("用户")) {
                    rolex.remove(i);
                }
            }
            model.addAttribute("rolex", rolex);
            map.put("msg1", "管理员名称不可为空");
            return "admin/add";
        } else if (adminService.queryAdminByAdminName(admin.getAdminName()) != null) {
            map.put("msg2", "管理员已存在");
            List<Role> rolex = roleService.queryAllRole();
            for (int i = 0; i < rolex.size(); i++) {
                if (rolex.get(i).getRoleName().equals("用户")) {
                    rolex.remove(i);
                }
            }
            model.addAttribute("rolex", rolex);
            return "admin/add";
        } else if (admin.getPassword().isEmpty()) {
            List<Role> rolex = roleService.queryAllRole();
            for (int i = 0; i < rolex.size(); i++) {
                if (rolex.get(i).getRoleName().equals("用户")) {
                    rolex.remove(i);
                }
            }
            model.addAttribute("rolex", rolex);
            map.put("msg3", "密码不可为空");
            return "admin/add";
        } else if (admin.getPhone().isEmpty()) {
            List<Role> rolex = roleService.queryAllRole();
            for (int i = 0; i < rolex.size(); i++) {
                if (rolex.get(i).getRoleName().equals("用户")) {
                    rolex.remove(i);
                }
            }
            model.addAttribute("rolex", rolex);
            map.put("msg4", "电话不可为空");
            return "admin/add";
        } else if (admin.getSal() == 0) {
            List<Role> rolex = roleService.queryAllRole();
            for (int i = 0; i < rolex.size(); i++) {
                if (rolex.get(i).getRoleName().equals("用户")) {
                    rolex.remove(i);
                }
            }
            model.addAttribute("rolex", rolex);
            map.put("msg5", "工资不可为空");
            return "admin/add";
        } else if (admin.getRoleName().isEmpty()) {
            List<Role> rolex = roleService.queryAllRole();
            for (int i = 0; i < rolex.size(); i++) {
                if (rolex.get(i).getRoleName().equals("用户")) {
                    rolex.remove(i);
                }
            }
            model.addAttribute("rolex", rolex);
            map.put("msg6", "请选择管理员级别");
            return "admin/add";
        } else {
            adminService.addAdmin(admin);
            return "redirect:/admins";
        }
    }

    //来到修改页面，查出当前管理员信息，在页面回显
    @GetMapping("/adminUpdate/{adminId}")
    public String toEditPage(@PathVariable("adminId") Integer id, Model model) {
        Admin admin = adminService.queryAdminByAdminId(id);
        model.addAttribute("admin", admin);
        System.out.println(admin);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "admin/update";
    }

    //管理员修改；需要提交adminId；
    @PutMapping("/adminUpdate")
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
