package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.GoodsDao;
import com.neusoft.graduation.entity.Goods;
import com.neusoft.graduation.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/8 10:19
 * Version 1.0
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> queryAllGoods() {
        return goodsDao.queryAllGoods();
    }

    @Override
    public Goods queryGoodsByGoodsId(int id) {
        return goodsDao.queryGoodsByGoodsId(id);
    }

    @Override
    public Goods queryGoodsByGoodsName(String name) {
        return goodsDao.queryGoodsByGoodsName(name);
    }

    @Override
    public Goods queryGoodsByCategoryName(String name) {
        return goodsDao.queryGoodsByCategoryName(name);
    }

    @Override
    public Goods queryGoodsByLike(String likeName) {
        return goodsDao.queryGoodsByLike(likeName);
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsDao.addGoods(goods);
    }

    @Override
    public int updateGoodsByGoodsId(Goods goods) {
        return goodsDao.updateGoodsByGoodsId(goods);
    }

    @Override
    public int deleteGoodsByGoodsId(int id) {
        return goodsDao.deleteGoodsByGoodsId(id);
    }
}
