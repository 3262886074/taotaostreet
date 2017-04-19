package com.tts.dao;

import com.tts.bean.Commodity;
import com.tts.bean.Users;

/**
 * 首页数据显示查询
 * 
 * @author SYY
 *
 */
public interface HomeDao {
	// （登录）用户登录
	public Users Login(long uid, String upwd);

	// （注册）用户注册
	public Users register(long uid, String upwd);

	// 1、（主页搜索框）按名称搜索商品 2、（商品分类）按分类搜索商品
	public Commodity cnameQuery(String cname);

	// （今日推荐）按商品排序查出前 三条
	public Commodity query();

	// （活动）查询有优惠券的商品（四条或全部）
	public Commodity dcQuery();

	// （类别）按类别查询商品（六条或更多）
	public Commodity categoryQuery(String category);

	// （商城头条）查询（商品价格减打折价）最大值排序（前七条）
	public Commodity topQuery();

}
