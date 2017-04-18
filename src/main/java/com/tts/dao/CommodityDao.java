package com.tts.dao;

import com.tts.bean.Commodity;

public interface CommodityDao {

	/**
	 * 通过商品ID获得商品基本信息
	 * @param cid
	 * @return
	 */
	public Commodity getById(Integer cid);
	
	
	
}
