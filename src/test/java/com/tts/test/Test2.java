package com.tts.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tts.bean.Classify_two;
import com.tts.dao.IHomeDao;
import com.tts.service.IHomeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test2 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IHomeService iHomeService;
	@Autowired
	private IHomeDao iHomeDao;

	@org.junit.Test
	public void test() {

		// logger.info("商品={}", iHomeService.queryCname("千层饼"));

		// List<Classify_one> classifyOne = iHomeDao.queryClassify();
		// for (Classify_one c : classifyOne) {
		// System.out.println(c);
		// System.out.println(c.getClassifyTwo());
		// for (Classify_two b : c.getClassifyTwo()) {
		// System.out.println(b);
		// }
		// }
		// logger.info("商品分类={}", classifyOne);

		// 商城头条
		// String[] adjustTop = {};
		// logger.info("商品分类={}", iHomeDao.queryTop(adjustTop));

		String[] adjustRecommend = { "1", "2", "3" };
		logger.info("商品分类={}", iHomeDao.queryNow(adjustRecommend));

		// 商品分类推荐显示显示
		// String[] a = { "5", "15", "16" };
		// String[] b = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
		// "11", "12", "13", "14", "15", "16", "17",
		// "18" };
		//
		// Map<String, String[]> map = new HashMap<>();
		// map.put("adjustTwoId", a);
		// map.put("adjustComId", b);
		//
		// List<Classify_two> two = iHomeDao.queryCTwoId(map);
		// for (Classify_two t : two) {
		// System.out.println("测试：" + t);
		// }
		// logger.info("商品分类={}", two);

	}

}
