package com.tts.controller;

import com.tts.bean.Users;
import com.tts.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
     * 修改用户信息
     */
    @RequestMapping(value = "/updateInfo",method = RequestMethod.PUT)
    public String updateInfo(Users users) {
        boolean b = usersService.updateInfo(users);
        if (b) {
            return "person/index";
        } else {
            return "person/information";
        }
    }

    /**
     * 安全设置
     */

}
