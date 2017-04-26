package com.tts.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tts.bean.Discount_coupon;
import com.tts.service.CommodityService;

@Controller
public class CommController {

	@Resource(name="commodityService")
	private CommodityService cs;

	@RequestMapping("toShowOne")
	public String toIntroduction(ModelMap map,@RequestParam("cid")long cid) {
		
		map.put("commodity", cs.getCommodity(cid));
		map.put("ds", cs.getDetails(cid));
		map.put("seeList", cs.findAll(cid));
		map.put("likeList", cs.findByCate(cid));
		return "home/introduction";
	}
	
	@ResponseBody
	@RequestMapping(value="getDc",produces={"application/json;charset=UTF-8"})
	public Integer getDc(Integer cond,Integer red,long uid,ModelMap map) {
		
		boolean isTrue = false;
		Integer mm = 0;
		List<Discount_coupon> dcs = cs.fingDc(uid);
		for (Discount_coupon dc : dcs) {
			if (dc.getCondition().equals(cond)&&dc.getReduce().equals(red)) {
				isTrue = true;
				mm = 1;
				break;
			}
		}
		if (!isTrue) {
			Discount_coupon dc = new Discount_coupon();
			dc.setCondition(cond);
			dc.setReduce(red);
			cs.addDc(dc, uid);
		}
		return mm;
	}
}
