package com.tts.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tts.bean.Commodity;
import com.tts.bean.Commodity_items;
import com.tts.bean.Shopping_Cart;

/**
 * Created by joe on 17/4/14.
 */
public interface Shopping_CartDao {
	
	List<Shopping_Cart> getAll();
	
//	通过购物车ID查询购物车信息、商品条目、用户信息
	List<Shopping_Cart> getShopping_cart(int scId);
	
//	通过商品条目id查询 商品条目 
	List<Commodity_items> getCommodity_items(int ciId);
	
//	  <!--通过商品ID查询商品信息  -->
	List<Commodity> getCommodity(int cid);

//通过类别查询类别
	
}
