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
	 * 通过商品ID获得商品的1、月销量/2、累计销量/3、累计评价/4、好评数量/5、中评数量/6、差评数量/7、好评率
	 * @param cid
	 * @return
	 */
	public Commodity_Sell getSellCommentById(long cid);
	
	/**
	 * 查询出除了当前商品的全部商品，看了又看
	 * @param cid
	 * @return
	 */
	public List<Commodity> findAll(long cid);
	
	/**
	 * 根据当前浏览的类型进行查询，猜你喜欢
	 * @param types
	 * @return
	 */
	public List<Commodity> findByType(String types);
	
	/**
	 * 截取产品参数
	 * @param cid
	 * @return
	 */
	public List<String> getDetails(long cid);
}
