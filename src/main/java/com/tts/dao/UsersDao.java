package com.tts.dao;

import com.tts.bean.*;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 注释见Users.xml
 */
public interface UsersDao {

    Users userLogin(@Param("unickname") String nickname, @Param("upwd") String pwd);

    Integer userRegister(@Param("nickname") String nickname, @Param("pwd") String pwd);

    Users queryUserInfoByUid(long uid);

    Set<User_Red_package> queryRedPackageByUid(long uid);

    Set<Discount_coupon> queryDiscountCouponByUid(long uid);

    Set<User_Collect> queryCollectsByUid(long uid);

    Integer updateInfo(Users users);

    Integer updatePwd(@Param("upwd") String upwd, @Param("uid") long uid);

    Integer addAuthentication(@Param("uid") Long uid, @Param("uraName") String uname, @Param("idcard") Long idcard);

    Integer addSafetyQuestion(User_Safety_Question user_safety_question);

    Users_Authentication queryAuthenticationByUid(long uid);

    User_Safety_Question querySafetyQuestionByUid(long uid);

    Integer updateSafetyQuestion(User_Safety_Question user_safety_question);

    Set<User_address> getAddressesByUId(long uid);

    Integer updateUnDefaultAddress(long uid);

    Integer updateDefaultAddress(long uaid);

    User_address queryAddressByUaId(long uaid);

    Integer deleteAddressByUaId(long uaid);

    Integer addOneAddress(@Param("uaname") String uaname,
                          @Param("uatel") long uatel,
                          @Param("location") String location,
                          @Param("address") String address,
                          @Param("uid") long uid);

    Set<Order> queryOrdersByUid(long uid);

    Set<Commodity_items> queryItemsByScid(long scid);

    User_Account getAccountMoney(long uid);

    Order queryOrderInfoByOid(long oid);

    Integer updateAccountMoney(@Param("money") double money,
                               @Param("uid") long uid);

    Integer reduceCommodityNumber(@Param("number") Integer number,
                                  @Param("cid") long cid);

    Integer updateOrderStatus(long oid);

    Integer cancelOrder(long oid);

    Integer returnMoney(@Param("money") double money, @Param("uid") long uid);

    Integer addCommodityNumber(@Param("number") Integer number, @Param("cid") long cid);

    Integer confirmOrder(long oid);

    Integer addComment(@Param("content") String content,
                       @Param("type") Integer type,
                       @Param("uid") long uid,
                       @Param("cid") long cid);

    Integer okOrder(long oid);

}