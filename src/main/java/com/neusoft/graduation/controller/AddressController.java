package com.neusoft.graduation.controller;

import com.neusoft.graduation.entity.Address;
import com.neusoft.graduation.entity.User;
import com.neusoft.graduation.service.AddressService;
import com.neusoft.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName AddressController
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/10/9 21:25
 * Version 1.0
 **/
@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;

    //地址列表页面
    @GetMapping("/addresses")
    public String addressesList(Model model) {
        List<Address> addresses = addressService.queryAllAddress();
        model.addAttribute("addresses",addresses);
        return "address/list";
    }

    @GetMapping("/addressesDetail/{userName}")
    public String toDetailPage(@PathVariable("userName") String name,Model model){
        List<Address> addresseslist = addressService.queryAddressByUserName(name);
        Address address = new Address();
        address=addresseslist.get(0);
        model.addAttribute("address",address);
        model.addAttribute("addresses",addresseslist);
        return "address/detail";
    }

    //来到地址添加页面
    @GetMapping("/addressAdd")
    public String toAddPage(Model model) {
        List<Address> addresses = addressService.queryAllAddress();
        model.addAttribute("addresses",addresses);
        return "address/add";
    }


    //地址添加
    @PostMapping("/addressAdd")
    public String addAddresses(Address address) {
        System.out.println(address);
        addressService.addAdress(address);
        return "redirect:/addresses";
    }

    //来到修改页面，查出当前地址信息，在页面回显
    @GetMapping("/addressUpdate/{addressId}")
    public String toEditPage(@PathVariable("addressId") Integer id, Model model) {
        Address address = addressService.queryAddressByAddressId(id);
        System.out.println("修改前的地址数据：" + address);
        model.addAttribute("address", address);
        System.out.println(address);
        return "address/update";
    }

    //管理员修改；需要提交adminId；
    @PutMapping("/addressUpdate")
    public String updateAdmin(Address address) {
        System.out.println("修改后的地址数据：" + address);
        int userId = address.getUserId();
        User user = userService.queryUserByUserId(userId);
        address.setUserName(user.getUserName());
        addressService.updateAddressByAddressId(address);
        return "redirect:/addresses";
    }

    //用户的删除
    @DeleteMapping("/address/{addressId}")
    public String deleteAdmin(@PathVariable("addressId") Integer id) {
        addressService.deleteAddressByAddressId(id);
        return "redirect:/addresses";
    }
}
