package com.tts.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;
import com.tts.dao.IHomeDao;
import com.tts.service.IHomeService;

@Service("iHomeService")
public class HomeServiceImpl implements IHomeService {
	@Autowired
	public IHomeDao iHomeDao;

	@Override
	public List<Commodity> queryCname(String cctype) {
		return iHomeDao.queryCname(cctype);
	}

	@Override
	public List<Classify_one> queryClassify() {
		return iHomeDao.queryClassify();
	}

	@Override
	public List<Commodity> queryTop(String adjustTop) {
		String[] adjustRecommends = adjustTop.split(",");
		return iHomeDao.queryTop(adjustRecommends);
	}

	@Override
	public List<Commodity> queryNow(String adjustRecommend) {
		String[] adjustRecommends = adjustRecommend.split(",");
		return iHomeDao.queryNow(adjustRecommends);
	}

	@Override
	public List<Classify_two> queryCTwoId(String adjustTwoId, String adjustComId) {
		for (String c : adjustTwoId.split(",")) {
			System.out.println("测试数据" + c);
		}
		for (String c : adjustComId.split(",")) {
			System.out.println("测试数据：" + c);
		}
		Map<String, String[]> mapType = new HashMap<>();
		mapType.put("adjustTwoId", adjustTwoId.split(","));
		mapType.put("adjustComId", adjustComId.split(","));
		return iHomeDao.queryCTwoId(mapType);
	}

}
