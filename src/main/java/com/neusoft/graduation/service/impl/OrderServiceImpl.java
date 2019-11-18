package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.OrderDao;
import com.neusoft.graduation.entity.Order;
import com.neusoft.graduation.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/16 11:00
 * Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> queryAllOrder() {
        return orderDao.queryAllOrder();
    }

    @Override
    public List<Order> queryAllOrderByGoodsCountAsc() {
        return orderDao.queryAllOrderByGoodsCountAsc();
    }

    @Override
    public List<Order> queryAllOrderByGoodsCountDesc() {
        return orderDao.queryAllOrderByGoodsCountDesc();
    }

    @Override
    public List<Order> queryAllOrderByOrderTotalAsc() {
        return orderDao.queryAllOrderByOrderTotalAsc();
    }

    @Override
    public List<Order> queryAllOrderByOrderTotalDesc() {
        return orderDao.queryAllOrderByOrderTotalDesc();
    }

    @Override
    public Order queryOrderByOrderId(int id) {
        return orderDao.queryOrderByOrderId(id);
    }

    @Override
    public List<Order> queryOrderByStatue(int statue) {
        return orderDao.queryOrderByStatue(statue);
    }

    @Override
    public List<Order> queryOrderByUserName(String name) {
        return orderDao.queryOrderByUserName(name);
    }

    @Override
    public List<Order> queryOrderByGoodsName(String name) {
        return orderDao.queryOrderByGoodsName(name);
    }

    @Override
    public int addOrder(Order order) {
        return orderDao.addOrder(order);
    }

    @Override
    public int updateOrderByOrderId(Order order) {
        return orderDao.updateOrderByOrderId(order);
    }

    @Override
    public int updateOrderByStatue(Order order) {
        return orderDao.updateOrderByStatue(order);
    }

    @Override
    public int deleteOrderByOrderId(int id) {
        return orderDao.deleteOrderByOrderId(id);
    }
}
