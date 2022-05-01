package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@RequestMapping(value = "/loginCheck/myPage")
	public String mypage(HttpSession session) {	//main에서 왔으니 session 에 로그인 정보가 담겨있음.
//		System.out.println("myPage 호출");
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String userid = dto.getUserid();
		dto = service.mypage(userid);
//		System.out.println(dto);
		session.setAttribute("login", dto);
		
		
//		System.out.println(dto);
		return "redirect:../myPage";	//얘도 url에 loginCheck 남기때문에 이렇게써야함.
	}
	
//	@RequestMapping(value = "/myPage")
//	public String aaa() {
//		return "myPage";
//	} //servlet에서 안하고 여기서 새로 함수 만들어서 해도 되지만 귀찮으니 구냥 servlet에서 처리하자
	
	
}
