package com.tts.controller;

import com.tts.bean.*;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
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
    public String getAllInfo() {
        return "person/index";
    }

    /**
     * 用户信息页面
     */
    @RequestMapping(value = "/userInfo/{uid}", method = RequestMethod.GET)
    public String info(@PathVariable("uid") Long uid,
                       ModelMap map) {
        Users users = usersService.queryUserInfoByUid(uid);
        map.put("users",users);
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
        map.put("user_safety_question", new User_Safety_Question());
        return "person/question";
    }

    /**
     * 添加安全问题
     */
    @RequestMapping(value = "/safetyQuestion", method = RequestMethod.POST)
    public String addSafety(User_Safety_Question user_safety_question) {
        boolean b = usersService.addSafetyQuestion(user_safety_question);
        if (b) {
            return "person/index";
        } else {
            return "redirect:safetyQeustionInput";
        }
    }

    /**
     * 获取安全问题
     */
    @ModelAttribute("user_safety_question")
    public void getSafetyQuestion(@RequestParam(value = "uid", required = false) Long uid,
                                  ModelMap map) {
        if (uid != null) {
            User_Safety_Question user_safety_question = usersService.querySafetyQuestionByUid(uid);
            map.put("user_safety_question", user_safety_question);
        }
    }

    /**
     * 更新安全问题
     */
    @RequestMapping(value = "/safetyQuestion", method = RequestMethod.PUT)
    public String updateSafetyQuestion(@ModelAttribute("user_safety_question") User_Safety_Question user_safety_question) {
        boolean b = usersService.updateSafetyQuestion(user_safety_question);
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
    public String getAddress(ModelMap map,HttpSession session) {
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
     * 删除地址
     */
    @RequestMapping(value = "/deleteAddress", method = RequestMethod.DELETE)
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
     * 显示订单页面
     */
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public String getOrders() {
        return "person/order";
    }

    /**
     * 订单管理页面
     * TODO 判断订单的状态 分开传给jsp页面 暂时不做订单相关
     */
    @RequestMapping(value = "/getAllOrders/{uid}", method = RequestMethod.GET)
    public String getAllOrders(@PathVariable("uid") Long uid,
                               ModelMap map) {
        Set<Order> orders = usersService.queryOrdersByUid(uid);
        map.put("orders", orders);
        return "person/order";
    }

    /**
     * 我的优惠券页面
     */
    @RequestMapping(value = "/allCoupons",method = RequestMethod.GET)
    public String allCoupons(ModelMap map,HttpSession session){
        Users users = (Users) session.getAttribute("users");
        Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
        //可用优惠券
        Set<Discount_coupon> canUse = new HashSet<>();
        //已用优惠券
        Set<Discount_coupon> canNotUse = new HashSet<>();
        for (Discount_coupon discountCoupon : discountCoupons) {
            if (discountCoupon.getStatus() == 0) {
                canUse.add(discountCoupon);
            } else if (discountCoupon.getStatus() == 1){
                canNotUse.add(discountCoupon);
            }
        }
        map.put("canUse",canUse);
        map.put("canNotUse",canNotUse);
        return "person/coupon";
    }

    /**
     * 我的红包页面
     */
    @RequestMapping(value = "/allRedPackage",method = RequestMethod.GET)
    public String allRedPackage(ModelMap map,HttpSession session){
        Users users = (Users) session.getAttribute("users");
        Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
        //可用红包
        Set<User_Red_package> canUse = new HashSet<>();
        //已使用红包
        Set<User_Red_package> canNotUse = new HashSet<>();
        for (User_Red_package userRedPackage : userRedPackages) {
            if (userRedPackage.getStatus() == 0){
                canUse.add(userRedPackage);
            } else if (userRedPackage.getStatus() == 1){
                canNotUse.add(userRedPackage);
            }
        }
        map.put("canUse",canUse);
        map.put("canNotUse",canNotUse);
        return "person/bonus";
    }

    /**
     * 我的收藏
     */
    @RequestMapping(value = "/allCollects",method = RequestMethod.GET)
    public String allCollects(ModelMap map,HttpSession session){
        Users users = (Users) session.getAttribute("users");
        Set<User_Collect> userCollects = usersService.queryCollectsByUid(users.getUid());
        map.put("userCollects",userCollects);
        return "person/collection";
    }




}
