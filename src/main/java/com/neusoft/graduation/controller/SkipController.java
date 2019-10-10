package com.neusoft.graduation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SkipController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/10 11:40
 * Version 1.0
 **/
@Controller
public class SkipController {
    @ResponseBody
    @RequestMapping("/good")
    public String goodsDetail(){
        return "good/detail";
    }
}
