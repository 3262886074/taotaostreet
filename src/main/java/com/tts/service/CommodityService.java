package com.tts.service;

import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Sell;

public interface CommodityService {

	/**
	 * 通过ID获得商品的基础信息以及评价
	 * @param cid
	 * @return
	 */
	public Commodity getCommodity(long cid);
	
	/**
	 * 通过商品ID获得商品的1、月销量/2、累计销量/3、累计评价
	 * @param cid
	 * @return
	 */
	public Commodity_Sell getSellCommentById(long cid);
}
