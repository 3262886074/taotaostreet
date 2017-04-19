package com.tts.dao;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Combo;
import com.tts.bean.Commodity_Comment;
import com.tts.bean.Commodity_pics;
import com.tts.bean.Commodity_type;
@Repository("commodityDao")
public interface CommodityDao {


	/* 基础信息
	 * 通过商品id获得该商品的详细信息，套餐信息，样式信息，商品的图片，全部评价
	 */
	//详细信息
	public Commodity getById(long cid);
	//套餐信息
	public Set<Commodity_Combo> getCombo(long cid);
	//样式信息
	public Set<Commodity_type> getType(long cid);
	//图片详情
	public Set<Commodity_pics> getPics(long cid);
	//商品全部评价
	public Set<Commodity_Comment> getMent(long cid);
	
	/*
	 * 通过商品id获得该商品的月销量，累计销量，累计评价
	 */
	//当月销量
	public int getMonthSell(long cid);
	//累计销量
	public int getAllSell(long cid);
	//累计评价
	public int getComment(long cid);
	
	/*
	 * 猜你喜欢，看了又看
	 */
	//猜你喜欢，查出当前类别的全部商品
	public List<Commodity> findAllByType(String types);
	//看了又看，查出除了当前商品之外的全部商品
	public List<Commodity> findAll(long cid);
}
