package com.tts.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Category;
import com.tts.bean.Discount_coupon;
import com.tts.dao.CommodityDao;
import com.tts.service.CommodityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class Test {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommodityService cs;
	@Autowired
	private CommodityDao cd;
	
	@org.junit.Test
	public void test(){
		
//		List<Long> list = cs.findByCate(2);
//		for (Long long1 : list) {
//			logger.info("详情={}",long1);
//		}
		
//		List<Discount_coupon> l= cs.fingDc(1);
//		for (Discount_coupon commodity : l) {
//			logger.info("aa={}",commodity);
//		}
		
		Discount_coupon dc = new Discount_coupon();
		dc.setCondition(400);
		dc.setReduce(120);
		if (cd.addDc(dc, 1)>0) {
			System.out.println("添加成功");
		}
		
//		Commodity_Sell sell = cs.getSellCommentById(1);
//		logger.info("销量={}",sell);
		
//		List<Commodity> l = cs.findByType("食品");
//		for (Commodity commodity : l) {
//			logger.info("详情={}",commodity);
//		}
//		List<String> l = cs.getDetails(1);
//		for (String string : l) {
//			logger.info("详情={}",string);
//		}
	}
	
	@org.junit.Test
	public void fun1(){
		Integer t1 = new Integer(1);
		Integer t2 = new Integer(1);
		System.out.println(t1 == 1);
		System.out.println(t1 == t2);
	}

}
