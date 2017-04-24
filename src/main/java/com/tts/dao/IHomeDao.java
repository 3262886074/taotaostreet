package com.tts.dao;

import java.util.List;
import java.util.Set;

import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
import com.tts.bean.Users;

/**
 * 首页数据显示查询
 * 
 * @author SYY
 *
 */
public interface IHomeDao {

	// （主页搜索框）按类型搜索商品 (参数 ：商品类别)
	public List<Commodity> queryCname(String cctype);

	// (商品分类)查询商品分类
	public List<Classify_one> queryClassify();

	// （商城头条）查询（商品价格减打折价）最大值排序（前七条）
	public List<Commodity> queryTop();

	// （今日推荐）按商品排序查出前 三条
	public Commodity query();

	// （类别）查询类别和商品供 （六条或更多）
	public List<Classify_two> queryCTwoId();

}
