package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.Goods;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/8 9:34
 * Version 1.0
 **/
@Component
public interface GoodsDao {
    /**
     * 获取商品列表信息
     * @return
     */
    List<Goods> queryAllGoods();

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
    Goods queryGoodsByCategoryName(String name);

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
