package com.tts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Category;
import com.tts.bean.Commodity_Sell;
import com.tts.bean.Discount_coupon;
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
		commodity.setComments(cd.getMent(cid));
		commodity.setCommodityPics(cd.getPics(cid));
		commodity.setCommodityCategories(cd.getCategory(cid));
		Commodity_Sell sell = new Commodity_Sell();
		sell.setMonthSell(cd.getMonthSell(cid));
		sell.setAllSell(cd.getAllSell(cid));
		sell.setAllComm(cd.getComment(cid));
		sell.setGoodcomm(cd.getGoodComm(cid));
		sell.setMidcomm(cd.getMidComm(cid));
		sell.setBadcomm(cd.getBadComm(cid));
		double f = (double)cd.getGoodComm(cid)/(double)cd.getComment(cid);
		sell.setGoodlv((int) (f*100));
		commodity.setCommoditySell(sell);
		return commodity;
	}

	@Override
	public List<Commodity> findAll(long cid) {
		
		List<Commodity> coms = new ArrayList<>();
		List<Commodity> list= cd.findAll(cid);
		for (Commodity commodity : list) {
		     coms.add(getCommodity(commodity.getCid()));
		}
		return coms;
	}

	@Override
	public List<String> getDetails(long cid) {
		
		String[] args = cd.getById(cid).getDetails().split("，");
		List<String> ds = new ArrayList<>();
		for (int i = 0; i < args.length; i++) {
			ds.add(args[i]);
		}
		return ds;
	}

	@Override
	public List<Commodity> findByCate(long cid) {
		
		return cd.findByCategory(cid);
	}

	@Override
	public List<Discount_coupon> fingDc(long uid) {
		return cd.findDc(uid);
	}

	@Override
	public boolean addDc(Discount_coupon dc, long uid) {
		return cd.addDc(dc, uid)>0?true:false;
	}

}
