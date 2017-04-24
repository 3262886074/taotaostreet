package com.tts.service;

import java.util.List;
import java.util.Set;

import com.tts.bean.Classify_one;
import com.tts.bean.Classify_two;
import com.tts.bean.Commodity;

public interface IHomeService {
	// 1、（主页搜索框）按名称搜索商品
	public List<Commodity> queryCname(String cctype);

	// 查询商品分类
	public List<Classify_one> queryClassify();

	// （商城头条）查询（商品价格减打折价）最大值排序（前七条）
	public List<Commodity> queryTop();

	// （类别）查询类别和商品供 （六条或更多）
	public List<Classify_two> queryCTwoId();
}
