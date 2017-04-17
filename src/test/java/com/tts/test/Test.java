package com.tts.test;

import com.tts.dao.TestDao;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class Test {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TestDao testDao;
	
	@org.junit.Test
	public void test(){
		logger.info("test={}","hello World");
	}

}
