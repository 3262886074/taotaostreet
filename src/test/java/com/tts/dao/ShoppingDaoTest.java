package com.tts.dao;

import com.tts.bean.Commodity_items;
import com.tts.bean.Shopping_Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by joe on 17/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ShoppingDaoTest {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShoppingDao shoppingDao;
    @Autowired
    private UsersDao usersDao;

    @Test
    public void queryMaxSCIdByUid() throws Exception {
        Set<Shopping_Cart> shopping_carts = shoppingDao.queryShoppingCartsByUid(1);
        if (!shopping_carts.isEmpty()) {
            Long l = shoppingDao.queryMaxSCIdByUid(1);
            logger.info("最大值={}", l);
            Set<Commodity_items> commodityItems = usersDao.queryItemsByScid(l);
            logger.info("items={}", commodityItems);
        } else {
            Integer integer = shoppingDao.addShopCartByUid(1);
            logger.info("添加购物车={}",integer);
        }
    }

}