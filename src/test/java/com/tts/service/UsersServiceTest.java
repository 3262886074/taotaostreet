package com.tts.service;

import com.tts.bean.Commodity_items;
import com.tts.bean.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by joe on 17/4/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class UsersServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsersService usersService;

    @Test
    public void queryOrdersByUid() throws Exception {
        Set<Order> orders = usersService.queryOrdersByUid(1);
        logger.info("orders={}",orders);
    }

    @Test
    public void queryItemsByScid() throws Exception {
        Set<Commodity_items> commodityItems = usersService.queryItemsByScid(1);
        logger.info("commodityItems={}",commodityItems);
    }

}