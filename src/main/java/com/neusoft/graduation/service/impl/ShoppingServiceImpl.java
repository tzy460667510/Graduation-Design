package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.ShoppingDao;
import com.neusoft.graduation.entity.Shopping;
import com.neusoft.graduation.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ShoppingServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/25 20:22
 * Version 1.0
 **/
@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    ShoppingDao shoppingDao;

    @Override
    public List<Shopping> queryShoppingByUserName(String name) {
        return shoppingDao.queryShoppingByUserName(name);
    }

    @Override
    public Shopping queryShoppingByShoppingId(int id) {
        return shoppingDao.queryShoppingByShoppingId(id);
    }

    @Override
    public int addShopping(Shopping shopping) {
        return shoppingDao.addShopping(shopping);
    }

    @Override
    public int updateShoppingByShoppingId(Shopping shopping) {
        return shoppingDao.updateShoppingByShoppingId(shopping);
    }

    @Override
    public int deleteShoppingByGoodsName(String goodsName, String userName) {
        return shoppingDao.deleteShoppingByGoodsName(goodsName,userName);
    }

    @Override
    public int deleteShoppingByUserName(String name) {
        return shoppingDao.deleteShoppingByUserName(name);
    }
}
