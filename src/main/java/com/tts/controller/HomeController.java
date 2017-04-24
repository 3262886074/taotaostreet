package com.tts.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
		List<Commodity> commodityList = iHomeService.queryTop();
		map.put("commodityList", commodityList);
		// 底部分类展示
		List<Classify_two> ClassifyTwoList = iHomeService.queryCTwoId();
		map.put("ClassifyTwoList", ClassifyTwoList);
		return "home/home";
	}
}
