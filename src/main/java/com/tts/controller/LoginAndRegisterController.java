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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by joe on 17/4/21.
 */
@Controller
@RequestMapping(value = "/loginOrRegister")
@SessionAttributes(types = Users.class, value = "users")
public class LoginAndRegisterController {

    @Autowired
    private UsersService usersService;

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
            return "redirect:/";
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
     * 注销
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:loginInput";
        }
        session.removeAttribute("users");
        session.invalidate();
        return "redirect:loginInput";
    }
}
