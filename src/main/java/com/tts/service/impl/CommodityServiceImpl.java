package com.tts.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Sell;
import com.tts.dao.CommodityDao;
import com.tts.service.CommodityService;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService{

	@Resource(name="commodityDao")
	private CommodityDao cd;
	
	@Override
	public Commodity getCommodity(long cid) {
		
		Commodity commodity = cd.getById(cid);
		commodity.setCombos(cd.getCombo(cid));
		commodity.setCommodityTypes(cd.getType(cid));
		commodity.setCommodityPics(cd.getPics(cid));
		commodity.setComments(cd.getMent(cid));
		return commodity;
	}

	@Override
	public Commodity_Sell getSellCommentById(long cid) {
		
		Commodity_Sell sell = new Commodity_Sell();
		sell.setMonthSell(cd.getMonthSell(cid));
		sell.setAllSell(cd.getAllSell(cid));
		sell.setAllComm(cd.getComment(cid));
		return sell;
	}

}
