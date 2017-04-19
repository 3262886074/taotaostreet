package com.tts.service;

import com.tts.bean.*;

import java.util.Set;

public interface UsersService {

    Users queryUserInfoByUid(Integer uid);

    Set<Order> queryOrdersByUid(Integer uid);

    Set<User_Red_package> queryRedPackageByUid(Integer uid);

    Set<Discount_coupon> queryDiscountCouponByUid(Integer uid);

    Set<User_Collect> queryCollectsByUid(Integer uid);

    boolean updateInfo(Users users);

    boolean updatePwd(String upwd, Integer uid);

    boolean addAuthentication(Users_Authentication users_authentication);

    boolean addSafetyQuestion(User_Safety_Question user_safety_question);

    Set<User_address> getAddressesByUId(Integer uid);

    boolean updateUnDefaultAddress(Integer uid);

    boolean updateDefaultAddress(Integer uaid);

    boolean addOneAddress(String uaname, long uatel, String location, String address, Integer uid);
}
