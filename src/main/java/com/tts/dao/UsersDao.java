package com.tts.dao;

import com.tts.bean.*;
import org.apache.ibatis.annotations.Param;

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

    Integer updateInfo(Users users);

    Integer updatePwd(@Param("upwd") String upwd,@Param("uid") Integer uid);

    Integer addAuthentication(Users_Authentication users_authentication);

    Integer addSafetyQuestion(User_Safety_Question user_safety_question);

    Set<User_address> getAddressesByUId(Integer uid);

    Integer updateUnDefaultAddress(Integer uid);

    Integer updateDefaultAddress(Integer uaid);

    Integer addOneAddress(@Param("uaname") String uaname,
                          @Param("uatel") long uatel,
                          @Param("location") String location,
                          @Param("address") String address,
                          @Param("uid") Integer uid);
}
