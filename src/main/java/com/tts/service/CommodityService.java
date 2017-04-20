package com.tts.service;

import java.util.List;

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
	
	/**
	 * 查出当前类别的全部商品
	 * @param types
	 * @return
	 */
	public List<Commodity> findAllByType(String types);
	
	/**
	 * 查出除了当前商品之外的全部商品
	 * @param cid
	 * @return
	 */
	public List<Commodity> findAll(long cid);
}
