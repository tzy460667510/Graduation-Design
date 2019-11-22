package com.neusoft.graduation.controller;

import com.neusoft.graduation.component.GoogleAuthenticator;
import com.neusoft.graduation.component.PhoneCode;
import com.neusoft.graduation.component.Weather;
import com.neusoft.graduation.entity.Address;
import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static com.neusoft.graduation.component.Weather.getTodayWeather2;

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
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/login")
    public String toServerLogin() {
        return "login";
    }

    @PostMapping("/user/login")
    public String adminLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("otp") long otp,
                             Map<String, Object> map, HttpSession session,
                             Model model) {
        Admin admin = adminService.queryAdminByAdminName(username);
        try {
            if (!StringUtils.isEmpty(username) && admin.getPassword().equals(password)) {
                String secret = "4FT5QLKJ2BJVEKGO";
                long code = otp;
                long t = System.currentTimeMillis();
                GoogleAuthenticator ga = new GoogleAuthenticator();
                ga.setWindowSize(5);
                boolean r = ga.check_code(secret, code, t);
                System.out.println("检查code是否正确？" + r);
                if (r) {
                    //登录成功,防止表单重复提交，可以重定向到主页
                    session.setAttribute("loginUser", username);
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                    Map<String, Object> map2 = getTodayWeather2("101190101");
                    String wstr = df.format(new Date()) + "   " + map2.get("city") + "   " + map2.get("temp1")
                            + "~" + map2.get("temp2") + "\t" + map2.get("weather");
                    session.setAttribute("wstr", wstr);
                    System.out.println(wstr);
                    System.out.println("登录成功");
                    return "redirect:/main.html";
                } else {
                    //登录失败
                    map.put("msg", "动态验证码错误");
                    return "login";
                }
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
    public String addUser(User user, Map<String, Object> map, Model model,String duanxin) {
        System.out.println(user);
        String code = PhoneCode.code;
        System.out.println(code);
        if (duanxin.isEmpty()){
            PhoneCode.getPhonemsg(user.getPhone());
            model.addAttribute("user",user);
            return "client/register";
        }else{

            if (code.equals(duanxin)){
                Address address = new Address();
                address.setUserId(user.getUserId());
                address.setUserName(user.getUserName());
                address.setAddressDetail(user.getAddress());
                addressService.addAdress(address);
                userService.addUser(user);
                return "client/login";
            }else{
                model.addAttribute("user",user);
                return "client/register";
            }
        }
    }
}
