package com.neusoft.graduation;

import com.neusoft.graduation.entity.Address;
import com.neusoft.graduation.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName AddressTest
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/25 15:13
 * Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void selectTest(){

    }

    @Test
    public void addTest(){
        Address address = new Address();
        address.setUserId(1);
        address.setUserName("Tzy");
        System.out.println(addressService.addAdress(address));
    }

    @Test
    public void editTest(){
        Address address = addressService.queryAddressByAddressId(1);
        address.setUserName("BOSS");
        address.setAddressDetail("gogogo!");
        System.out.println(addressService.updateAddressByAddressId(address));
    }

    @Test
    public void deleteTest(){
        System.out.println(addressService.deleteAddressByAddressId(1));
        System.out.println(addressService.deleteAddressByUserName("Tzy"));
        System.out.println(addressService.deleteAddressByUserId(2));
    }
}
