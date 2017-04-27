package com.tts.controller;

import com.tts.bean.*;
import com.tts.service.Shopping_CartService;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("/shop")
public class ShoppingController {

    @Autowired
    private Shopping_CartService shopping_CartService;
    @Autowired
    private UsersService usersService;

    // 添加商品到购物车
    @RequestMapping(value = "/addShopping_Cart",method = RequestMethod.GET)
    public String addShopping_Cart(Commodity_items commodity_items,
                                   HttpSession session, ModelMap map) {

        Users users = (Users) session.getAttribute("users");
        // 添加购物车 根据用户id
        Shopping_Cart shopping_Carts = shopping_CartService.addShopping_Cart(users.getUid());

        shopping_CartService.addCommodity_items(commodity_items.getNumber(),
                commodity_items.getCommodityType().getCt_id(), commodity_items.getCommodityCombo().getCcid(),
                shopping_Carts.getScId(), commodity_items.getCommodity().getCid());
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(shopping_Carts.getScId());
        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";

    }

    // 显示购物车商品信息
    @RequestMapping(value = "/shopping_Cart",method = RequestMethod.GET)
    public String goShopCart(ModelMap map,HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        Shopping_Cart shopping_Carts = shopping_CartService.addShopping_Cart(users.getUid());
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(shopping_Carts.getScId());

        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";
    }

    // 移入收藏夹
    @RequestMapping(value = "/moveUc/{cid}/{scId}/{ciId}",method = RequestMethod.GET)
    public String addUser_Collect(@PathVariable("cid") long cid,
                                  @PathVariable("scId") long scId,
                                  HttpSession session,
                                  @PathVariable("ciId") long ciId,
                                  ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        shopping_CartService.addUser_Collect(cid, users.getUid());
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(users.getUid());
        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";

    }

    // 删除商品到购物车
    @RequestMapping(value = "/deleteCommodity_items/{ciId}/{scId}",method = RequestMethod.GET)
    public String deleteCommodity_items(@PathVariable("ciId") long ciId,
                                        @PathVariable("scId") long scId,
                                        ModelMap map) {

        shopping_CartService.deleteCommodity_items(ciId);

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);

        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";

    }

    // 修改商品条目商品数量
    @RequestMapping(value = "/updateCommodity_items",method = RequestMethod.GET)
    public void UpdateCommodity_items(Commodity_items commodity_items) {

        shopping_CartService.updateShoppingCart(commodity_items);
    }

    //立即购买
    @RequestMapping("/standpoint")
    public String standpoint(Commodity_items commodity_items, HttpSession session, ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        // 添加购物车 根据用户id
        Shopping_Cart shopping_Carts = shopping_CartService.addShopping_CartSp(users.getUid());

        shopping_CartService.addCommodity_items(commodity_items.getNumber(),
                commodity_items.getCommodityType().getCt_id(), commodity_items.getCommodityCombo().getCcid(),
                shopping_Carts.getScId(), commodity_items.getCommodity().getCid());

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(shopping_Carts.getScId());

        // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        String hehe = dateFormat.format(now);
        // 创建订单
        shopping_CartService.addOrderSp(shopping_Cart.getScId(), users.getUid());
        // 通过uid和当前时间查询当前订单oid
        long oid = shopping_CartService.getOid(users.getUid(), hehe);
        Order orders = shopping_CartService.getOders(oid);
        map.put("orders", orders);

        long scId = orders.getShoppingCart().getScId();

        Shopping_Cart shopping_Carto = shopping_CartService.getShopping_Cart(scId);

        // 修改购物车uid为0代表购物车以加入订单
        shopping_CartService.updateShopping_CartUid(scId);
        Set<User_address> userAddresses = usersService.getAddressesByUId(users.getUid());
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
        map.put("discountCoupons", discountCoupons);
        map.put("userRedPackages", userRedPackages);
        map.put("userAddresses", userAddresses);
        map.put("shopping_Cart", shopping_Carto);

        return "home/pay";

    }

    // 添加订单
    @RequestMapping(value = "/addOrders",method = RequestMethod.POST)
    public String addOrders(Order order, HttpSession session, ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        String hehe = dateFormat.format(now);
        // 创建订单
        shopping_CartService.addOrder(order);
        // 通过uid和当前时间查询当前订单oid
        long oid = shopping_CartService.getOid(users.getUid(), hehe);
        Order orders = shopping_CartService.getOders(oid);
        map.put("orders", orders);

        long scId = orders.getShoppingCart().getScId();

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);

        // 修改购物车uid为0代表购物车以加入订单
        shopping_CartService.updateShopping_CartUid(scId);
        Set<User_address> userAddresses = usersService.getAddressesByUId(users.getUid());
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
        map.put("discountCoupons", discountCoupons);
        map.put("userRedPackages", userRedPackages);
        map.put("userAddresses", userAddresses);
        map.put("shopping_Cart", shopping_Cart);

        return "home/pay";
    }

    // 显示订单 通过oid订单Id
    @RequestMapping(value = "/addOrder",method = RequestMethod.GET)
    public String addOrder(HttpSession session, ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        Order orders = shopping_CartService.getOders(users.getUid());
        long scId = orders.getShoppingCart().getScId();

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);
        map.put("orders", orders);

        Set<User_address> userAddresses = usersService.getAddressesByUId(users.getUid());
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
        map.put("discountCoupons", discountCoupons);
        map.put("userRedPackages", userRedPackages);
        map.put("userAddresses", userAddresses);
        map.put("shopping_Cart", shopping_Cart);
        return "home/pay";
    }

    // 订单支付 完成交易
    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public String pay(Order order, HttpSession session, ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        Integer udo = shopping_CartService.updateOrder(order, users.getUid());
        Order orders = shopping_CartService.getOders(order.getOid());
        map.put("orders", orders);
        return "home/success";
    }
}