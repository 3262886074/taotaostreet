package com.tts.dao;

import com.tts.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * 用户dao测试类 用完即删
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class UsersDaoTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsersDao usersDao;

    @Test
    public void queryUserInfoByUid() throws Exception {
        Users users = usersDao.queryUserInfoByUid(1);
        logger.info("users={}",users);
    }

    @Test
    public void queryOrdersByUid() throws Exception {
        Set<Order> orders = usersDao.queryOrdersByUid(1);
        logger.info("orders={}",orders);
    }

    @Test
    public void queryRedPackageByUid() throws Exception {
        Set<User_Red_package> user_red_packages = usersDao.queryRedPackageByUid(1);
        logger.info("redPackages={}",user_red_packages);
    }

    @Test
    public void queryDiscountCouponByUid() throws Exception {
        Set<Discount_coupon> discount_coupons = usersDao.queryDiscountCouponByUid(1);
        logger.info("discountCoupons={}",discount_coupons);
    }

    @Test
    public void queryCollectsByUid() throws Exception {
        Set<User_Collect> user_collects = usersDao.queryCollectsByUid(1);
        logger.info("userCollects={}",user_collects);
    }

}