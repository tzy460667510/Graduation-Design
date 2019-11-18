package com.neusoft.graduation.dao;

import com.neusoft.graduation.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @InterfaceName RoleDao
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/14 16:15
 * Version 1.0
 **/
@Component
public interface RoleDao {
    /**
     * 查询role列表
     * @return
     */
    List<Role> queryAllRole();
}
