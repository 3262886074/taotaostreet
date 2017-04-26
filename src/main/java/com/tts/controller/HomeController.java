package com.tts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
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

	/**
	 * 搜索商品
	 * 
	 * @return
	 */
	@RequestMapping(value = "/home/query", method = RequestMethod.GET)
	public String queryCname(@RequestParam(value = "type", required = false) String cctype, ModelMap map) {
		List<Commodity> commodityList = iHomeService.queryCname(cctype);
		map.put("commodityList", commodityList);
		return "home/search";
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
