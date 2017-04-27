//package com.tts.test;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.tts.bean.Commodity;
//import com.tts.bean.Commodity_Combo;
//import com.tts.bean.Commodity_items;
//import com.tts.bean.Commodity_type;
//import com.tts.bean.Discount_coupon;
//import com.tts.bean.Order;
//import com.tts.bean.Shopping_Cart;
//import com.tts.bean.User_Account;
//import com.tts.bean.User_Red_package;
//import com.tts.bean.User_address;
//import com.tts.bean.Users;
//import com.tts.dao.Shopping_CartDao;
//import com.tts.service.Shopping_CartService;
//import com.tts.service.UsersService;
//import com.tts.service.impl.Shopping_CartServiceImpl;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
//public class Shopping_cartTest {
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//	@Autowired
//	private Shopping_CartService shopping_cartService;
//	@Autowired
//	private Shopping_CartDao shopping_CartDao;
//	@Autowired
//	private UsersService usersService;
//
//	@org.junit.Test
//	public void test() {
////		 Shopping_Cart list= shopping_cartService.getShopping_Cart(1);
//		// Set<User_address>list=usersService.getAddressesByUId(1);
////		 Order list= shopping_CartDao.getOrder(17);
//		// List<Commodity> list=shopping_CartDao.getCommodity(1);
//		//		 Order list=shopping_cartService.getOder(1);
////		Shopping_Cart list=	shopping_CartDao.getShopping_CartByscId(1);
//		// HashSet<Commodity_items> list=shopping_CartDao.getCommodity_items(1);
//		// Integer list=shopping_CartDao.addCommodity_items(1,2,3,1,5);
////		User_Account list = shopping_CartDao.getUserAccount(1);
////		Integer list =shopping_CartDao.updateShopping_CartUid(1);
////		User_address list=shopping_CartDao.getUser_address(1);
//		Date now = new Date();
//		// long list=shopping_CartDao.getOid(1, now);
//		Order order = new Order();
//		Shopping_Cart shoppingcart = new Shopping_Cart();
//		shoppingcart.setScId(2);
//		Users users = new Users();
//		users.setUid(2);
//		shoppingcart.setUsers(users);
//		Discount_coupon discountCoupon = new Discount_coupon();
//		discountCoupon.setDcId(2);
//		User_address userAddress = new User_address();
//		userAddress.setUaId(2);
//		User_Red_package userRedPackage = new User_Red_package();
//		userRedPackage.setUrpId(2);
//
//		order.setShoppingCart(shoppingcart);
//		order.setDiscountCoupon(discountCoupon);
//		order.setUserAddress(userAddress);
//		order.setUserRedPackage(userRedPackage);
//		order.setMoney(2000);
//		order.setStatus(2);
//		order.setOid(5);
//		// Integer list=shopping_CartDao.updateOrder(order);
//		// Integer list=shopping_CartDao.addOrder(order);
//		// Order list=order;
//		//logger.info("test={}", list);
//	}
//
//}
