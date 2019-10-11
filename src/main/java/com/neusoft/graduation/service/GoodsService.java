package com.neusoft.graduation.service;

import com.neusoft.graduation.entity.Goods;

import java.util.List;

/**
 * @InterfaceName GoodsService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/8 10:19
 * Version 1.0
 **/
public interface GoodsService {
    /**
     * 获取商品列表信息
     * @return
     */
    List<Goods> queryAllGoods();

    /**
     * 进价升序获取商品列表信息
     * @return
     */
    List<Goods> queryAllGoodsByOriginalPriceAsc();

    /**
     * 进价降序获取商品列表信息
     * @return
     */
    List<Goods> queryAllGoodsByOriginalPriceDesc();

    /**
     * 售价升序获取商品列表信息
     * @return
     */
    List<Goods> queryAllGoodsBysellPriceAsc();

    /**
     * 售价降序获取商品列表信息
     * @return
     */
    List<Goods> queryAllGoodsBysellPriceDesc();

    /**
     * 根据商品id查询商品信息
     * @param id
     * @return
     */
    Goods queryGoodsByGoodsId(int id);

    /**
     * 根据商品名称查询商品信息
     * @param name
     * @return
     */
    Goods queryGoodsByGoodsName(String name);

    /**
     * 根据类别名称查询商品信息
     * @param name
     * @return
     */
    List<Goods> queryGoodsByCategoryName(String name);

    /**
     * 根据商品名类别名模糊查询
     * @param likeName
     * @return
     */
    Goods queryGoodsByLike(String likeName);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 更新商品信息
     * @param goods
     * @return
     */
    int updateGoodsByGoodsId(Goods goods);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteGoodsByGoodsId(int id);
}
