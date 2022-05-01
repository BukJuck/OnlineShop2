package com.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

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
			return "redirect:/goodsList?gCategory=top"; //로그인 되면 goodsList가 띄워지는 
		}else { //회원이 아닌경우
			model.addAttribute("mesg", "아디/비번 틀림ㅋㅋ");
			return "loginForm"; //loginForm.jsp
		}
		
		
	}
	
	@RequestMapping(value = "/loginCheck/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		//return "../"; //.xml에 설정 main.jsp
		return "redirect:../";	//.xml에 설정 main.jsp ../을 이용하여 /loginCheck의 상위 주소로 이동하여 사용함.
		//회원 전용 페이지는 servelt-context.xml 에 주소 등록 후 이용(/)
		//return "main";	//main.jsp
		//return "../main";
	}
	
	
	
	
	
	
}
