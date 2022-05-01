package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

public interface GoodsDAO_interface {

	List<GoodsDTO> goodsList(String gCategory) throws Exception;

	GoodsDTO goodsRetrieve(String gCode) throws Exception;

	void cartAdd(CartDTO cart) throws Exception;

	List<CartDTO> cartList(String userid) throws Exception;

	int cartUpdate(HashMap<String, String> map) throws Exception;

	int cartDelete(int num) throws Exception;

	void delAllCart(ArrayList<String> check) throws Exception;

	CartDTO cartByNum(int num) throws Exception;

	void orderDone(OrderDTO oDTO) throws Exception;

}