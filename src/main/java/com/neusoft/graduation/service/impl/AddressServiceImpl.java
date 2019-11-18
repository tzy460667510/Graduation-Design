package com.neusoft.graduation.service.impl;

import com.neusoft.graduation.dao.AddressDao;
import com.neusoft.graduation.entity.Address;
import com.neusoft.graduation.entity.Admin;
import com.neusoft.graduation.service.AddressService;
import com.neusoft.graduation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AddressServiceImpl
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/25 11:14
 * Version 1.0
 **/
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;


    @Override
    public List<Address> queryAllAddress() {
        return addressDao.queryAllAddress();
    }

    @Override
    public Address queryAddressByAddressId(int id) {
        return addressDao.queryAddressByAddressId(id);
    }

    @Override
    public List<Address> queryAddressByUserId(int id) {
        return addressDao.queryAddressByUserId(id);
    }

    @Override
    public List<Address> queryAddressByUserName(String name) {
        return addressDao.queryAddressByUserName(name);
    }

    @Override
    public int addAdress(Address address) {
        return addressDao.addAdress(address);
    }

    @Override
    public int updateAddressByAddressId(Address address) {
        return addressDao.updateAddressByAddressId(address);
    }

    @Override
    public int deleteAddressByAddressId(int id) {
        return addressDao.deleteAddressByAddressId(id);
    }

    @Override
    public int deleteAddressByUserId(int id) {
        return addressDao.deleteAddressByUserId(id);
    }

    @Override
    public int deleteAddressByUserName(String name) {
        return addressDao.deleteAddressByUserName(name);
    }


}
