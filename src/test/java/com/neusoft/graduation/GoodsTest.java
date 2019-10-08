package com.neusoft.graduation;

import com.neusoft.graduation.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName GoodsTest
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/8 10:48
 * Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
    @Autowired
    GoodsService goodsService;

    @Test
    public void selectTest(){
        System.out.println(goodsService.queryAllGoods().toString());
    }

}
