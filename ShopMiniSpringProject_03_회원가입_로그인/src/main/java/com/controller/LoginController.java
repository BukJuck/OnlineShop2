package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {
	@Autowired
	MemberService service;
	@RequestMapping("/login")
	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session) {
//		System.out.println(map); 하기 전에 찍어보기
		MemberDTO dto =	service.login(map);
//		System.out.println(dto);
		//dto 있는 경우 세션에 저장 후 main으로 이동
		//dto 없는 경우: model에 mesg "아이디/비번이 다름" => loginForm
		if(dto!=null) {
			session.setAttribute("login", dto); //인증정보 저장 후 회원정보전용페이지에서 활용
			session.setMaxInactiveInterval(60*60);
			return "main"; //main.jsp
		}else { //회원이 아닌경우
			model.addAttribute("mesg", "아디/비번 틀림ㅋㅋ");
			return "loginForm"; //loginForm.jsp
		}
		
		
	}
	
	
}
