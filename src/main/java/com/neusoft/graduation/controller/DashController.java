package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.entity.Order;
import com.neusoft.graduation.service.GoodsService;
import com.neusoft.graduation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @ClassName DashController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/11/19 10:50
 * Version 1.0
 **/
@Controller
public class DashController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/dash")
    public String dash(Model model) {
        List<Order> orders = orderService.queryOrderByYearMonth();
        double[] arr = new double[12];
        for (int i = 0; i < orders.size(); i++) {
            String goodsName = orders.get(i).getGoodsName();
            Goods goods = goodsService.queryGoodsByGoodsName(goodsName);
            double originalPrice = goods.getOriginalPrice();
            double sellPrice = goods.getSellPrice();
            int goodsCount = orders.get(i).getGoodsCount();
            double yingli = (sellPrice - originalPrice) * goodsCount;
            arr[i] = yingli;
        }
        model.addAttribute("arr1", arr[0]);
        model.addAttribute("arr2", arr[1]);
        model.addAttribute("arr3", arr[2]);
        model.addAttribute("arr4", arr[3]);
        model.addAttribute("arr5", arr[4]);
        model.addAttribute("arr6", arr[5]);
        model.addAttribute("arr7", arr[6]);
        model.addAttribute("arr8", arr[7]);
        model.addAttribute("arr9", arr[8]);
        model.addAttribute("arr10", arr[9]);
        model.addAttribute("arr11", arr[10]);
        model.addAttribute("arr12", arr[11]);
        return "/dash";
    }
}

