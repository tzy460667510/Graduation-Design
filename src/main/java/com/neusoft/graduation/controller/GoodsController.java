package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Category;
import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.service.CategoryService;
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
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/goods")
    public String goodsList(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        return "good/list";
    }

    @GetMapping("/categoryList/{categoryName}")
    public String togoodsByCategoryNamePage(@PathVariable("categoryName") String name, Model model){
        System.out.println(name);
        List<Goods> goods = goodsService.queryGoodsByCategoryName(name);
        List<Category> category = categoryService.queryAllCategory();
//        System.out.println(category);
        Category category1 = null;
        for (int i = 0; i <category.size(); i++) {
            if (category.get(i).getCategoryName().equals(name)){
                category1 = category.get(i);
                category.remove(i);
            }
        }
//        System.out.println(category);
//        System.out.println(category1);
        model.addAttribute("goods",goods);
        model.addAttribute("category1",category1);
        model.addAttribute("category",category);
        return "/good/categorylist";
    }

    @GetMapping("/goodsDetail/{goodsName}")
    public String toDetailPage(@PathVariable("goodsName") String name, Model model){
        System.out.println(name);
        Goods goods = goodsService.queryGoodsByGoodsName(name);
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "good/detail";
    }

    @GetMapping("/goodsDetail")
    public String goodsDetail(@PathVariable("goodsName") String name, Model model){
        Goods goods = goodsService.queryGoodsByGoodsName(name);
        model.addAttribute("goods",goods);
        return "good/detail";
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
