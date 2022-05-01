package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodsDAO;
import com.dto.CartDTO;
import com.dto.GoodsDTO;

@Service
public class GoodsService {

	@Autowired
	GoodsDAO dao;

	public List<GoodsDTO> goodsList(String gCategory) {
		return dao.goodsList(gCategory);
	}

	public GoodsDTO goodsRetrieve(String gCode) {
		return dao.goodsRetrieve(gCode);
	}

	public void cartAdd(CartDTO cart) {
		dao.cartAdd(cart);
		
	}

	public List<CartDTO> cartList(String userid) {
		return dao.cartList(userid);
	}

	public int cartUpdate(HashMap<String, String> map) {
		return dao.cartUpdate(map);
	}

	public int cartDelete(int num) {
		return dao.cartDelete(num);
	}

	public void delAllCart(ArrayList<String> check) {
		dao.delAllCart(check);
	}

	

	

	
}
