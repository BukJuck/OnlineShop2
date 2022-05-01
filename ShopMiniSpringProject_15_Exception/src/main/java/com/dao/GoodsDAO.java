package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.OrderDTO;

@Repository
public class GoodsDAO implements GoodsDAO_interface {

	@Autowired
	SqlSessionTemplate template;

	@Override
	public List<GoodsDTO> goodsList(String gCategory) throws Exception{
		return template.selectList("GoodsMapper.goodsList", gCategory);
	}

	@Override
	public GoodsDTO goodsRetrieve(String gCode)throws Exception{
		return template.selectOne("GoodsMapper.goodsRetrieve", gCode);
	}

	@Override
	public void cartAdd(CartDTO cart) throws Exception{
		template.insert("CartMapper.cartAdd", cart);
	}

	@Override
	public List<CartDTO> cartList(String userid)throws Exception {
		return template.selectList("CartMapper.cartList", userid);
	}

	@Override
	public int cartUpdate(HashMap<String, String> map)throws Exception {
		
		return template.update("CartMapper.cartUpdate", map);
	}

	@Override
	public int cartDelete(int num)throws Exception {
		return template.delete("CartMapper.cartDel",num);
	}

	@Override
	public void delAllCart(ArrayList<String> check)throws Exception {
		template.delete("CartMapper.cartAllDel", check);
	}

	@Override
	public CartDTO cartByNum(int num) throws Exception{
		return template.selectOne("CartMapper.cartbyNum", num);
		
	}

	@Override
	public void orderDone(OrderDTO oDTO)throws Exception {
		template.insert("CartMapper.orderDone", oDTO);
	}

	

	
}
