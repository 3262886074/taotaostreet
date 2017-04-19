package com.tts.dao;

import com.tts.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
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
        logger.info("users={}", users);
    }

    @Test
    public void queryOrdersByUid() throws Exception {
        Set<Order> orders = usersDao.queryOrdersByUid(1);
        logger.info("orders={}", orders);
    }

    @Test
    public void queryRedPackageByUid() throws Exception {
        Set<User_Red_package> user_red_packages = usersDao.queryRedPackageByUid(1);
        logger.info("redPackages={}", user_red_packages);
    }

    @Test
    public void queryDiscountCouponByUid() throws Exception {
        Set<Discount_coupon> discount_coupons = usersDao.queryDiscountCouponByUid(1);
        logger.info("discountCoupons={}", discount_coupons);
    }

    @Test
    public void queryCollectsByUid() throws Exception {
        Set<User_Collect> user_collects = usersDao.queryCollectsByUid(1);
        logger.info("userCollects={}", user_collects);
    }

    @Test
    public void updateInfo() throws Exception {
        Users users = new Users();
        users.setUid(1);
        users.setBirth(new Date());
        users.setEmail("1827@qq.com");
        users.setNickName("yang1231");
        users.setUtel(14124124);
        Integer i = usersDao.updateInfo(users);
        logger.info("i={}", i);
    }

    @Test
    public void updatePwd() throws Exception {
        String pwd = "asdf";
        Integer i = usersDao.updatePwd(pwd, 1);
        logger.info("i={}", i);
    }

    @Test
    public void addAuthentication() throws Exception {
        Users_Authentication users_authentication = new Users_Authentication();
        users_authentication.setUraName("杨立帅");
        users_authentication.setIdcard(430612367891273918l);
        Users users = new Users();
        users.setUid(1);
        users_authentication.setUsers(users);
        Integer i = usersDao.addAuthentication(users_authentication);
        logger.info("i={}", i);
    }

    @Test
    public void addSafetyQuestion() throws Exception {
        User_Safety_Question user_safety_question = new User_Safety_Question();
        user_safety_question.setQuestionOne("你的小学校名");
        user_safety_question.setAnswerOne("一完小");
        user_safety_question.setQuestionTwo("你的中学校名");
        user_safety_question.setAnswerTwo("镇二中");
        Users users = new Users();
        users.setUid(1);
        user_safety_question.setUsers(users);
        Integer i = usersDao.addSafetyQuestion(user_safety_question);
        logger.info("i={}", i);
    }

    @Test
    public void getAddressesByUId() throws Exception {
        Set<User_address> userAddresses = usersDao.getAddressesByUId(1);
        logger.info("usersAddresses={}", userAddresses);
    }

    @Test
    public void updateUnDefaultAddress() throws Exception {
        //先将用户所有地址设为0
        Integer i = usersDao.updateUnDefaultAddress(1);
        logger.info("i={}", i);

    }

    @Test
    public void updateDefaultAddress() throws Exception {
        //再将某个地址id设置为默认地址
        Integer ii = usersDao.updateDefaultAddress(1);
        logger.info("ii={}", ii);
    }

    @Test
    public void addOneAddress() throws Exception {
        User_address user_address = new User_address();
        user_address.setAddress("长沙");
        user_address.setLocation("长沙民政");
        user_address.setUaname("杨立帅");
        user_address.setUatel(1231241l);
        Integer i = usersDao.addOneAddress(user_address.getUaname(),
                user_address.getUatel(),user_address.getLocation(),
                user_address.getAddress(),1);
        logger.info("i={}", i);
    }

}