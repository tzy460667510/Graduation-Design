package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.*;
import com.neusoft.graduation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/16 16:50
 * Version 1.0
 **/
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/orders")
    public String orderList(Model model) {
        System.out.println("进入商品列表页");
        List<Order> orders = orderService.queryAllOrder();
        System.out.println(orders);
        model.addAttribute("orders", orders);
        return "order/list";
    }

    /**
     * 购买数量升序
     *
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/goodsCountByUp")
    public String goodsCountByUp(Model model, Map<String, Object> map) {
        System.out.println("进入购买数量升序界面了");
        List<Order> orders = orderService.queryAllOrderByGoodsCountAsc();
        model.addAttribute("orders", orders);
        map.put("msg1", "升序");
        return "order/list";
    }

    /**
     * 购买数量降序
     *
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/goodsCountByDown")
    public String goodsCountByDown(Model model, Map<String, Object> map) {
        System.out.println("进入购买数量降序界面了");
        List<Order> orders = orderService.queryAllOrderByGoodsCountDesc();
        model.addAttribute("orders", orders);
        map.put("msg1", "降序");
        return "order/list";
    }

    /**
     * 购买总价升序
     *
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/orderTotalByUp")
    public String orderTotalByUp(Model model, Map<String, Object> map) {
        System.out.println("进入购买总价升序界面了");
        List<Order> orders = orderService.queryAllOrderByOrderTotalAsc();
        model.addAttribute("orders", orders);
        map.put("msg2", "升序");
        return "order/list";
    }

    /**
     * 购买总价降序
     *
     * @param model
     * @param map
     * @return
     */
    @GetMapping("/orderTotalByDown")
    public String orderTotalByDown(Model model, Map<String, Object> map) {
        System.out.println("进入购买总价降序界面了");
        List<Order> orders = orderService.queryAllOrderByOrderTotalDesc();
        model.addAttribute("orders", orders);
        map.put("msg2", "降序");
        return "order/list";
    }

    @GetMapping("/orderTotalByStatue1")
    public String orderTotalByStatue1(Model model, Map<String, Object> map) {
        System.out.println("进入未发货排序界面了");
        List<Order> orders = orderService.queryOrderByStatue(1);
        System.out.println(orders);
        model.addAttribute("orders", orders);
        map.put("msg3", "未发货");
        return "order/list";
    }

    @GetMapping("/orderTotalByStatue2")
    public String orderTotalByStatue2(Model model, Map<String, Object> map) {
        List<Order> orders = orderService.queryOrderByStatue(2);
        model.addAttribute("orders", orders);
        map.put("msg3", "已发货");
        return "order/list";
    }

    @GetMapping("/orderTotalByStatue3")
    public String orderTotalByStatue3(Model model, Map<String, Object> map) {
        List<Order> orders = orderService.queryOrderByStatue(3);
        model.addAttribute("orders", orders);
        map.put("msg3", "请求退货");
        return "order/list";
    }

    @GetMapping("/orderTotalByStatue4")
    public String orderTotalByStatue4(Model model, Map<String, Object> map) {
        List<Order> orders = orderService.queryOrderByStatue(4);
        model.addAttribute("orders", orders);
        map.put("msg3", "已退货");
        return "order/list";
    }

    @GetMapping("/orderTotalByStatue5")
    public String orderTotalByStatue5(Model model, Map<String, Object> map) {
        List<Order> orders = orderService.queryOrderByStatue(5);
        model.addAttribute("orders", orders);
        map.put("msg3", "已收货");
        return "order/list";
    }

    @GetMapping("/orderAdd")
    public String toAddPage(Model model) {
        List<Order> orders = orderService.queryAllOrder();
        model.addAttribute("orders", orders);
        return "order/add";
    }

    /**
     * 订单添加
     *
     * @param order
     * @param map
     * @return
     */
    @PostMapping("/orderAdd")
    public String addOrder(Order order, Map<String, Object> map) {
        System.out.println(order);
        if (order.getUserName().equals("")) {
            map.put("msg1", "用户昵称不可为空");
            return "order/add";
        } else if (userService.queryUserByUserName(order.getUserName()) == null) {
            map.put("msg2", "该用户不存在");
            return "order/add";
        } else if (order.getGoodsName().equals("")) {
            map.put("msg3", "商品不可为空");
            return "order/add";
        } else if (goodsService.queryGoodsByGoodsName(order.getGoodsName()) == null) {
            map.put("msg4", "该商品不存在");
            return "order/add";
        } else if (order.getGoodsCount() == 0) {
            map.put("msg5", "购买数量不可为空");
            return "order/add";
        } else if (goodsService.queryGoodsByGoodsName(order.getGoodsName()).getInventory() < order.getGoodsCount()) {
            map.put("msg6", "抱歉，库存不足");
            return "order/add";
        } else if (order.getUserName().equals("")) {
            map.put("msg7", "收货姓名不可为空");
            return "order/add";
        } else if (order.getAddressDetail().equals("")) {
            map.put("msg8", "收货地址不可为空");
            return "order/add";
        } else if (order.getPhone().equals("")) {
            map.put("msg9", "联系电话不可为空");
            return "order/add";
        } else {
            String userName = order.getUserName();
            String goodsName = order.getGoodsName();
            String addressDetail = order.getAddressDetail();
            List<Address> addresses = addressService.queryAddressByUserName(userName);
            for (int i = 0; i < addresses.size(); i++) {
                if (addresses.get(i).getAddressDetail().equals(addressDetail)) {
                    order.setAddressId(addresses.get(i).getAddressId());
                }
            }
            User user = userService.queryUserByUserName(userName);
            order.setUserId(user.getUserId());
            Goods goods = goodsService.queryGoodsByGoodsName(goodsName);
            order.setGoodsId(goods.getGoodsId());
            order.setOrderImg(goods.getGoodsImg());
            order.setSellPrice(goods.getSellPrice());
            order.setOrderTotal(goods.getSellPrice() * order.getGoodsCount());
            goods.setInventory(goods.getInventory() - order.getGoodsCount());
            goodsService.updateGoodsByGoodsId(goods);
            System.out.println(order);
            orderService.addOrder(order);
            return "redirect:/orders";
        }
    }

    /**
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/orderDetail/{userName}")
    public String DetailPageByUserName(@PathVariable("userName") String name, Model model) {
        System.out.println(name);
        List<Order> orderlist = orderService.queryOrderByUserName(name);
        Order order = new Order();
        order = orderlist.get(0);
        model.addAttribute("order", order);
        model.addAttribute("orders", orderlist);
        return "order/detail";
    }

    @GetMapping("/orderDetailByGoodsName/{goodsName}")
    public String DetailPageByGoodsName(@PathVariable("goodsName") String name, Model model) {
        System.out.println(name);
        List<Order> orderlist = orderService.queryOrderByGoodsName(name);
        Order order = new Order();
        order = orderlist.get(0);
        model.addAttribute("order", order);
        model.addAttribute("orders", orderlist);
        return "order/detailbygoodsName";
    }

    @GetMapping("/orderUpdate/{orderId}")
    public String toEditPage(@PathVariable("orderId") Integer id, Model model) {
        Order order = orderService.queryOrderByOrderId(id);
        model.addAttribute("order", order);
        System.out.println("修改前的订单数据：" + order);
        return "order/update";
    }

    @PutMapping("/orderUpdate")
    public String updateOrder(Order order) {
        System.out.println("修改后的订单数据：" + order);
        orderService.updateOrderByOrderId(order);
        return "redirect:/orders";
    }

    @DeleteMapping("/order/{orderId}")
    public String deleteGoods(@PathVariable("orderId") Integer id) {
        orderService.deleteOrderByOrderId(id);
        return "redirect:/orders";
    }

    @GetMapping("orderUpdateStatue/{orderId}")
    public String updateOrdersStatue(@PathVariable("orderId") Integer id){
        Order order = orderService.queryOrderByOrderId(id);
        int statue = order.getStatue();
        if (statue==1){
            statue=2;
        }else if(statue==3){
            statue=4;
        }
        order.setStatue(statue);
        orderService.updateOrderByOrderId(order);
        return "redirect:/orders";
    }

    @GetMapping("client/orderUpdateStatue/{orderId}")
    public String clientUpdateOrdersStatue(@PathVariable("orderId") Integer id,Model model){
        Order order = orderService.queryOrderByOrderId(id);
        int statue = order.getStatue();
        if (statue==5){
            statue=3;
        }else if(statue==2){
            statue=5;
        }
        order.setStatue(statue);
        orderService.updateOrderByOrderId(order);
        String userName = order.getUserName();
        List<Order> orders = orderService.queryOrderByUserName(userName);
        model.addAttribute("orders",orders);
        return "client/order";
    }

    @GetMapping("/client/addOrder")
    public String shoppingToAddOrder(@RequestParam("loginUser") String name) {
        System.out.println(name);
        List<Shopping> shoppings = shoppingService.queryShoppingByUserName(name);
        for (int i = 0; i < shoppings.size(); i++) {
            Goods goods = goodsService.queryGoodsByGoodsName(shoppings.get(i).getGoodsName());
            int inventory = goods.getInventory();
            if (shoppings.get(i).getGoodsCount() < inventory) {
                Order order = new Order();
                User user = userService.queryUserByUserName(name);
                order.setUserId(userService.queryUserByUserName(name).getUserId());
                order.setUserName(name);
                order.setGoodsId(shoppings.get(i).getGoodsId());
                order.setGoodsName(shoppings.get(i).getGoodsName());
                order.setSellPrice(shoppings.get(i).getSellPrice());
                order.setGoodsCount(shoppings.get(i).getGoodsCount());
                order.setOrderTotal(shoppings.get(i).getShoppingTotal());
                order.setPhone(user.getPhone());
                order.setAddressDetail(user.getAddress());
                orderService.addOrder(order);
                goods.setInventory(inventory - shoppings.get(i).getGoodsCount());
                goodsService.updateGoodsByGoodsId(goods);
                shoppings.get(i).setStatue(2);
                shoppingService.updateShoppingByShoppingId(shoppings.get(i));
            }
        }
        return "client/shopping";
    }

    @GetMapping("client/myOrderList/{loginUser}")
    public String myOrderList(@PathVariable("loginUser")String name, Model model) {
        List<Order> orders = orderService.queryOrderByUserName(name);
        model.addAttribute("orders",orders);
        return "client/order";
    }
}
