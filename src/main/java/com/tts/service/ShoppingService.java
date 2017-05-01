package com.tts.service;

import com.tts.bean.Commodity_items;
import com.tts.bean.Discount_coupon;
import com.tts.bean.Order;
import com.tts.bean.User_Red_package;

import java.util.Set;

/**
 * Created by joe on 17/4/27.
 */
public interface ShoppingService {

    Set<Commodity_items> showItems(long uid);

    void addShopCart(long uid);

    String addItemsBySCId(long cid, long ctid, long ccid, Integer number, long scid);

    String addOneOrder(long scid, double money, long dcid, long urpid, long uaid, long uid);

    Order getOrderInfoByOid(long uid);

    long getMaxScidByUid(long uid);

    long getMaxOIdByUid(long uid);

    Set<User_Red_package> queryRedPackageByUid(long uid);

    Set<Discount_coupon> queryDiscountCouponByUid(long uid);

}
