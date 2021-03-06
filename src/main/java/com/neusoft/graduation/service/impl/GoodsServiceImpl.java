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
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> queryAllGoods() {
        return goodsDao.queryAllGoods();
    }

    @Override
    public List<Goods> queryAllGoodsExceptionCategory() {
        return goodsDao.queryAllGoodsExceptionCategory();
    }

    @Override
    public List<Goods> queryAllGoodsByOriginalPriceAsc() {
        return goodsDao.queryAllGoodsByOriginalPriceAsc();
    }

    @Override
    public List<Goods> queryAllGoodsByOriginalPriceDesc() {
        return goodsDao.queryAllGoodsByOriginalPriceDesc();
    }

    @Override
    public List<Goods> queryAllGoodsBysellPriceAsc() {
        return goodsDao.queryAllGoodsBysellPriceAsc();
    }

    @Override
    public List<Goods> queryAllGoodsBysellPriceDesc() {
        return goodsDao.queryAllGoodsBysellPriceDesc();
    }

    @Override
    public List<Goods> queryAllGoodsByInventoryAsc() {
        return goodsDao.queryAllGoodsByInventoryAsc();
    }

    @Override
    public List<Goods> queryAllGoodsByInventoryDesc() {
        return goodsDao.queryAllGoodsByInventoryDesc();
    }

    @Override
    public List<Goods> queryAllGoodsByCreateDateAsc() {
        return goodsDao.queryAllGoodsByCreateDateAsc();
    }

    @Override
    public List<Goods> queryAllGoodsByCreateDateDesc() {
        return goodsDao.queryAllGoodsByCreateDateDesc();
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
    public List<Goods> queryGoodsByCategoryName(String name) {
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
