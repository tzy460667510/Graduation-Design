package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Category;
import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.service.CategoryService;
import com.neusoft.graduation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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

    /**
     * 商品列表
     * @param model
     * @return
     */
    @GetMapping("/goods")
    public String goodsList(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        return "good/list";
    }

    /**
     * 根据类别查询数据并返回页面渲染
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/categoryList/{categoryName}")
    public String togoodsByCategoryNamePage(@PathVariable("categoryName") String name, Model model){
        System.out.println(name);
        List<Goods> goods = goodsService.queryGoodsByCategoryName(name);
        List<Category> category = categoryService.queryAllCategory();
        Category category1 = null;
        for (int i = 0; i <category.size(); i++) {
            if (category.get(i).getCategoryName().equals(name)){
                category1 = category.get(i);
                category.remove(i);
            }
        }
        model.addAttribute("goods",goods);
        model.addAttribute("category1",category1);
        model.addAttribute("category",category);
        return "good/categorylist";
    }

    /**
     * 进价升序
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/originalPriceByUp")
    public String originalPriceByUp(Model model, Map<String,Object> map){
        System.out.println("进入按进价升序界面了");
        List<Goods> goods = goodsService.queryAllGoodsByOriginalPriceAsc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg1","升序");
        return "good/list";
    }

    /**
     * 进价降序
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/originalPriceByDown")
    public String originalPriceByDown(Model model,Map<String,Object> map){
        System.out.println("进入按进价降序界面了");
        List<Goods> goods = goodsService.queryAllGoodsByOriginalPriceDesc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg1","降序");
        return "good/list";
    }

    /**
     * 售价升序
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/sellPriceByUp")
    public String sellPriceByUp(Model model, Map<String,Object> map){
        System.out.println("进入按售价升序界面了");
        List<Goods> goods = goodsService.queryAllGoodsBysellPriceAsc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg2","升序");
        return "good/list";
    }

    /**
     * 售价降序
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/sellPriceByDown")
    public String sellPriceByDown(Model model,Map<String,Object> map){
        System.out.println("进入按售价降序序界面了");
        List<Goods> goods = goodsService.queryAllGoodsBysellPriceDesc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg2","降序");
        return "good/list";
    }

    /**
     * 库存升序
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/inventoryByUp")
    public String inventoryByUp(Model model, Map<String,Object> map){
        System.out.println("进入按售价升序界面了");
        List<Goods> goods = goodsService.queryAllGoodsByInventoryAsc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg3","升序");
        return "good/list";
    }

    /**
     * 库存降序
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/inventoryByDown")
    public String inventoryByDown(Model model,Map<String,Object> map){
        System.out.println("进入按库存降序序界面了");
        List<Goods> goods = goodsService.queryAllGoodsByInventoryDesc();
        model.addAttribute("goods",goods);
        List<Category> category = categoryService.queryAllCategory();
        model.addAttribute("category",category);
        map.put("msg3","降序");
        return "good/list";
    }

    /**
     * 商品详情页
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/goodsDetail/{goodsName}")
    public String toDetailPage(@PathVariable("goodsName") String name, Model model){
        Goods goods = goodsService.queryGoodsByGoodsName(name);
        List<Category> categories = categoryService.queryAllCategory();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryId()==goods.getCategoryId()){
                goods.setCategoryName(categories.get(i).getCategoryName());
            }
        }
        System.out.println(goods);
        model.addAttribute("goods",goods);
        return "good/detail";
    }

    @GetMapping("/goodsAdd")
    public String toAddPage(Model model){
        List<Goods> goods = goodsService.queryAllGoods();
        List<Category> categories = categoryService.queryAllCategory();
        model.addAttribute("categories",categories);
        model.addAttribute("goods",goods);
        return "good/add";
    }

    @PostMapping("/goodsAdd")
    public String addGoods(Goods goods,Map<String,Object> map,Model model){
        System.out.println(goods);
        if (goods.getGoodsName()==null){
            map.put("msg1","请输入商品名称");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else if(goodsService.queryGoodsByGoodsName(goods.getGoodsName())!=null){
            map.put("msg2","商品已存在");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else if (goods.getCategoryName().equals("请选择商品种类")) {
            map.put("msg3","请选择商品种类");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else if (goods.getDetails()==null){
            map.put("msg4","详情不可为空");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else if (goods.getOriginalPrice()==0){
            map.put("msg5","进价不可为0");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else if (goods.getSellPrice()==0){
            map.put("msg6","售价不可为0");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else if (goods.getInventory()==0){
            map.put("msg7","库存不可为0");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/add";
        }else{
            System.out.println(goodsService.queryGoodsByCategoryName(goods.getCategoryName()).get(0));
            int categoryId= goodsService.queryGoodsByCategoryName(goods.getCategoryName()).get(0).getCategoryId();
            goods.setCategoryId(categoryId);
            goodsService.addGoods(goods);
            return "redirect:/goods";
        }
    }

    @GetMapping("/goodsUpdate/{goodsId}")
    public String toEditPage(@PathVariable("goodsId") Integer id, Model model){
        Goods goods = goodsService.queryGoodsByGoodsId(id);
        List<Category> categories = categoryService.queryAllCategory();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryId()==goods.getCategoryId()){
                goods.setCategoryName(categories.get(i).getCategoryName());
                categories.remove(i);
            }
        }
        model.addAttribute("categories",categories);
        model.addAttribute("goods",goods);
        System.out.println("修改前的商品数据："+goods);
        return "good/update";
    }

    @PutMapping("/goodsUpdate")
    public String updateGoods(Goods goods,Map<String,Object> map,Model model){
        if (goods.getGoodsName().isEmpty()){
            map.put("msg1","商品名称不可为空");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/update";
        }else if (goods.getDetails().isEmpty()){
            map.put("msg3","详情不可为空");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/update";
        }else if (goods.getOriginalPrice()==0){
            map.put("msg4","进价不可为0");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/update";
        }else if (goods.getSellPrice()==0){
            map.put("msg5","售价不可为0");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/update";
        }else if (goods.getInventory()==0){
            map.put("msg6","库存不可为0");
            List<Category> categoriesx = categoryService.queryAllCategory();
            model.addAttribute("categoriesx",categoriesx);
            return "good/update";
        }else{
            System.out.println("修改后的商品数据："+goods);
            String categoryName = goods.getCategoryName();
            List<Category> categories = categoryService.queryAllCategory();
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getCategoryName().equals(categoryName)){
                    goods.setCategoryId(categories.get(i).getCategoryId());
                }
            }
            goodsService.updateGoodsByGoodsId(goods);
            return "redirect:/goods";
        }
    }

    @DeleteMapping("/good/{goodsId}")
    public String deleteGoods(@PathVariable("goodsId") Integer id){
        goodsService.deleteGoodsByGoodsId(id);
        return "redirect:/goods";
    }

    @GetMapping("/clientGoodsDetailByGoodsName/{goodsName}")
    public String toDetailPageClient(@PathVariable("goodsName") String name, Model model){
        Goods goods = goodsService.queryGoodsByGoodsName(name);
        List<Category> categories = categoryService.queryAllCategory();
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCategoryId()==goods.getCategoryId()){
                goods.setCategoryName(categories.get(i).getCategoryName());
            }
        }
        System.out.println(goods);
        model.addAttribute("categories",categories);
        model.addAttribute("goods",goods);
        return "client/detail";
    }

    @GetMapping("/client/toproductlistbycategory/{categoryName}")
    public String toProductListByCategory(@PathVariable("categoryName") String name, Model model){
        List<Category> categories = categoryService.queryAllCategory();
        List<Goods> goods = goodsService.queryGoodsByCategoryName(name);
        Goods goodscategory = goods.get(0);
        System.out.println(goodscategory);
        model.addAttribute("goodscategory",goodscategory);
        model.addAttribute("categories",categories);
        model.addAttribute("goods",goods);
        return "client/product";
    }

    @GetMapping("/client/searchGoods/{loginUser}")
    public String searchGoods(@PathVariable("loginUser") String name,
                              @RequestParam("goodsSearch") String goodsName,
                              Model model, HttpSession session,Map<Object,String> map){
        Goods likeGoods = goodsService.queryGoodsByLike(goodsName);
        if (likeGoods==null){
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
            return "client/index";
        }else{
            List<Category> categories = categoryService.queryAllCategory();
            for (int i = 0; i < categories.size(); i++) {
                if (categories.get(i).getCategoryId()==likeGoods.getCategoryId()){
                    likeGoods.setCategoryName(categories.get(i).getCategoryName());
                }
            }
            model.addAttribute("categories",categories);
            model.addAttribute("goods",likeGoods);
            session.setAttribute("loginUser", name);
            return "client/detail";
        }
    }
}
