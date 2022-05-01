package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.GoodsDAO_interface;
import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

@Service
public class GoodsService {

	@Autowired
	GoodsDAO_interface dao;

	public List<GoodsDTO> goodsList(String gCategory) throws Exception{
		return dao.goodsList(gCategory);
	}

	public GoodsDTO goodsRetrieve(String gCode) throws Exception{
		return dao.goodsRetrieve(gCode);
	}

	public void cartAdd(CartDTO cart) throws Exception{
		dao.cartAdd(cart);
		
	}

	public List<CartDTO> cartList(String userid)throws Exception {
		return dao.cartList(userid);
	}

	public int cartUpdate(HashMap<String, String> map) throws Exception{
		return dao.cartUpdate(map);
	}

	public int cartDelete(int num)throws Exception {
		return dao.cartDelete(num);
	}

	public void delAllCart(ArrayList<String> check)throws Exception {
		dao.delAllCart(check);
	}

	public CartDTO cartByNum(int num)throws Exception {
		return dao.cartByNum(num);
		
	}

	@Transactional	//tx처리
	public void orderDone(OrderDTO oDTO, int orderNum)throws Exception {
		dao.orderDone(oDTO);	//주문번호저장
		dao.cartDelete(orderNum);	//카트에서 삭제	root-context.xml에서 tx 처리함 
		//tx-manager 등록필요
	}

	

	

	
}
