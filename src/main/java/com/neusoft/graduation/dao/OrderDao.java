package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @InterfaceName OrderDao
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/16 9:25
 * Version 1.0
 **/
@Component
public interface OrderDao {
    /**
     * 获取订单列表信息
     * @return
     */
    List<Order> queryAllOrder();

    /**
     * 购买数量升序获取商品列表信息
     * @return
     */
    List<Order> queryAllOrderByGoodsCountAsc();

    /**
     * 购买数量降序获取商品列表信息
     * @return
     */
    List<Order> queryAllOrderByGoodsCountDesc();

    /**
     * 购买总价升序获取商品列表信息
     * @return
     */
    List<Order> queryAllOrderByOrderTotalAsc();

    /**
     * 购买总价降序获取商品列表信息
     * @return
     */
    List<Order> queryAllOrderByOrderTotalDesc();

    /**
     * 根据订单号查询订单信息
     * @param id
     * @return
     */
    Order queryOrderByOrderId(int id);

    /**
     * 根据订单状态查询订单
     * @return
     */
    List<Order> queryOrderByStatue(int statue);

    /**
     * 根据用户名查询订单
     * @param name
     * @return
     */
    List<Order> queryOrderByUserName(String name);

    /**
     * 根据商品名查询订单
     * @param name
     * @return
     */
    List<Order> queryOrderByGoodsName(String name);

    /**
     * 添加订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 根据订单号更新订单
     * @param order
     * @return
     */
    int updateOrderByOrderId(Order order);

    /**
     * 根据订单状态更新订单
     * @param order
     * @return
     */
    int updateOrderByStatue(Order order);

    /**
     * 删除订单
     * @param id
     * @return
     */
    int deleteOrderByOrderId(int id);

}
