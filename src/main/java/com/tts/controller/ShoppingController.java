package com.tts.controller;

import com.tts.bean.*;
import com.tts.service.Shopping_CartService;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Controller("ShoppingController")
@SessionAttributes(value = {"shopping_Carts", "shopping_Cart"}, types = String.class)
@RequestMapping("users")
public class ShoppingController {

    @Resource(name = "shopping_CartService")
    private Shopping_CartService shopping_CartService;
    @Autowired
    private UsersService usersService;

    // 添加商品到购物车
    @RequestMapping("addShopping_Cart")
    public String addShopping_Cart(Commodity_items commodity_items, long uid, ModelMap map) {

        // 添加购物车 根据用户id
        Shopping_Cart shopping_Carts = shopping_CartService.addShopping_Cart(1);

        shopping_CartService.addCommodity_items(commodity_items.getNumber(),
                commodity_items.getCommodityType().getCt_id(), commodity_items.getCommodityCombo().getCcid(),
                shopping_Carts.getScId(), commodity_items.getCommodity().getCid());
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(shopping_Carts.getScId());
        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";

    }

    // 显示购物车商品信息
    @RequestMapping("shopping_Cart")
    public String goShopCart(ModelMap map) {
        Shopping_Cart shopping_Carts = shopping_CartService.addShopping_Cart(1);
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(shopping_Carts.getScId());

        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";
    }

    // 移入收藏夹
    @RequestMapping("moveUc")
    public String addUser_Collect(long cid, long scId, long uid, long ciId, ModelMap map) {

        shopping_CartService.addUser_Collect(cid, uid);
        shopping_CartService.deleteCommodity_items(ciId);
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(1);

        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";

    }

    // 删除商品到购物车
    @RequestMapping("deleteCommodity_items")
    public String deleteCommodity_items(long ciId, long scId, ModelMap map) {

        shopping_CartService.deleteCommodity_items(ciId);

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);

        map.put("shopping_Cart", shopping_Cart);
        return "home/shopcart";

    }

    // 修改商品条目商品数量
    @RequestMapping("UpdateCommodity_items")
    public void UpdateCommodity_items(Commodity_items commodity_items) {

        shopping_CartService.updateShoppingCart(commodity_items);
    }

    //立即购买
    @RequestMapping("standpoint")
    public String standpoint(Commodity_items commodity_items, long uid, ModelMap map) {

        // 添加购物车 根据用户id
        Shopping_Cart shopping_Carts = shopping_CartService.addShopping_CartSp(uid);

        shopping_CartService.addCommodity_items(commodity_items.getNumber(),
                commodity_items.getCommodityType().getCt_id(), commodity_items.getCommodityCombo().getCcid(),
                shopping_Carts.getScId(), commodity_items.getCommodity().getCid());

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(shopping_Carts.getScId());

        // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        String hehe = dateFormat.format(now);
        // 创建订单
        shopping_CartService.addOrderSp(shopping_Cart.getScId(), uid);
        // 通过uid和当前时间查询当前订单oid
        long oid = shopping_CartService.getOid(uid, hehe);
        Order orders = shopping_CartService.getOders(oid);
        map.put("orders", orders);

        long scId = orders.getShoppingCart().getScId();

        map.put("uid", uid);
        Shopping_Cart shopping_Carto = shopping_CartService.getShopping_Cart(scId);

        // 修改购物车uid为0代表购物车以加入订单
        shopping_CartService.updateShopping_CartUid(scId);
        Set<User_address> userAddresses = usersService.getAddressesByUId(uid);
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(uid);
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(uid);
        map.put("discountCoupons", discountCoupons);
        map.put("userRedPackages", userRedPackages);
        map.put("userAddresses", userAddresses);
        map.put("shopping_Cart", shopping_Carto);

        return "home/pay";

    }

    // 添加订单
    @RequestMapping("addOrders")
    public String addOrders(Order order, long uid, ModelMap map) {
        // 获取当前时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date now = new Date();
        String hehe = dateFormat.format(now);
        // 创建订单
        shopping_CartService.addOrder(order);
        // 通过uid和当前时间查询当前订单oid
        long oid = shopping_CartService.getOid(uid, hehe);
        Order orders = shopping_CartService.getOders(oid);
        map.put("orders", orders);

        long scId = orders.getShoppingCart().getScId();

        map.put("uid", uid);
        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);

        // 修改购物车uid为0代表购物车以加入订单
        shopping_CartService.updateShopping_CartUid(scId);
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
    public String addOrder(@ModelAttribute("order") Order order, long uid, ModelMap map) {

        Order orders = shopping_CartService.getOders(1);
        long scId = orders.getShoppingCart().getScId();

        Shopping_Cart shopping_Cart = shopping_CartService.getShopping_Cart(scId);
        map.put("orders", orders);

        Set<User_address> userAddresses = usersService.getAddressesByUId(uid);
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(uid);
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(uid);
        map.put("uid", uid);
        map.put("discountCoupons", discountCoupons);
        map.put("userRedPackages", userRedPackages);
        map.put("userAddresses", userAddresses);
        map.put("shopping_Cart", shopping_Cart);
        return "home/pay";
    }

    // 订单支付 完成交易
    @RequestMapping("pay")
    public String pay(Order order, long uid, ModelMap map) {

        Integer udo = shopping_CartService.updateOrder(order, uid);
        Order orders = shopping_CartService.getOders(order.getOid());
        map.put("orders", orders);
        return "home/success";
    }
}