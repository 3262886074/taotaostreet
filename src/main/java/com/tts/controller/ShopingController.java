package com.tts.controller;

import java.util.List;

import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.tts.bean.Shopping_Cart;
import com.tts.service.Shopping_CartService;
import com.tts.service.impl.Shopping_CartServiceImpl;


@Controller("ShopingController")
@SessionAttributes(value={"shopping_Carts","shopping_Cart"},types=String.class)
public class ShopingController {
	
	@Resource(name="Shoping_CartService")
	private Shopping_CartService shopping_CartService;
	//注解为控制器指定可以处理哪些 URL 请求
	
		@RequestMapping("listAll")
	private ModelAndView listAll(){
		//作用一 设置转向地址,如下所示（这也是ModelAndView和ModelMap的主要区别） 
		//作用二 用于传递控制方法处理结果数据到结果页面 addObject(String key,Object value); 
		  ModelAndView mv = new ModelAndView("aa/list");
		  shopping_CartService =new Shopping_CartServiceImpl();
		  List<Shopping_Cart> shopping_Carts = shopping_CartService.getAll();
		  mv.addObject("shopping_Carts", shopping_Carts);
		  System.out.println(shopping_Carts.toString());
		  System.out.println(shopping_Carts.size());
		  return mv;
		  }	
		
}