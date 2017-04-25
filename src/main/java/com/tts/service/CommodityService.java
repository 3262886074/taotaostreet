package com.tts.service;

import java.util.List;
import java.util.Set;

import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Category;
import com.tts.bean.Discount_coupon;

public interface CommodityService {

	/**
	 * 通过ID获得商品的基础信息以及评价
	 * 商品ID获得商品的1、月销量/2、累计销量/3、累计评价/4、好评数量/5、中评数量/6、差评数量/7、好评率
	 * @param cid
	 * @return
	 */
	public Commodity getCommodity(long cid);
	
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
	public List<Commodity> findByCate(long cid);
	
	/**
	 * 截取产品参数
	 * @param cid
	 * @return
	 */
	public List<String> getDetails(long cid);
	
	/**
	 * 获取用户的优惠券
	 * @param cid
	 * @return
	 */
	public List<Discount_coupon> fingDc(long uid);
	
	/**
	 * 给用户添加优惠券
	 * @param dc
	 * @param uid
	 * @return
	 */
	public boolean addDc(Discount_coupon dc,long uid);
}
