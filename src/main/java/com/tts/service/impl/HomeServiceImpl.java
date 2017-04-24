package com.tts.service.impl;

import java.util.List;
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
	public List<Commodity> queryTop(){
		return iHomeDao.queryTop();
	}

	@Override
	public List<Classify_two> queryCTwoId() {
		return iHomeDao.queryCTwoId();
	}

}
