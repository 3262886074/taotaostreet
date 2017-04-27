package com.tts.controller;

import com.tts.bean.*;
import com.tts.dto.PayExecution;
import com.tts.dto.PayResult;
import com.tts.exception.BalanceNotEnoughException;
import com.tts.exception.UnderStockException;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by joe on 17/4/19.
 */
@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 用户所有信息
     */
    @RequestMapping(value = "/allInfo", method = RequestMethod.GET)
    public String getAllInfo(ModelMap map,
                             HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        Set<Order> orders = usersService.queryOrdersByUid(users.getUid());
        Set<Order> status0 = new HashSet<>();
        Set<Order> status1 = new HashSet<>();
        Set<Order> status2 = new HashSet<>();
        Set<Order> status3 = new HashSet<>();
        for (Order order : orders) {
            if (order.getStatus() == -1) {
                status0.add(order);
            } else if (order.getStatus() == 0) {
                status1.add(order);
            } else if (order.getStatus() == 1) {
                status2.add(order);
            } else if (order.getStatus() == 2) {
                status3.add(order);
            }
        }
        map.put("status0", status0.size());
        map.put("status1", status1.size());
        map.put("status2", status2.size());
        map.put("status3", status3.size());
        //用户其他信息
        Set<User_Collect> userCollects = usersService.queryCollectsByUid(users.getUid());
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
        Users_Authentication users_authentication = usersService.queryAuthenticationByUid(users.getUid());
        User_Safety_Question user_safety_question = usersService.querySafetyQuestionByUid(users.getUid());
        User_Account userAccount = usersService.getAccountMoney(users.getUid());
        users.setOrders(orders);
        users.setUserCollects(userCollects);
        users.setUserRedPackages(userRedPackages);
        users.setDiscountCoupons(discountCoupons);
        users.setUsers_authentication(users_authentication);
        users.setUser_safety_question(user_safety_question);
        users.setUserAccount(userAccount);
        map.put("users", users);
        return "person/index";
    }

    /**
     * 用户信息页面
     */
    @RequestMapping(value = "/userInfo/{uid}", method = RequestMethod.GET)
    public String info(@PathVariable("uid") Long uid,
                       ModelMap map) {
        Users users = usersService.queryUserInfoByUid(uid);
        map.put("users", users);
        return "person/information";
    }

    /**
     * 根据用户id查找用户信息
     */
    @ModelAttribute("users")
    public void getById(@RequestParam(value = "uid", required = false) Long uid,
                        ModelMap map) {
        if (uid != null) {
            Users users = usersService.queryUserInfoByUid(uid);
            map.put("users", users);
        }
    }

    /**
     * 修改用户信息
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.PUT)
    public String updateInfo(@ModelAttribute("users") Users users) {
        boolean b = usersService.updateInfo(users);
        if (b) {
            return "person/index";
        } else {
            return "person/information";
        }
    }

    /**
     * 跳转到账户安全页面
     */
    @RequestMapping(value = "/safety", method = RequestMethod.GET)
    public String userSafety() {
        return "person/safety";
    }

    /**
     * 获取修改密码表单
     */
    @RequestMapping(value = "/pwdInput", method = RequestMethod.GET)
    public String getPwdInput() {
        return "person/password";
    }

    /**
     * 修改密码
     */
    @RequestMapping(value = "/changePwd", method = RequestMethod.PUT)
    public String changePwd(@RequestParam("pwd") String pwd,
                            @RequestParam("uid") Long uid,
                            HttpSession session) {
        boolean b = usersService.updatePwd(pwd, uid);
        if (b) {
            session.removeAttribute("users");
            session.invalidate();
            return "home/login";
        } else {
            return "person/password";
        }
    }

    /**
     * 获取实名认证表单
     */
    @RequestMapping(value = "/realAuthInput", method = RequestMethod.GET)
    public String realAuthInput() {
        return "person/idcard";
    }

    /**
     * 添加实名认证
     */
    @RequestMapping(value = "/addRealAuth", method = RequestMethod.POST)
    public String addRealAuth(@RequestParam("uid") Long uid, @RequestParam("name") String name,
                              @RequestParam("idcard") Long idcard) {
        boolean b = usersService.addAuthentication(uid, name, idcard);
        if (b) {
            return "person/index";
        } else {
            return "redirect:realAuthInput";
        }
    }

    /**
     * 获取安全问题表单
     */
    @RequestMapping(value = "/safetyQeustionInput", method = RequestMethod.GET)
    public String safetyQeustionInput(ModelMap map) {
        map.put("safetyQuestions", new User_Safety_Question());
        return "person/question";
    }

    /**
     * 添加安全问题
     */
    @RequestMapping(value = "/safetyQuestion", method = RequestMethod.POST)
    public String addSafety(User_Safety_Question safetyQuestions) {
        boolean b = usersService.addSafetyQuestion(safetyQuestions);
        if (b) {
            return "person/index";
        } else {
            return "redirect:safetyQeustionInput";
        }
    }

    /**
     * 获取安全问题
     */
    @ModelAttribute("safetyQuestions")
    public void getSafetyQuestion(@RequestParam(value = "uid", required = false) Long uid,
                                  ModelMap map) {
        if (uid != null) {
            User_Safety_Question safetyQuestions = usersService.querySafetyQuestionByUid(uid);
            map.put("safetyQuestions", safetyQuestions);
        }
    }

    /**
     * 更新安全问题
     */
    @RequestMapping(value = "/safetyQuestion", method = RequestMethod.PUT)
    public String updateSafetyQuestion(@ModelAttribute("safetyQuestions") User_Safety_Question safetyQuestions) {
        boolean b = usersService.updateSafetyQuestion(safetyQuestions);
        if (b) {
            return "person/index";
        } else {
            return "redirect:safetyQeustionInput";
        }
    }

    /**
     * 用户地址页面
     */
    @RequestMapping(value = "/getAddress", method = RequestMethod.GET)
    public String getAddress(ModelMap map, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        Set<User_address> userAddresses = usersService.getAddressesByUId(users.getUid());
        map.put("userAddresses", userAddresses);
        return "person/address";
    }

    /**
     * 修改默认地址
     */
    @RequestMapping(value = "/setDefaultAddress", method = RequestMethod.PUT)
    public String setDefaultAddress(@RequestParam("uid") Long uid,
                                    @RequestParam("uaid") Long uaid) {
        boolean b = usersService.updateDefaultAddress(uid, uaid);
        if (b) {
            return "redirect:getAddress";
        }
        return null;
    }

    /**
     * 删除地址(隐藏地址)
     */
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.PUT)
    public String deleteAddress(@RequestParam("uaid") Long uaid, HttpSession session) {
        boolean b = usersService.deleteAddressByUaId(uaid);
        Users users = (Users) session.getAttribute("users");
        Long uid = users.getUid();
        if (b) {
            return "redirect:getAddress";
        } else {
            return "redirect:getAddress";
        }
    }

    /**
     * 添加地址
     */
    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addAddredd(@RequestParam("uaname") String uaname,
                             @RequestParam("uatel") Long uatel,
                             @RequestParam("location") String location,
                             @RequestParam("address") String address,
                             @RequestParam("uid") Long uid) {
        boolean b = usersService.addOneAddress(uaname, uatel, location, address, uid);
        if (b) {
            return "redirect:getAddress";
        } else {
            return "redirect:getAddress";
        }
    }


    /**
     * 订单页面
     */
    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String getOrders(HttpSession session,
                            ModelMap map) {
        Users users = (Users) session.getAttribute("users");
        Set<Order> orders = usersService.queryOrdersByUid(users.getUid());
        //map.put("orders", orders);
        Map<Order, Set<Commodity_items>> commodities = new HashMap<>();
        for (Order order : orders) {
            Set<Commodity_items> commodityItems = usersService.queryItemsByScid(order.getShoppingCart().getScId());
            if (commodityItems.size() > 0 && !commodityItems.isEmpty()) {
                commodities.put(order, commodityItems);
            }
        }
        map.put("orders", commodities);
        return "person/order";
    }

    /**
     * 订单详情 根据订单id查找
     */
    @RequestMapping(value = "/orderInfo/{oid}", method = RequestMethod.GET)
    public String getOrderInfo(@PathVariable("oid") Long oid,
                               ModelMap map) {
        Order order = usersService.queryOrderInfoByOid(oid);
        Set<Commodity_items> commodityItems = usersService.queryItemsByScid(order.getShoppingCart().getScId());
        map.put("order", order);
        map.put("commodityItems", commodityItems);
        return "person/orderinfo";
    }

    ///**
    // * 退货/退款页面
    // */
    //@RequestMapping(value = "/change", method = RequestMethod.GET)
    //public String getChange(HttpSession session,
    //                        ModelMap map){
    //    Users users = (Users) session.getAttribute("users");
    //    Set<Order> orders = usersService.queryOrdersByUid(users.getUid());
    //    //map.put("orders", orders);
    //    Map<Order,Set<Commodity_items>> commodities = new HashMap<>();
    //    for (Order order : orders) {
    //        if (order.getStatus() == 3 || order.getStatus() == 4 || order.getStatus() == 5) {
    //            Set<Commodity_items> commodityItems = usersService.queryItemsByScid(order.getShoppingCart().getScId());
    //            commodities.put(order, commodityItems);
    //        }
    //    }
    //    map.put("orders",commodities);
    //    return "person/change";
    //}

    /**
     * 我的优惠券页面
     */
    @RequestMapping(value = "/allCoupons", method = RequestMethod.GET)
    public String allCoupons(ModelMap map, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
        //可用优惠券
        Set<Discount_coupon> canUse = new HashSet<>();
        //已用优惠券
        Set<Discount_coupon> canNotUse = new HashSet<>();
        for (Discount_coupon discountCoupon : discountCoupons) {
            if (discountCoupon.getStatus() == 0) {
                canUse.add(discountCoupon);
            } else if (discountCoupon.getStatus() == 1) {
                canNotUse.add(discountCoupon);
            }
        }
        map.put("canUse", canUse);
        map.put("canNotUse", canNotUse);
        return "person/coupon";
    }

    /**
     * 我的红包页面
     */
    @RequestMapping(value = "/allRedPackage", method = RequestMethod.GET)
    public String allRedPackage(ModelMap map, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
        //可用红包
        Set<User_Red_package> canUse = new HashSet<>();
        //已使用红包
        Set<User_Red_package> canNotUse = new HashSet<>();
        for (User_Red_package userRedPackage : userRedPackages) {
            if (userRedPackage.getStatus() == 0) {
                canUse.add(userRedPackage);
            } else if (userRedPackage.getStatus() == 1) {
                canNotUse.add(userRedPackage);
            }
        }
        map.put("canUse", canUse);
        map.put("canNotUse", canNotUse);
        return "person/bonus";
    }

    /**
     * 我的收藏
     */
    @RequestMapping(value = "/allCollects", method = RequestMethod.GET)
    public String allCollects(ModelMap map, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        Set<User_Collect> userCollects = usersService.queryCollectsByUid(users.getUid());
        map.put("userCollects", userCollects);
        return "person/collection";
    }

    /**
     * 一键购买
     */
    @ResponseBody
    @RequestMapping(value = "/pay/{oid}", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public PayResult<PayExecution> pay(@PathVariable("oid") long oid,
                                       HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        try {
            PayExecution payExecution = usersService.executePay(oid, users.getUid());
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
     * 购买成功 跳转到成功页面
     */
    @RequestMapping(value = "/paySuccess/{oid}", method = RequestMethod.GET)
    public String paySuccess(@PathVariable("oid") long oid,
                             ModelMap map) {
        Order order = usersService.queryOrderInfoByOid(oid);
        map.put("order", order);
        return "person/success";
    }

    /**
     * 取消订单 修改订单状态为4
     */
    @ResponseBody
    @RequestMapping(value = "/cancelOrder/{oid}", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String cancelOrder(@PathVariable("oid") long oid,
                              HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        String s = usersService.cancelOrder(oid, users.getUid());
        return s;
    }

    /**
     * 确认收货
     */
    @ResponseBody
    @RequestMapping(value = "/confirmOrder/{oid}", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public String confirmOrder(@PathVariable("oid") long oid) {
        String s = usersService.confirmOrder(oid);
        return s;
    }

    /**
     * 评论页面
     */
    @RequestMapping(value = "/commentInput/{oid}", method = RequestMethod.GET)
    public String commentInput(@PathVariable("oid") long oid,
                               ModelMap map) {
        Order order = usersService.queryOrderInfoByOid(oid);
        Set<Commodity_items> commodityItems = usersService.queryItemsByScid(order.getShoppingCart().getScId());
        map.put("commodityItems", commodityItems);
        map.put("order", order);
        return "person/commentlist";
    }

    /**
     * 添加评论
     */
    @ResponseBody
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public String addComment(@RequestParam("cid") long cid,
                             @RequestParam("uid") long uid,
                             @RequestParam("type") Integer type,
                             @RequestParam("content") String content) {
        //1好评 0差评 2中评
        String s = usersService.addComment(content, type, uid, cid);
        //usersService.okOrder(oid);
        return s;
    }

    /**
     * 订单已完成
     */
    @ResponseBody
    @RequestMapping(value = "/okOrder/{oid}", method = RequestMethod.POST)
    public String okOrder(@RequestParam("cid") long cid,
                          @RequestParam("uid") long uid,
                          @RequestParam("type") Integer type,
                          @RequestParam("content") String content,
                          @PathVariable("oid") long oid) {
        //1好评 0差评 2中评
        String s = usersService.addComment(content, type, uid, cid);
        usersService.okOrder(oid);
        return s;
    }


}
