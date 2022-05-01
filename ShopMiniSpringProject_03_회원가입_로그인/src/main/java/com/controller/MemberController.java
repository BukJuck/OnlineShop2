package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/memberAdd")
	public String memberAdd(MemberDTO m, Model model) {
//		System.out.println(m);
		service.memberAdd(m);
		model.addAttribute("success", "회원가입성공"); //success라는 키로 메시지 띄워줌 //remove 할필요없음
		return "main";	//main.jsp
	}
}
