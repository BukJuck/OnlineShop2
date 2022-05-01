package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dto.GoodsDTO;
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
}
