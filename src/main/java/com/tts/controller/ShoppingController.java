package com.tts.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tts.bean.Commodity;
import com.tts.bean.Commodity_Combo;
import com.tts.bean.Commodity_items;
import com.tts.bean.Commodity_pics;
import com.tts.bean.Commodity_type;
import com.tts.bean.Discount_coupon;
import com.tts.bean.Order;
import com.tts.bean.Shopping_Cart;
import com.tts.bean.User_Red_package;
import com.tts.bean.User_address;
import com.tts.bean.Users;
import com.tts.service.Shopping_CartService;
import com.tts.service.UsersService;
import com.tts.service.impl.Shopping_CartServiceImpl;

@Controller("ShoppingController")
@SessionAttributes(value = { "shopping_Carts", "shopping_Cart" }, types = String.class)
@RequestMapping("shop")
public class ShoppingController {

	@Resource(name = "shopping_CartService")
	private Shopping_CartService shopping_CartService;
	@Autowired
	private UsersService usersService;

	// 添加商品到购物车
	@RequestMapping("addShopping_Cart")
	public String addShopping_Cart(@ModelAttribute("commodity") Commodity commodity,
			@ModelAttribute("commodityType") Commodity_type commodityType,
			@ModelAttribute("commodityCombo") Commodity_Combo commodityCombo,
			@ModelAttribute("commodity_items") Commodity_items commodity_items, ModelMap map) {

		// 添加购物车 根据用户id
		Shopping_Cart shopping_Cart = shopping_CartService.addShopping_Cart(1);

		shopping_CartService.addCommodity_items(commodity_items.getNumber(), commodityType.getCt_id(),
				commodityCombo.getCcid(), shopping_Cart.getScId(), commodity.getCid());

		map.put("shopping_Cart", shopping_Cart);
		return "home/shopcart";

	}

	// 显示购物车商品信息
	@RequestMapping("shopping_Cart")
	public String goShopCart(ModelMap map) {
		Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(1);

		map.put("shopping_Cart", shopping_Cart);
		return "home/shopcart";
	}

	// 删除商品到购物车
	@RequestMapping(value="deleteCommodity_items",method={RequestMethod.GET,RequestMethod.POST})
	public String deleteCommodity_items(long ciId, ModelMap map) {

		shopping_CartService.deleteCommodity_items(ciId);
		
		Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(1);

		map.put("shopping_Cart", shopping_Cart);
		return "home/shopcart";

	}
	
	//添加订单 
	@RequestMapping("addOrders")
	public String addOrders(@ModelAttribute("order")Order order,
			ModelMap map) {	
		
				 	Integer od= shopping_CartService.addOrder(order);
				 	
					Order orders = shopping_CartService.getOders(1);//通过OID订单
					long scId = orders.getShoppingcart().getScId();
					long uid = orders.getShoppingcart().getUsers().getUid();
					Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);
					map.put("orders", orders);
					Set<User_address> userAddresses = usersService.getAddressesByUId(uid);
					Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(uid);
					Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(uid);
					map.put("discountCoupons", discountCoupons);
					map.put("userRedPackages", userRedPackages);
					map.put("userAddresses", userAddresses);
					map.put("shopping_Cart", shopping_Cart);
					
		return "home/pay";
	}
	// 显示订单 通过oid订单Id
	@RequestMapping("addOrder")
	public String addOrder(@ModelAttribute("order")Order order,ModelMap map) {
		

		Order orders = shopping_CartService.getOders(1);
		long scId = orders.getShoppingcart().getScId();
		long uid = orders.getShoppingcart().getUsers().getUid();
		Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);
		map.put("orders", orders);

		Set<User_address> userAddresses = usersService.getAddressesByUId(uid);
		Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(uid);
		Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(uid);
		map.put("discountCoupons", discountCoupons);
		map.put("userRedPackages", userRedPackages);
		map.put("userAddresses", userAddresses);
		map.put("shopping_Cart", shopping_Cart);
		return "home/pay";
	}

	// 订单支付 完成交易
	@RequestMapping("pay")
	public String pay(@ModelAttribute("order")Order order,
			ModelMap map) {
		 Integer udo=shopping_CartService.updateOrder(order);
		 
		Order orders = shopping_CartService.getOders(1);
		map.put("orders", orders);
		return "home/success";
	}
}