package com.tts.controller;

import com.tts.bean.*;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * Created by joe on 17/4/19.
 */
@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping(value = "/allInfo/{uid}",method = RequestMethod.GET)
    public String getAllInfo(@PathVariable("uid") Integer uid,
                             ModelMap map) {
        Users users = usersService.queryUserInfoByUid(uid);
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(uid);
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(uid);
        Set<Order> orders = usersService.queryOrdersByUid(uid);
        Set<User_Collect> userCollects = usersService.queryCollectsByUid(uid);
        users.setDiscountCoupons(discountCoupons);
        users.setUserRedPackages(userRedPackages);
        users.setOrders(orders);
        users.setUserCollects(userCollects);
        map.put("users",users);
        return "person/index";
    }
}
