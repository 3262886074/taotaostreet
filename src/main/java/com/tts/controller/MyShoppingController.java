package com.tts.controller;

import com.tts.bean.Commodity_items;
import com.tts.bean.Order;
import com.tts.bean.User_address;
import com.tts.bean.Users;
import com.tts.dto.PayExecution;
import com.tts.dto.PayResult;
import com.tts.exception.BalanceNotEnoughException;
import com.tts.exception.UnderStockException;
import com.tts.service.ShoppingService;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by joe on 17/4/27.
 */
@Controller
@RequestMapping("/shopping")
public class MyShoppingController {

    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private UsersService usersService;

    /**
     * 跳转到购物车页面
     * 如果有可用购物车则显示，否则新建一个购物车
     * 支付、显示地址、添加地址、默认地址直接调用userService即可
     */
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    public String getShoppingCart(HttpSession session,
                                  ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        Set<Commodity_items> commodityItems = shoppingService.showItems(users.getUid());
        map.put("commodityItems", commodityItems);
        map.put("itemSize", commodityItems.size());
        double sum = 0;
        for (Commodity_items items : commodityItems) {
            if (items.getCommodity().getForSalePrice() != 0) {
                double money = items.getNumber() * (items.getCommodity().getForSalePrice() +
                        items.getCommodityType().getPrice() + items.getCommodityCombo().getPrice());
                sum += money;
            } else {
                double money = items.getNumber() * (items.getCommodity().getPrice() +
                        items.getCommodityType().getPrice() + items.getCommodityCombo().getPrice());
                sum += money;
            }
        }
        map.put("sum", sum);
        return "home/myShopCart";
    }

    /**
     * 异步 添加商品进购物车
     */
    @ResponseBody
    @RequestMapping(value = "/addShoppingCart", method = RequestMethod.POST)
    public String addShoppingCart(HttpSession session,
                                  @RequestParam("cid") long cid,
                                  @RequestParam("ctid") long ctid,
                                  @RequestParam("ccid") long ccid,
                                  @RequestParam("number") Integer number,
                                  @RequestParam("money") double money,
                                  ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        long scid = shoppingService.getMaxScidByUid(users.getUid());
        String status = shoppingService.addItemsBySCId(cid, ctid, ccid, number, scid);
        return status;
    }

    /**
     * 跳转到结算页面
     * 需要拿到地址、优惠券、红包
     */
    @RequestMapping(value = "/payPage", method = RequestMethod.GET)
    public String payPage(HttpSession session, ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        Set<Commodity_items> commodityItems = shoppingService.showItems(users.getUid());
        map.put("commodityItems", commodityItems);
        map.put("itemSize", commodityItems.size());
        double sum = 0;
        for (Commodity_items items : commodityItems) {
            if (items.getCommodity().getForSalePrice() != 0) {
                double money = items.getNumber() * (items.getCommodity().getForSalePrice() +
                        items.getCommodityType().getPrice() + items.getCommodityCombo().getPrice());
                sum += money;
            } else {
                double money = items.getNumber() * (items.getCommodity().getPrice() +
                        items.getCommodityType().getPrice() + items.getCommodityCombo().getPrice());
                sum += money;
            }
        }
        map.put("sum", sum);
        Set<User_address> userAddresses = usersService.getAddressesByUId(users.getUid());
        map.put("userAddresses", userAddresses);
        for (User_address userAddress : userAddresses) {
            if (userAddress.getStatus() == 1) {
                map.put("defaultAddr", userAddress);
                break;
            }
        }
        //Set<Discount_coupon> discountCoupons = shoppingService.queryDiscountCouponByUid(users.getUid());
        //map.put("discountCoupons", discountCoupons);
        //Set<User_Red_package> userRedPackages = shoppingService.queryRedPackageByUid(users.getUid());
        //map.put("userRedPackages", userRedPackages);
        return "home/myPay";
    }

    /**
     * 结算订单 -- 待付款状态
     */
    @RequestMapping(value = "/waitPay", method = RequestMethod.POST)
    public String waitPay(HttpSession session,
                          @RequestParam("money") double money,
                          @RequestParam("dcid") long dcid,
                          @RequestParam("urpid") long urpid,
                          @RequestParam("uaid") long uaid) {
        Users users = (Users) session.getAttribute("users");
        //创建订单
        long maxScidByUid = shoppingService.getMaxScidByUid(users.getUid());
        String s = shoppingService.addOneOrder(maxScidByUid, money, dcid, urpid, uaid, users.getUid());
        return "redirect:/users/orders";
    }

    /**
     * 结算订单 -- 已付款状态
     */
    @ResponseBody
    @RequestMapping(value = "/checkOut", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public PayResult<PayExecution> checkOutOrder(HttpSession session,
                                                 @RequestParam("money") double money,
                                                 @RequestParam("dcid") long dcid,
                                                 @RequestParam("urpid") long urpid,
                                                 @RequestParam("uaid") long uaid) {
        Users users = (Users) session.getAttribute("users");
        try {
            //创建订单
            long maxScidByUid = shoppingService.getMaxScidByUid(users.getUid());
            String s = shoppingService.addOneOrder(maxScidByUid, money, dcid, urpid, uaid, users.getUid());
            long maxOIdByUid = shoppingService.getMaxOIdByUid(users.getUid());
            PayExecution payExecution = usersService.executePay(maxOIdByUid, users.getUid());
            return new PayResult<>(payExecution, true);
        } catch (BalanceNotEnoughException b) {
            PayExecution payExecution = new PayExecution("余额不足");
            return new PayResult<>(payExecution, true);
        } catch (UnderStockException u) {
            PayExecution payExecution = new PayExecution("库存不足");
            return new PayResult<>(payExecution, true);
        } catch (Exception e) {
            PayExecution payExecution = new PayExecution("内部错误");
            return new PayResult<>(payExecution, true);
        }
    }

    /**
     * 结算订单 -- 支付失败
     */
    @RequestMapping(value = "/failedPay", method = RequestMethod.GET)
    public String failedPay() {
        return "redirect:/users/orders";
    }

    /**
     * 跳转到支付成功页面
     */
    @RequestMapping(value = "/paySuccess", method = RequestMethod.GET)
    public String paySuccess(HttpSession session, ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        long maxOIdByUid = shoppingService.getMaxOIdByUid(users.getUid());
        Order order = usersService.queryOrderInfoByOid(maxOIdByUid);
        map.put("order", order);
        return "person/success";
    }

    /**
     * 一键购买
     * 直接创建购物车但是不给用户看到 然后直接加入订单 给用户看订单即可
     */
    @RequestMapping(value = "/buyNow", method = RequestMethod.POST)
    public String buyNow(HttpSession session,
                         @RequestParam("cid") long cid,
                         @RequestParam("ctid") long ctid,
                         @RequestParam("ccid") long ccid,
                         @RequestParam("number") Integer number,
                         @RequestParam("money") double money,
                         ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        long scid = shoppingService.getMaxScidByUid(users.getUid());
        String status = shoppingService.addItemsBySCId(cid, ctid, ccid, number, scid);
        return "redirect:payPage";
    }


}
