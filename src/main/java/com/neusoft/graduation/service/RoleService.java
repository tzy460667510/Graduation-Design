package com.neusoft.graduation.service;

import com.neusoft.graduation.entity.Role;

import java.util.List;

/**
 * @InterfaceName RoleService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/14 16:23
 * Version 1.0
 **/
public interface RoleService {
    /**
     * 查询role列表
     * @return
     */
    List<Role> queryAllRole();
}
