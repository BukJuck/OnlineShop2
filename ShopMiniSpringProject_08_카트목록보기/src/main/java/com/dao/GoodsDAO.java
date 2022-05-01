package com.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.CartDTO;
import com.dto.GoodsDTO;

@Repository
public class GoodsDAO {

	@Autowired
	SqlSessionTemplate template;

	public List<GoodsDTO> goodsList(String gCategory) {
		return template.selectList("GoodsMapper.goodsList", gCategory);
	}

	public GoodsDTO goodsRetrieve(String gCode) {
		return template.selectOne("GoodsMapper.goodsRetrieve", gCode);
	}

	public void cartAdd(CartDTO cart) {
		template.insert("CartMapper.cartAdd", cart);
	}

	public List<CartDTO> cartList(String userid) {
		return template.selectList("CartMapper.cartList", userid);
	}

	

	
}
