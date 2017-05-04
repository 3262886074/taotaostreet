package com.tts.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.bean.Brand;
import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Sell;
import com.tts.bean.Commodity_pics;
import com.tts.bean.Paging_Commodity;
import com.tts.bean.Site;
import com.tts.dao.IHomeDao;
import com.tts.service.IHomeService;

@Service("iHomeService")
public class HomeServiceImpl implements IHomeService {
	@Autowired
	public IHomeDao iHomeDao;

	/*
	 * 查询商品(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#queryCname(java.lang.String)
	 */
	@Override
	public Paging_Commodity queryCname(String parameter) {
		// 查询分页保存对象创建
		Paging_Commodity pagCom = new Paging_Commodity();
		pagCom.setCommodity(iHomeDao.queryPaging(1, 12, parameter, 0, 0, 0, 0));

		List<Commodity> commodity = iHomeDao.queryPagingSum(parameter, 0, 0);
		List<Long> bids = new ArrayList<>();
		List<Long> sids = new ArrayList<>();
		// 查询品牌
		List<Brand> brandList = null;
		// 查询产地
		List<Site> siteList = null;
		if (commodity != null && commodity.size() != 0) {
			for (Commodity c : commodity) {
				bids.add(c.getBid());
				sids.add(c.getSid());
			}
			brandList = iHomeDao.queryBrandName(bids);
			siteList = iHomeDao.querySiteName(sids);
		}
		pagCom.setSumPage(commodity.size());
		pagCom.setParameter(parameter);
		pagCom.setBrand(brandList);
		pagCom.setSite(siteList);

		return pagCom;
	}

	/*
	 * 查询分页(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#querySearCommodity(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Paging_Commodity queryPaging(int pageNow, int pageSize, String parameter, long searchBid, long searchSid,
			int sortType, int sortWay) {
		// 查询分页保存对象创建
		Paging_Commodity pagCom = new Paging_Commodity();
		pagCom.setParameter(parameter);
		pagCom.setSumPage(iHomeDao.queryPagingSum(parameter, searchBid, searchSid).size());
		// 获取商品集合
		List<Commodity> commodity = iHomeDao.queryPaging(pageNow, pageSize, parameter, searchBid, searchSid, sortType,
				sortWay);
		for (Commodity c : commodity) {

			if (c.getCommoditySell() == null) {
				Commodity_Sell comSell = new Commodity_Sell();
				comSell.setAllSell(0);
				c.setCommoditySell(comSell);
			}
			if (c.getCommodityPics() == null || c.getCommodityPics().getCpImg() == null) {
				Commodity_pics comPics = new Commodity_pics();
				comPics.setCpImg("/resources/images/moren.jpg");
				c.setCommodityPics(comPics);
			}
		}
		pagCom.setCommodity(commodity);
		return pagCom;
	}

	/*
	 * 查询商品分类(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#queryClassify()
	 */
	@Override
	public List<Classify_one> queryClassify() {
		return iHomeDao.queryClassify();
	}

	/*
	 * 商城头条(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#queryTop(java.lang.String)
	 */
	@Override
	public List<Commodity> queryTop(String adjustTop) {
		String[] adjustRecommends = adjustTop.split(",");
		return iHomeDao.queryTop(adjustRecommends);
	}

	/*
	 * 今日推荐(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#queryNow(java.lang.String)
	 */
	@Override
	public List<Commodity> queryNow(String adjustRecommend) {
		String[] adjustRecommends = adjustRecommend.split(",");
		return iHomeDao.queryNow(adjustRecommends);
	}

	/*
	 * 推荐类别(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#queryCTwoId(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<Classify_two> queryCTwoId(String adjustTwoId, String adjustComId) {
		Map<String, String[]> mapType = new HashMap<>();
		mapType.put("adjustTwoId", adjustTwoId.split(","));
		mapType.put("adjustComId", adjustComId.split(","));
		return iHomeDao.queryCTwoId(mapType);
	}

	/*
	 * 随机获取(non-Javadoc)
	 * 
	 * @see com.tts.service.IHomeService#queryReComs()
	 */
	@Override
	public List<Commodity> queryReComs() {
		List<Commodity> reComs = iHomeDao.queryReComs();
		for (Commodity c : reComs) {

			if (c.getCommoditySell() == null) {
				Commodity_Sell comSell = new Commodity_Sell();
				comSell.setAllSell(0);
				c.setCommoditySell(comSell);
			}
			if (c.getCommodityPics() == null || c.getCommodityPics().getCpImg() == null) {
				Commodity_pics comPics = new Commodity_pics();
				comPics.setCpImg("/resources/images/moren.jpg");
				c.setCommodityPics(comPics);
			}
		}
		return reComs;
	}

}
