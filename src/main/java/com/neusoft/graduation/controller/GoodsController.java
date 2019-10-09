package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName GoodsController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/8 20:53
 * Version 1.0
 **/
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public String goodsList(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods",goods);
        return "good/list";
    }

    @GetMapping("/good")
    public String toAddPage(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods",goods);
        return "good/add";
    }

    @PostMapping("/good")
    public String addGoods(Goods goods){
        System.out.println(goods);
        goodsService.addGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("/good/{goodsId}")
    public String toEditPage(@PathVariable("goodsId") Integer id, Model model){
        Goods goods = goodsService.queryGoodsByGoodsId(id);
        model.addAttribute("goods",goods);
        System.out.println("修改前的商品数据："+goods);
        return "good/add";
    }

    @PutMapping("/good")
    public String updateGoods(Goods goods){
        System.out.println("修改后的商品数据："+goods);
        goodsService.updateGoodsByGoodsId(goods);
    return "redirect:/goods";
    }

    @DeleteMapping("/good/{goodsId}")
    public String deleteGoods(@PathVariable("goodsId") Integer id){
        goodsService.deleteGoodsByGoodsId(id);
        return "redirect:/goods";
    }
}
