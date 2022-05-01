package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

//@Repository
public class GoodsDAO_mySQL_impl implements GoodsDAO_interface{
	//SqlTemplate <=xml주입
	@Override
	public List<GoodsDTO> goodsList(String gCategory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GoodsDTO goodsRetrieve(String gCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cartAdd(CartDTO cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CartDTO> cartList(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cartUpdate(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cartDelete(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delAllCart(ArrayList<String> check) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartDTO cartByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderDone(OrderDTO oDTO) {
		// TODO Auto-generated method stub
		
	}

}
