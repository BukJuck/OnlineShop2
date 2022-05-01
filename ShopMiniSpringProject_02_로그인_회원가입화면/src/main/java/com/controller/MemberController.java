package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dto.MemberDTO;

@Controller
public class MemberController {
	
	@RequestMapping("/memberAdd")
	public String memberAdd(MemberDTO m) {
		System.out.println(m);
		//출력까지만 구현
		return "main";	//main.jsp
	}
}
