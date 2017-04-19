package com.tts.test;

import java.util.List;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tts.bean.Commodity;
import com.tts.bean.Commodity_items;
import com.tts.bean.Shopping_Cart;
import com.tts.dao.Shopping_CartDao;
import com.tts.service.Shopping_CartService;
import com.tts.service.impl.Shopping_CartServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class Shopping_cartTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Shopping_CartService shopping_CartService;
	@Autowired
	private Shopping_CartDao shopping_CartDao;
	@org.junit.Test
	public void test(){
//		List<Shopping_Cart> list= shopping_CartService.getCommodity_items(1);
		List<Commodity_items> list= shopping_CartDao.getCommodity_items(1);
		logger.info("test={}",list);
	}

}
