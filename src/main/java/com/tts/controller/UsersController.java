package com.tts.controller;

import com.tts.bean.*;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by joe on 17/4/19.
 */
@Controller
@RequestMapping(value = "/users")
@SessionAttributes(types = Users.class, value = "users")
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
     * 获取登录页面
     */
    @RequestMapping(value = "/loginInput", method = RequestMethod.GET)
    public String loginInput() {
        return "home/login";
    }

    /**
     * 用户登录操作
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("nickname") String nickname,
                        @RequestParam("pwd") String pwd,
                        ModelMap map) {
        Users users = usersService.userLogin(nickname, pwd);
        if (users != null) {
            Set<Order> orders = usersService.queryOrdersByUid(users.getUid());
            Set<User_Collect> userCollects = usersService.queryCollectsByUid(users.getUid());
            Set<Discount_coupon> discountCoupons = usersService.queryDiscountCouponByUid(users.getUid());
            Set<User_Red_package> userRedPackages = usersService.queryRedPackageByUid(users.getUid());
            Users_Authentication users_authentication = usersService.queryAuthenticationByUid(users.getUid());
            User_Safety_Question user_safety_question = usersService.querySafetyQuestionByUid(users.getUid());
            users.setOrders(orders);
            users.setUserCollects(userCollects);
            users.setUserRedPackages(userRedPackages);
            users.setDiscountCoupons(discountCoupons);
            users.setUsers_authentication(users_authentication);
            users.setUser_safety_question(user_safety_question);
            map.put("users", users);
            return "person/index";
        } else {
            return "redirect:loginInput";
        }
    }

    /**
     * 获取注册页面
     */
    @RequestMapping(value = "/registerInput", method = RequestMethod.GET)
    public String registerInput() {
        return "home/register";
    }

    /**
     * 用户注册操作
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("nickname") String nickname,
                           @RequestParam("pwd") String pwd) {
        boolean b = usersService.userRegister(nickname, pwd);
        if (b) {
            return "home/login";
        } else {
            return "redirect:registerInput";
        }
    }

    /**
     * 用户信息页面
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String info() {
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
     * 注销
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(HttpSession session) {
        session.removeAttribute("users");
        session.invalidate();
        return "redirect:loginInput";
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
    @RequestMapping(value = "/getAddress/{uid}", method = RequestMethod.GET)
    public String getAddress(@PathVariable("uid") Long uid,
                             ModelMap map) {
        Set<User_address> userAddresses = usersService.getAddressesByUId(uid);
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
            return "redirect:getAddress/" + uid;
        }
        return null;
    }

    /**
     * 删除地址
     */
    @RequestMapping(value = "/deleteAddress",method = RequestMethod.DELETE)
    public String deleteAddress(@RequestParam("uaid") Long uaid,HttpSession session){
        boolean b = usersService.deleteAddressByUaId(uaid);
        Users users = (Users) session.getAttribute("users");
        Long uid = users.getUid();
        if (b){
            return "redirect:getAddress/" + uid;
        } else {
            return "redirect:getAddress/" + uid;
        }
    }

    /**
     * 添加地址
     */
    @RequestMapping(value = "/addAddress",method = RequestMethod.POST)
    public String addAddredd(@RequestParam("uaname")String uaname,
                             @RequestParam("uatel") Long uatel,
                             @RequestParam("location") String location,
                             @RequestParam("address") String address,
                             @RequestParam("uid") Long uid){
        boolean b = usersService.addOneAddress(uaname, uatel, location, address, uid);
        if (b){
            return "redirect:getAddress/" + uid;
        } else {
            return "redirect:getAddress/" + uid;
        }
    }

    /**
     * 订单管理页面
     * TODO 判断订单的状态 分开传给jsp页面
     */
    @RequestMapping(value = "/getAllOrders/{uid}",method = RequestMethod.GET)
    public String getAllOrders(@PathVariable("uid") Long uid,
                               ModelMap map){
        Set<Order> orders = usersService.queryOrdersByUid(uid);
        map.put("orders",orders);
        return "person/order";
    }


}
