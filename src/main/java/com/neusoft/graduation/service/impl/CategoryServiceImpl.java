package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.CategoryDao;
import com.neusoft.graduation.entity.Category;
import com.neusoft.graduation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/10 16:52
 * Version 1.0
 **/
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> queryAllCategory() {
        return categoryDao.queryAllCategory();
    }
}
