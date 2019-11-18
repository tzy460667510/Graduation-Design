package com.neusoft.graduation.controller;


import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.entity.Shopping;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.GoodsService;
import com.neusoft.graduation.service.ShoppingService;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName ShoppingController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/25 20:24
 * Version 1.0
 **/
@Controller
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    @GetMapping("/ShoppingDetail/ReturnIndex")
    public String toShoppingPage() {
        return "client/login";
    }

    @GetMapping("/ShoppingDetail/{loginUser}")
    public String toShoppingPage(@PathVariable("loginUser") String name, HttpSession session,
                                 Model model) {
        List<Shopping> shoppings = shoppingService.queryShoppingByUserName(name);
        if(!shoppings.isEmpty()){
            model.addAttribute("shoppings", shoppings);
            session.setAttribute("loginUser", name);
        }
        return "client/shopping";
    }

    @PostMapping("/clientShoppingAdd/{loginUser}")
    public String shoppingAdd(@PathVariable("loginUser") String name,
                              @RequestParam("goodsName") String goodsName,
                              @RequestParam("goodsCount") int count,
                              Model model) {
        Goods goods = goodsService.queryGoodsByGoodsName(goodsName);
        Shopping shopping = new Shopping();
        User user = userService.queryUserByUserName(name);
        shopping.setGoodsId(goods.getGoodsId());
        shopping.setUserName(name);
        shopping.setGoodsName(goods.getGoodsName());
        shopping.setGoodsCount(count);
        shopping.setSellPrice(goods.getSellPrice());
        List<Shopping> shoppings = shoppingService.queryShoppingByUserName(name);
        boolean flag = false;
        Shopping shopping1 = null;
        for (int i = 0; i < shoppings.size(); i++) {
            if (shoppings.get(i).getGoodsName().equals(goods.getGoodsName())){
                int goodsCount = shoppings.get(i).getGoodsCount()+count;
                double totalPrice = shoppings.get(i).getSellPrice()*goodsCount;
                shoppings.get(i).setShoppingTotal(totalPrice);
                shoppings.get(i).setGoodsCount(goodsCount);
                shopping1 = shoppings.get(i);
                flag=true;
            }
        }
        if (flag){
            shoppingService.updateShoppingByShoppingId(shopping1);
        }else{
            shopping.setShoppingTotal(shopping.getGoodsCount()*shopping.getSellPrice());
            shoppingService.addShopping(shopping);
        }
        List<Shopping> shoppings1 = shoppingService.queryShoppingByUserName(name);
        model.addAttribute("shoppings", shoppings1);
        return "client/shopping";
    }

    @GetMapping("/client/deleteShoppingByGoodsName")
    public String ShoppingDeleteOneGoods(Model model,String loginUser,String goodsName){
        shoppingService.deleteShoppingByGoodsName(goodsName,loginUser);
        List<Shopping> shoppings = shoppingService.queryShoppingByUserName(loginUser);
        model.addAttribute("shoppings", shoppings);
        return "client/shopping";
    }

    @GetMapping("/client/deleteShoppingByUserName")
    public String ShoppingDeleteByUserName(String loginUser){
        System.out.println(loginUser);
        shoppingService.deleteShoppingByUserName(loginUser);
        return "client/shopping";
    }

}
