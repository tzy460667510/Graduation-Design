package com.neusoft.graduation.controller;

import com.neusoft.graduation.component.DesEncryption;
import com.neusoft.graduation.component.Email;
import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.entity.Order;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.GoodsService;
import com.neusoft.graduation.service.OrderService;
import com.neusoft.graduation.service.UserService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Session;
import java.util.List;

/**
 * @ClassName EmailController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/11/19 21:45
 * Version 1.0
 **/
@Controller
public class EmailController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderService orderService;

    String title = "小菜菜网来信啦！";

    @GetMapping("/emails")
    public String toEmailPage(Model model) {
        List<User> users = userService.queryAllUser();
        model.addAttribute("users", users);
        return "email/list";
    }

    @GetMapping("/emails/{userName}")
    public String sendEmail(@PathVariable("userName") String name){
        User user = userService.queryUserByUserName(name);
        Goods goods = goodsService.queryGoodsByGoodsName("猪肉");
        Email email = new Email();
        List<Order> orders = orderService.queryOrderByUserName(name);
//        if (orders.isEmpty()){
            String msg="尊敬的"+user.getUserName()+"您好！" +"\n"+
                    "您喜欢的猪肉涨价啦！还不赶紧来买？"+"\n";
            try {
                email.sendEmail(user.getEmail(),title,msg);
            } catch (Exception e) {
                System.out.println("发送失败");
            }
//        }else {
//            String gs="";
//            for (int i = 0; i < orders.size(); i++) {
//                gs=gs+","+orders.get(i).getGoodsName();
//                System.out.println(gs);
//            }
//        }
        return "redirect:/emails";
    }

    @GetMapping("/emails/emailAll")
    public String sendEmailAll(){
        List<User> users = userService.queryAllUser();
        Email email = new Email();
        for (int i = 0; i < users.size(); i++) {
            String msg="尊敬的"+users.get(i).getUserName()+"您好！" +"\n"+
                    "您喜欢的猪肉涨价啦！还不赶紧来买？"+"\n";
            try {
                email.sendEmail(users.get(i).getEmail(),title,msg);
            } catch (Exception e) {
                System.out.println("发送失败");
            }
        }
        return "redirect:/emails";
    }

}
