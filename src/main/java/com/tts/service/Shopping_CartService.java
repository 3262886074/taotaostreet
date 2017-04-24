package com.tts.service;

import java.util.HashSet;
import java.util.List;

import com.tts.bean.Commodity_items;
import com.tts.bean.Order;
import com.tts.bean.Shopping_Cart;

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

	// 添加商品到商品条目表
	Integer addCommodity_items(Integer number, long ct_id, long ccid, long scId, long l);
	

	// 添加订单
	Integer addOrder(Order order);

	//查询订单
	Order getOders(long oid);

		//修改订单
	Integer updateOrder(Order order);



}
