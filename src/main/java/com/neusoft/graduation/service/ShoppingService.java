package com.neusoft.graduation.service;

import com.neusoft.graduation.entity.Shopping;

import java.util.List;

/**
 * @InterfaceName ShoppingService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/25 20:20
 * Version 1.0
 **/
public interface ShoppingService {
    /**
     * 根据用户名查询购物车
     * @param name
     * @return
     */
    List<Shopping> queryShoppingByUserName(String name);
    /**
     * 根据id查找购物车
     * @param id
     * @return
     */
    Shopping queryShoppingByShoppingId(int id);
    /**
     * 添加购物车
     * @param shopping
     * @return
     */
    int addShopping(Shopping shopping);
    /**
     * 修改购物车
     * @param id
     * @return
     */
    int updateShoppingByShoppingId(Shopping shopping);
    /**
     * 根据商品名称删除商品
     * @param goodsName
     * @param userName
     * @return
     */
    int deleteShoppingByGoodsName(String goodsName,String userName);
    /**
     * 根据用户名删除购物车商品
     * @param name
     * @return
     */
    int deleteShoppingByUserName(String name);
}
