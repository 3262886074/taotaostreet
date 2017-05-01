package com.tts.dao;

import com.tts.bean.Discount_coupon;
import com.tts.bean.Shopping_Cart;
import com.tts.bean.User_Red_package;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * Created by joe on 17/4/27.
 */
public interface ShoppingDao {

    Set<Shopping_Cart> queryShoppingCartsByUid(long uid);

    long queryMaxSCIdByUid(long uid);

    long getMaxOIdByUid(long uid);

    Integer addShopCartByUid(long uid);

    Integer updateComNumber(@Param("number") Integer number,
                            @Param("cid") long cid);

    Integer updateSCStatusBySCid(long scid);

    Set<User_Red_package> queryRedPackageByUid(long uid);

    Set<Discount_coupon> queryDiscountCouponByUid(long uid);

    Integer addItemsBySCId(@Param("cid") long cid,
                           @Param("ctid") long ctid,
                           @Param("ccid") long ccid,
                           @Param("number") long number,
                           @Param("scid") long scid);

    Integer addOneOrder(@Param("scid") long scid,
                        @Param("money") double money,
                        @Param("dcid") long dcid,
                        @Param("urpid") long urpid,
                        @Param("uaid") long uaid,
                        @Param("uid") long uid);
}
