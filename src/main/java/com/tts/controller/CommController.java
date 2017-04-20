package com.tts.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tts.service.CommodityService;

@Controller
public class CommController {

	@Resource(name="commodityService")
	private CommodityService cs;
	
	@RequestMapping("toShowOne")
	public String toIntroduction(ModelMap map,long cid) {
		
		map.put("commodity", cs.getCommodity(cid));
		map.put("ds", cs.getDetails(cid));
		map.put("sell", cs.getSellCommentById(cid));
		map.put("seeList", cs.findAll(cid));
		map.put("likeList", cs.findByType("食品"));
		return "home/introduction";
	}
}
