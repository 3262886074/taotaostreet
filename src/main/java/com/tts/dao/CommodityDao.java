package com.tts.dao;

import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Repository;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Combo;
import com.tts.bean.Commodity_Comment;
import com.tts.bean.Commodity_Category;
import com.tts.bean.Commodity_pics;
import com.tts.bean.Commodity_type;
@Repository("commodityDao")
public interface CommodityDao {


	/* 基础信息
	 * 通过商品id获得该商品的详细信息，套餐信息，样式信息，商品的图片，全部评价
	 */
	//详细信息
	public Commodity getById(long cid);
	//类别信息
	public Set<Commodity_Category> getCategory(long cid);
	//套餐信息
	public Set<Commodity_Combo> getCombo(long cid);
	//样式信息
	public Set<Commodity_type> getType(long cid);
	//图片详情
	public Commodity_pics getPics(long cid);
	//商品全部评价
	public Set<Commodity_Comment> getMent(long cid);
	
	/*
	 * 通过商品id获得该商品的月销量，累计销量，累计评价，好评数量，中评数量，差评数量，好评率
	 */
	//当月销量
	public int getMonthSell(long cid);
	//累计销量
	public int getAllSell(long cid);
	//累计评价
	public int getComment(long cid);
	//好评数量
	public int getGoodComm(long cid);
	//中评数量
	public int getMidComm(long cid);
	//差评数量
	public int getBadComm(long cid);
	
	
	/*
	 * 看了又看、猜你喜欢
	 */
	//看了又看，随机查询出除了当前商品的全部商品中的6条数据
	public List<Commodity> findAll(long cid);
	//猜你喜欢，根据当前浏览的类型进行随机查询20条数据
	public List<Long> findByCategory(List<Commodity_Category> category);

}
