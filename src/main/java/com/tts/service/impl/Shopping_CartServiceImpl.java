package com.tts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tts.bean.Shopping_Cart;
import com.tts.dao.Shopping_CartDao;
import com.tts.service.Shopping_CartService;

@Service("shopping_CartService")
public class Shopping_CartServiceImpl implements Shopping_CartService {

	@Autowired
	private Shopping_CartDao shopping_CartDao;

	@Override
	public List<Shopping_Cart> getAll() {
		List<Shopping_Cart> list = shopping_CartDao.getAll();
		System.out.println(list.toString());
		return list;
	}

}
