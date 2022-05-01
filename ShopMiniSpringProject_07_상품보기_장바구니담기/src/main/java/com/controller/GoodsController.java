package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.dto.GoodsDTO;
import com.dto.MemberDTO;
import com.service.GoodsService;

@Controller
public class GoodsController {
	@Autowired
	GoodsService Service;
	
	@RequestMapping(value = "/goodsList")
	public ModelAndView goodsList(@RequestParam("gCategory") String gCategory) {
		
		if (gCategory == null) {
			gCategory="top";
		}
		List<GoodsDTO> list = Service.goodsList(gCategory);
		
		ModelAndView mav = new ModelAndView();	//mav는 새로운 객체 생성하고 써야함. **주의**
		mav.addObject("goodsList", list);	//request.setAtt와 동일
		mav.setViewName("main");	//main.jsp
		return mav;
	}
	
	@RequestMapping("/goodsRetrieve")	//요청주소: goodsRetrieve.jsp (유추)
	@ModelAttribute("goodsRetrieve")	//key 값 설정
	public GoodsDTO goodsRetrieve(@RequestParam("gCode") String gCode) {
//		System.out.println(gCode);
		GoodsDTO dto = Service.goodsRetrieve(gCode);
//		System.out.println(dto);
		return dto;
	}
	
	@RequestMapping("/loginCheck/cartAdd")
	public String cartAdd(CartDTO cart, HttpSession session) {
		MemberDTO mDTO = (MemberDTO)session.getAttribute("login");
		cart.setUserid(mDTO.getUserid());
		session.setAttribute("mesg", cart.getgCode());
//		String userid = (String) session.getAttribute("login");
//		dto = Service.cartAdd(userid);
		Service.cartAdd(cart);
		
		return "redirect:../goodsRetrieve?gCode="+cart.getgCode();
	}
	
	
}
