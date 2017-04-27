package com.tts.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.tts.bean.Commodity;
import com.tts.bean.Commodity_items;
import com.tts.bean.Order;
import com.tts.bean.Shopping_Cart;
import com.tts.bean.User_Account;
import com.tts.bean.User_address;


/**
 * Created by joe on 17/4/14.
 */
public interface Shopping_CartDao {

	// 通过商品条目id查询 商品条目
	HashSet<Commodity_items> getCommodity_items(long scId);

	// 通过用户ID查询购物车信息、商品条目、用户信息
	Shopping_Cart getShopping_Cart(@Param("uid") long uid);
	
	// 通过购物车ID查询购物车信息、商品条目、用户信息
	Shopping_Cart getShopping_CartByscId(@Param("scId") long scId);

	//用户 添加购物车
	Integer addShopping_Cart(long uid);

	// 添加商品到商品条目表
	Integer addCommodity_items( 
			@Param("number") Integer number,
			@Param("ct_id") long ct_id,
			@Param("ccid") long ccid,
			@Param("cid") long cid,	
			@Param("scId") long scId
			);
	

	// <!--通过商品ID查询商品信息 -->
	List<Commodity> getCommodity(long cid);

	// 通过商品条目id 删除商品条目 表
	Integer deleteCommodity_items(long ciId);

	// 添加订单
	Integer addOrder(Order order);

	// 通过订单ID查询订单
	Order getOrder(long oid);

	// 修改订单状态
	Integer updateOrder(Order order);

	//根据用户ID和时间查询订单
	long getOid(@Param("uid") long uid, @Param("now") String now);

	//根据时间和uid 查询当前添加的购物车getShopping_CartSp
	Shopping_Cart getShopping_CartSp(@Param("uid")long uid,  @Param("now")String now);
	
	//根据ｃｉｉｄ　修改订单的数量
	Integer updateCommodity_items(@Param("ciId") long ciId,@Param("number") Integer number);

	//查询通过Uid用户账户
	User_Account getUserAccount(@Param("uid") long uid);
	
	//修改账户余额
	Integer updateuaMoney(@Param("uaId")long uaId,@Param("money") double money);

	//修改优惠券使用状态为1代表已使用updateDcst
	Integer updateDcst(@Param("dcId")long dcId);
	
	//修改红包使用状态为1代表已使用updateUrpst
	Integer updateUrpst(long urpId);

	//修改order的状态
	Integer updateOdst(long oid);

	//修改购物车用户IDupdateShopping_CartUid
	Integer updateShopping_CartUid(long scId);
	
	//添加商品到收藏夹addUser_Collect
	Integer addUser_Collect(@Param("cid")long cid, @Param("uid")long uid);
	
	//立即购买添加订单addOrderSp
	Integer addOrderSp(@Param("scId")long scId, @Param("uid")long uid);

	//查询用户默认地址getUser_address
	User_address getUser_address(long uid);
	
	//查询订单带地址
	Order getOrderUa(long oid);
	






}
