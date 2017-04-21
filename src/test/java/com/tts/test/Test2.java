package com.tts.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.tts.dao.HomeDao;
import com.tts.service.CommodityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class Test2 {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CommodityService cs;
	@Autowired
	private HomeDao homeDao;

	@org.junit.Test
	public void test() {
		// Commodity commodity = cs.getCommodity(1);
		// logger.info("详情={}",commodity);
		//

		logger.info("销量={}", homeDao.cnameQuery("hh"));

		// List<Commodity> l = cs.findByType("食品");
		// for (Commodity commodity : l) {
		// logger.info("详情={}",commodity);
		// }
		// List<String> l = cs.getDetails(1);
		// for (String string : l) {
		// logger.info("详情={}",string);
		// }
	}

}
