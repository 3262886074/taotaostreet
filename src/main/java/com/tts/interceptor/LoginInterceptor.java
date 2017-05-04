package com.tts.interceptor;

import com.tts.bean.Users;
import com.tts.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by joe on 17/4/21.
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private ShoppingService shoppingService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("users") == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/loginOrRegister/loginInput");
            return false;
        } else {
            //判断用户有没有可用购物车 如果没有则新建购物车
            Users users = (Users) session.getAttribute("users");
            shoppingService.addShopCart(users.getUid());
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
