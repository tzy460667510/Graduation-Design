package com.neusoft.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/26 14:19
 * Version 1.0
 **/
@Controller
public class HelloController {

//    @RequestMapping({"/", "/index.html"})
//    public String index(){
//        return "index";
//    }

//    public String hello(@RequestParam("user") String user) {
//        System.out.println("gugugu");
//        if (user.equals("aaa")){
//            throw new UserNotExistException();
//        }
//        return "HelloWorld";
//    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
