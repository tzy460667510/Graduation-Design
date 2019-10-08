package com.neusoft.graduation;

import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName AdminTest
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/24 20:07
 * Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void selectTest(){
        System.out.println(adminService.queryAllAdmin());
        System.out.println(adminService.queryAdminByAdminId(1));
        System.out.println(adminService.queryAdminByAdminName("Tzy"));
    }

    @Test
    public void addTest(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        String sysdate = sdf.format(date);
        Admin admin = new Admin();
        admin.setAdminName("Boss");
        admin.setPassword("123456");
        admin.setCreateDate(sysdate);
        System.out.println(adminService.addAdmin(admin));
    }

    @Test
    public void editTest(){
        Admin admin = adminService.queryAdminByAdminId(1);
        System.out.println(admin);
        admin.setAdminName("Tzy");
        admin.setPassword("899");
        System.out.println(admin);
        System.out.println(adminService.updateAdminByAdminId(admin));
    }

    @Test
    public void deleteTest(){
        System.out.println(adminService.deleteAdminByAdminId(2));
    }

    @Test
    public void loginTest(){
        Admin tzy = adminService.queryAdminByAdminName("Tzy");
//        Admin tzy = adminService.AdminLogin("Tzy", "899");
        System.out.println(tzy);
    }
}
