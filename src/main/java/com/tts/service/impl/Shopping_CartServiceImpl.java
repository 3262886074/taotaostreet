package com.tts.service.impl;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.bean.Commodity_items;
import com.tts.bean.Order;
import com.tts.bean.Shopping_Cart;
import com.tts.dao.Shopping_CartDao;
import com.tts.service.Shopping_CartService;

@Service("shopping_CartService")
public class Shopping_CartServiceImpl implements Shopping_CartService {

	@Autowired
	private Shopping_CartDao shopping_CartDao;

	// 查询 购物车 表 数据
	@Override
	public Shopping_Cart getShopping_Cart(long scId) {
		Shopping_Cart shopping_Carts = shopping_CartDao.getShopping_Cart(scId);

		HashSet<Commodity_items> commodity_items = shopping_CartDao.getCommodity_items(scId);
		shopping_Carts.setCommodityItems(commodity_items);
		return shopping_Carts;
	}

	// 通过用户ID添加购物车，或查询
	@Override
	public Shopping_Cart addShopping_Cart(Integer uid) {

		if (shopping_CartDao.getShopping_Cart(uid) == null) {

			Integer add = shopping_CartDao.addShopping_Cart(uid);
		}
		return shopping_CartDao.getShopping_Cart(uid);

	}

	// 通过商品条目Id 删除商品条目表的商品
	@Override
	public Integer deleteCommodity_items(long ciId) {

		return shopping_CartDao.deleteCommodity_items(ciId);
	}

	// 添加商品到商品条目表
	@Override
	public Integer addCommodity_items(Integer number, long cid, long ct_id, long ccid, long scId) {

		return shopping_CartDao.addCommodity_items(ct_id, ccid, scId, number, cid);
	}

	// 添加订单
	@Override
	public Integer addOrder(Order order) {

		return shopping_CartDao.addOrder(order);
	}

	// 查询订单
	@Override
	public Order getOders(long oid) {
		Order order = shopping_CartDao.getOrder(oid);

		long scId = order.getShoppingCart().getScId();

		Shopping_Cart shoppingCart = shopping_CartDao.getShopping_Cart(scId);

		order.setShoppingCart(shoppingCart);
		return order;
	}

	// 根据scid购物车ID 查询商品条目表内的商品
	@Override
	public HashSet<Commodity_items> getCommodity_items(long scId) {

		return shopping_CartDao.getCommodity_items(scId);
	}

	// 修改订单表订单状态
	@Override
	public Integer updateOrder(Order order) {

		return shopping_CartDao.updateOrder(order);
	}

}
