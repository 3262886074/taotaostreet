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
	public String toIntroduction(ModelMap map) {
		
		map.put("commodity", cs.getCommodity(1));
		return "home/introduction";
	}
}
