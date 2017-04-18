package com.tts.dao;

import com.tts.bean.*;

import java.util.Set;

/**
 * 注释见Users.xml
 */
public interface UsersDao {

    Users queryUserInfoByUid(Integer uid);

    Set<Order> queryOrdersByUid(Integer uid);

    Set<User_Red_package> queryRedPackageByUid(Integer uid);

    Set<Discount_coupon> queryDiscountCouponByUid(Integer uid);

    Set<User_Collect> queryCollectsByUid(Integer uid);
}
