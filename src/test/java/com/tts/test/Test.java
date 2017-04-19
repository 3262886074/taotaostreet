package com.tts.test;


import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Sell;
import com.tts.service.CommodityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class Test {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommodityService cs;
	
	@org.junit.Test
	public void test(){
		Commodity commodity = cs.getCommodity(1);
		logger.info("详情={}",commodity);
		
		Commodity_Sell sell = cs.getSellCommentById(1);
		logger.info("销量={}",sell);
		
	}

}
