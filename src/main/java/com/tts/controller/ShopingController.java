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
import com.tts.service.Shoping_CartService;


@Controller("ShopingController")
@SessionAttributes(value={"shopping_Carts","shopping_Cart"},types=String.class)
public class ShopingController {
	@Resource(name="Shopping_CartService")
	private Shoping_CartService shopping_CartService;
	//注解为控制器指定可以处理哪些 URL 请求
	
		@RequestMapping("listAll")
	private ModelAndView listAll(){
		//作用一 设置转向地址,如下所示（这也是ModelAndView和ModelMap的主要区别） 
		//作用二 用于传递控制方法处理结果数据到结果页面 addObject(String key,Object value); 
		  ModelAndView mv = new ModelAndView("aa/list");
		  List<Shopping_Cart> shopping_Carts = Shoping_CartService.getAll();
		  mv.addObject("shopping_Carts", shopping_Carts);
		  System.out.println(shopping_Carts.size());
		  return mv;
		  }	
		@RequestMapping("query")
		public String query(@RequestParam(value="scId",required=false)String scId){
			Shoping_CartCondition con = new Shoping_CartCondition();
			con.setScId(scId);
			List<Shopping_Cart> shoping_Carts = Shoping_CartService.selectByCondition(con);	

			//ModelMap对象主要用于传递控制方法处理数据到结果页面，
			//也就是说我们把结果页面上需要的数据放到ModelMap对象中即可，
			//他的作用类似于request对象的setAttribute方法的作用，用来在一个请求过程中传递处理的数据。
//			modelMap.put("shoping_Carts", shoping_Carts);
			return "aa/list";
		
}
}