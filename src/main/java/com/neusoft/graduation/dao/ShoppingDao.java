package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.Shopping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ShoppingDao
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/25 20:13
 * Version 1.0
 **/
@Component
public interface ShoppingDao {
    /**
     * 根据用户名查询购物车
     * @param name
     * @return
     */
    List<Shopping> queryShoppingByUserName(String name);
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
