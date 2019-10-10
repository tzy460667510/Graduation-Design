package com.neusoft.graduation.service;

import com.neusoft.graduation.entity.Category;

import java.util.List;

/**
 * @InterfaceName CategoryService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/10 16:51
 * Version 1.0
 **/

public interface CategoryService {
    /**
     * 获取管理员列表信息
     * @return
     */
    List<Category> queryAllCategory();
}
