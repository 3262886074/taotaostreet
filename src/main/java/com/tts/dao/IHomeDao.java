package com.tts.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tts.bean.Brand;
import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
import com.tts.bean.Site;

/**
 * 首页数据显示查询
 * 
 * @author SYY
 *
 */
public interface IHomeDao {

	// （主页搜索框）按类型搜索商品 (参数 ：商品类别)
	public List<Commodity> queryCname(@Param("parameter") String parameter);

	// 查询品牌
	public List<Brand> queryBrandName(List<Long> bids);

	// 查询产地
	public List<Site> querySiteName(List<Long> sids);

	// 查询分页
	public List<Commodity> queryPaging(@Param("pageNow") long pageNow, @Param("pageSize") long pageSize,
			@Param("parameter") String parameter, @Param("searchBid") long searchBid,
			@Param("searchSid") long searchSid, @Param("sortType") int sortType, @Param("sortWay") int sortWay);

	// 查询总页数
	public List<Commodity> queryPagingSum(@Param("parameter") String parameter, @Param("searchBid") long searchBid,
			@Param("searchSid") long searchSid);

	// (商品分类)查询商品分类
	public List<Classify_one> queryClassify();

	// （商城头条）查询（商品价格减打折价）最大值排序（前七条）
	public List<Commodity> queryTop(String[] adjustTop);

	// （今日推荐）按商品排序查出前 三条
	public List<Commodity> queryNow(String[] adjustRecommend);

	// （类别）查询类别和商品供 （六条或更多）
	public List<Classify_two> queryCTwoId(@Param("mapType") Map<String, String[]> mapType);
	//随机推荐
	public List<Commodity> queryReComs();

}
