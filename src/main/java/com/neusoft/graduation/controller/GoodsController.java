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
import java.util.Map;

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
        System.out.println("进入商品列表页");
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

    @GetMapping("/originalPriceByGoods")
    public String originalPriceByGoods(Model model){
        System.out.println("进入按进价升序界面了");
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        return "/good/list";
    }

    @GetMapping("/originalPriceByUp")
    public String originalPriceByUp(Model model, Map<String,Object> map){
        System.out.println("进入按进价升序界面了");
        List<Goods> goods = goodsService.queryAllGoodsByOriginalPriceAsc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg","升序");
        return "/good/list";
    }

    @GetMapping("/originalPriceByDown")
    public String originalPriceByDown(Model model,Map<String,Object> map){
        System.out.println("进入按进价降序界面了");
        List<Goods> goods = goodsService.queryAllGoodsByOriginalPriceDesc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg","降序");
        return "/good/list";
    }

    @GetMapping("/sellPriceByUp")
    public String sellPriceByUp(Model model, Map<String,Object> map){
        System.out.println("进入按售价升序界面了");
        List<Goods> goods = goodsService.queryAllGoodsBysellPriceAsc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg","升序");
        return "/good/list";
    }

    @GetMapping("/sellPriceByDown")
    public String sellPriceByDown(Model model,Map<String,Object> map){
        System.out.println("进入按售价升序界面了");
        List<Goods> goods = goodsService.queryAllGoodsBysellPriceDesc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg","降序");
        return "/good/list";
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

    @GetMapping("/goodsAdd")
    public String toAddPage(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods",goods);
        return "good/add";
    }

    @PostMapping("/goodsAdd")
    public String addGoods(Goods goods){
        System.out.println(goods);
        goodsService.addGoods(goods);
        return "redirect:/goods";
    }

    @GetMapping("/goodsUpdate/{goodsId}")
    public String toEditPage(@PathVariable("goodsId") Integer id, Model model){
        Goods goods = goodsService.queryGoodsByGoodsId(id);
        model.addAttribute("goods",goods);
        System.out.println("修改前的商品数据："+goods);
        return "good/update";
    }

    @PutMapping("/goodsUpdate")
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
