package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Address;
import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.entity.Order;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.AddressService;
import com.neusoft.graduation.service.GoodsService;
import com.neusoft.graduation.service.OrderService;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public String orderTotalByStatue1(Model model, Map<String, Object> map){
        System.out.println("进入未发货排序界面了");
        List<Order> orders = orderService.queryOrderByStatue(1);
        System.out.println(orders);
        model.addAttribute("orders",orders);
        map.put("msg3", "未发货");
        return "order/list";
    }
    @GetMapping("/orderTotalByStatue2")
    public String orderTotalByStatue2(Model model, Map<String, Object> map){
        System.out.println("进入已发货排序界面了");
        List<Order> orders = orderService.queryOrderByStatue(2);
        model.addAttribute("orders",orders);
        map.put("msg3", "已发货");
        return "order/list";
    }
    @GetMapping("/orderTotalByStatue3")
    public String orderTotalByStatue3(Model model, Map<String, Object> map){
        System.out.println("进入未评价排序界面了");
        List<Order> orders = orderService.queryOrderByStatue(3);
        model.addAttribute("orders",orders);
        map.put("msg3", "未评价");
        return "order/list";
    }
    @GetMapping("/orderTotalByStatue4")
    public String orderTotalByStatue4(Model model, Map<String, Object> map){
        System.out.println("进入已评价排序界面了");
        List<Order> orders = orderService.queryOrderByStatue(4);
        model.addAttribute("orders",orders);
        map.put("msg3", "已评价");
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
     *
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

    @GetMapping("/client/addOrder")
    public String shoppingToAddOrder(){

        return null;
    }
}
