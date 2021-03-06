package com.tts.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tts.bean.Brand;
import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
import com.tts.bean.Paging_Commodity;
import com.tts.bean.Site;

public interface IHomeService {
	// 1、（主页搜索框）按名称搜索商品
	public Paging_Commodity queryCname(String parameter);

	// 查询分页
	public Paging_Commodity queryPaging(int pageNow, int pageSize, String parameter, long searchBid, long searchSid,
			int sortType, int sortWay);

	// 查询商品分类
	public List<Classify_one> queryClassify();

	// （商城头条）查询（商品价格减打折价）最大值排序（前七条）
	public List<Commodity> queryTop(String adjustTop);

	// （今日推荐）按商品排序查出前 三条
	public List<Commodity> queryNow(String adjustRecommend);

	// （类别）查询类别和商品供 （六条或更多）
	public List<Classify_two> queryCTwoId(String adjustTwoId, String adjustComId);

	// 随机获取（搜索页面的推挤）
	public List<Commodity> queryReComs();
}
