package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Category;
import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.service.CategoryService;
import com.neusoft.graduation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/21 14:14
 * Version 1.0
 **/
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/client")
    public String IndexGoodsFlash(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        List<Category> categories = categoryService.queryAllCategory();
        //首页商品展示  只显示8个
        List<Goods> goods1 = goodsService.queryGoodsByCategoryName("肉禽蛋类");
        List<Goods> goods2 = goodsService.queryGoodsByCategoryName("水产类");
        List<Goods> goods3 = goodsService.queryGoodsByCategoryName("蔬菜类");
        List<Goods> goods4 = goodsService.queryGoodsByCategoryName("豆类");
        List<Goods> goods5 = goodsService.queryGoodsByCategoryName("五谷杂粮类 ");
        List<Goods> goods6 = goodsService.queryGoodsByCategoryName("果品类");
        List<Goods> goods7 = goodsService.queryGoodsByCategoryName("药食两用类");
        List<Goods> goods8 = goodsService.queryGoodsByCategoryName("调味品类");
        List<Goods> goods9 = goodsService.queryGoodsByCategoryName("酒饮类");
        for (int i = goods1.size()-1; i >0 ; i--) {
            if (goods1.size()>8){
                goods1.remove(i);
            }
        }
        for (int i = goods2.size()-1; i >0 ; i--) {
            if (goods2.size()>8){
                goods2.remove(i);
            }
        }
        for (int i = goods3.size()-1; i >0 ; i--) {
            if (goods3.size()>8){
                goods3.remove(i);
            }
        }
        for (int i = goods4.size()-1; i >0 ; i--) {
            if (goods4.size()>8){
                goods4.remove(i);
            }
        }
        for (int i = goods5.size()-1; i >0 ; i--) {
            if (goods5.size()>8){
                goods5.remove(i);
            }
        }
        for (int i = goods6.size()-1; i >0 ; i--) {
            if (goods6.size()>8){
                goods6.remove(i);
            }
        }
        for (int i = goods7.size()-1; i >0 ; i--) {
            if (goods7.size()>8){
                goods7.remove(i);
            }
        }
        for (int i = goods8.size()-1; i >0 ; i--) {
            if (goods8.size()>8){
                goods8.remove(i);
            }
        }
        for (int i = goods9.size()-1; i >0 ; i--) {
            if (goods9.size()>8){
                goods9.remove(i);
            }
        }
        //右侧畅销栏和上新栏
        List<Goods> goods10 = goodsService.queryAllGoodsByCreateDateDesc();
        for (int i = goods10.size()-1; i >0; i--) {
            if (goods10.size()>10){
                goods10.remove(i);
            }
        }
        List<Goods> goods11 =goodsService.queryAllGoodsByInventoryAsc();
        for (int i = goods11.size()-1; i >0; i--) {
            if (goods11.size()>10){
                goods11.remove(i);
            }
        }
        model.addAttribute("categories",categories);
        model.addAttribute("goods1",goods1);
        model.addAttribute("goods2",goods2);
        model.addAttribute("goods3",goods3);
        model.addAttribute("goods4",goods4);
        model.addAttribute("goods5",goods5);
        model.addAttribute("goods6",goods6);
        model.addAttribute("goods7",goods7);
        model.addAttribute("goods8",goods8);
        model.addAttribute("goods9",goods9);
        model.addAttribute("goods10",goods10);
        model.addAttribute("goods11",goods11);
        return "client/index";
    }

}
