package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @InterfaceName CategoryDao
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/10 16:47
 * Version 1.0
 **/
@Component
public interface CategoryDao {
    /**
     * 获取管理员列表信息
     * @return
     */
    List<Category> queryAllCategory();
}
