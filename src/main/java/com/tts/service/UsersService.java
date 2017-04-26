package com.tts.service;

import com.tts.bean.*;
import com.tts.dto.PayExecution;

import java.util.Set;

public interface UsersService {

    Users userLogin(String nickname, String pwd);

    boolean userRegister(String nickname, String pwd);

    Users queryUserInfoByUid(long uid);

    Set<User_Red_package> queryRedPackageByUid(long uid);

    Set<Discount_coupon> queryDiscountCouponByUid(long uid);

    Set<User_Collect> queryCollectsByUid(long uid);

    boolean updateInfo(Users users);

    boolean updatePwd(String upwd, long uid);

    boolean addAuthentication(Long uid, String name, Long idcard);

    boolean addSafetyQuestion(User_Safety_Question user_safety_question);

    Users_Authentication queryAuthenticationByUid(Long uid);

    User_Safety_Question querySafetyQuestionByUid(Long uid);

    boolean updateSafetyQuestion(User_Safety_Question user_safety_question);

    Set<User_address> getAddressesByUId(long uid);

    boolean updateDefaultAddress(long uid, long uaid);

    User_address queryAddressByUaId(Long uaid);

    boolean deleteAddressByUaId(Long uaid);

    boolean addOneAddress(String uaname, long uatel, String location, String address, long uid);

    Set<Order> queryOrdersByUid(long uid);

    Set<Commodity_items> queryItemsByScid(long scid);

    User_Account getAccountMoney(long uid);

    Order queryOrderInfoByOid(long oid);

    PayExecution executePay(long oid, long uid);

    String cancelOrder(long oid, long uid);

    String confirmOrder(long oid);

    String addComment(String content, Integer type, long uid, long cid);
}