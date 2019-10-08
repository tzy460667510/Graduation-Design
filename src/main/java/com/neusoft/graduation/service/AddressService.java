package com.neusoft.graduation.service;

import com.neusoft.graduation.entity.Address;

import java.util.List;

/**
 * @InterfaceName AddressService
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/25 11:14
 * Version 1.0
 **/
public interface AddressService {
    /**
     * 获取地址列表信息
     * @return
     */
    List<Address> queryAllAddress();

    /**
     * 根据地址id查询地址
     * @return
     */
    Address queryAddressByAddressId(int id);

    /**
     * 根据用户id查询地址
     * @return
     */
    Address queryAddressByUserId(int id);

    /**
     * 根据用户名称查询地址
     * @return
     */
    Address queryAddressByUserName(String name);

    /**
     * 添加地址
     * @param address
     * @return
     */
    int addAdress(Address address);

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    int updateAddressByAddressId(Address address);

    /**
     * 根据地址Id删除地址信息
     * @param id
     * @return
     */
    int deleteAddressByAddressId(int id);

    /**
     * 根据用户id删除用户地址信息
     * @param id
     * @return
     */
    int deleteAddressByUserId(int id);

    /**
     * 根据用户姓名删除用户地址信息
     * @param name
     * @return
     */
    int deleteAddressByUserName(String name);
}