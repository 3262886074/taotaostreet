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
	List<Shopping_Cart> getShopping_cart(int scId);
	List<Commodity> getCommodity(int cid);
	
}
