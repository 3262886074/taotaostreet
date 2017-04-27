package com.tts.service;

import com.tts.bean.Commodity_items;
import com.tts.bean.Order;
import com.tts.bean.Shopping_Cart;

import java.util.HashSet;


/**
 * Created by joe on 17/4/14.
 */
public interface Shopping_CartService {
    // 通过用户ID查询购物车信息、商品条目、用户信息
    Shopping_Cart getShopping_Cart(long uid);

    // 通过商品条目Id 查询商品条目
    HashSet<Commodity_items> getCommodity_items(long scId);

    // 通过商品条目id 删除商品条目 表
    Integer deleteCommodity_items(long ciId);

    // 通过用户ID 添加购物车
    Shopping_Cart addShopping_Cart(Integer uid);

    // 通过用户ID 添加购物车(立即购买的购物车)
    Shopping_Cart addShopping_CartSp(long uid);

    // 添加商品到商品条目表
    Integer addCommodity_items(Integer number, long ct_id, long ccid, long scId, long l);

    // 添加订单
    Integer addOrder(Order order);

    // 查询订单
    Order getOders(long oid);

    // 修改订单
    Integer updateOrder(Order order, long uid);

    // 查询当前添加的订单通过时间和用户ID
    long getOid(long uid, String now);

    // 修改商品条目表商品的信息
    Integer updateShoppingCart(Commodity_items commodity_items);

    //修改购物车用户ID
    Integer updateShopping_CartUid(long scId);

    //添加商品到收藏夹
    Integer addUser_Collect(long cid, long uid);

    //添加订单
    Integer addOrderSp(long scId, long uid);


}
