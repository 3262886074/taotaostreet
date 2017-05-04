package com.tts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
import com.tts.bean.Paging_Commodity;
import com.tts.service.IHomeService;

/**
 * 主页
 * 
 * @author SYY
 *
 */
@Controller
public class HomeController {
	@Autowired
	private IHomeService iHomeService;

	@Value("#{configProperties['adjustTwoId']}")
	private String adjustTwoId;

	@Value("#{configProperties['adjustComId']}")
	private String adjustComId;

	@Value("#{configProperties['adjustTop']}")
	private String adjustTop;

	@Value("#{configProperties['adjustRecommend']}")
	private String adjustRecommend;

	// /**
	// * 搜索商品
	// *
	// * @return
	// */
	// @RequestMapping(value = "/home/query", method = RequestMethod.GET)
	// public String queryCname(@RequestParam(value = "type", required = false)
	// String cctype, ModelMap map) {
	// List<Commodity> commodityList = iHomeService.queryCname(cctype);
	// map.put("commodityList", commodityList);
	// List<Long> bids = new ArrayList<>();
	// List<Long> sids = new ArrayList<>();
	// if (commodityList != null) {
	// for (Commodity c : commodityList) {
	// bids.add(c.getBid());
	// sids.add(c.getSid());
	// }
	// }
	// // 查询品牌
	// List<Brand> brandList = iHomeService.queryBrandName(bids);
	// map.put("brandList", brandList);
	// // 查询产地
	// List<Site> siteList = iHomeService.querySiteName(sids);
	// map.put("siteList", siteList);
	// return "home/search";
	// }

	/**
	 * 第一次进搜索页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/home/query", method = RequestMethod.GET)
	public String queryCname(@RequestParam(value = "parameter", required = false) String parameter, ModelMap map) {
		Paging_Commodity pagCom = iHomeService.queryCname(parameter);
		List<Commodity> reComs = iHomeService.queryReComs();
		map.put("pagCom", pagCom);
		map.put("reComs", reComs);
		return "home/search";
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNow
	 * @param pageSize
	 * @param parameter
	 * @param searchBid
	 * @param searchSid
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/home/query/search", method = RequestMethod.GET)
	public @ResponseBody Paging_Commodity queryPaging(@RequestParam(value = "pageNow", required = false) Integer pageNow,
			@RequestParam(value = "pageSize", required = false) Integer pageSize,
			@RequestParam(value = "parameter", required = false) String parameter,
			@RequestParam(value = "searchBid", required = false) Long searchBid,
			@RequestParam(value = "searchSid", required = false) Long searchSid,
			@RequestParam(value = "sortType", required = false) Integer sortType,
			@RequestParam(value = "sortWay", required = false) Integer sortWay) {
		Paging_Commodity pagCom = iHomeService.queryPaging(pageNow, pageSize, parameter, searchBid, searchSid,sortType,sortWay);
		return pagCom;
	}

	/**
	 * 首页展示查询
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/")
	public String pageIndex(ModelMap map) {
		// 全部分类
		List<Classify_one> classifyOneList = iHomeService.queryClassify();
		map.put("classifyOneList", classifyOneList);
		// 商城头条
		List<Commodity> commodityList = iHomeService.queryTop(adjustTop);
		map.put("commodityList", commodityList);
		// 今日推荐
		List<Commodity> commodityNow = iHomeService.queryNow(adjustRecommend);
		map.put("commodityNow", commodityNow);
		// 底部分类展示
		List<Classify_two> ClassifyTwoList = iHomeService.queryCTwoId(adjustTwoId, adjustComId);
		map.put("ClassifyTwoList", ClassifyTwoList);
		return "home/home";
	}
}
