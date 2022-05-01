package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "redirect:../myPage";	//얘도 url에 loginCHeck 남기때문에 이렇게써야함.
	}
	
//	@RequestMapping(value = "/myPage")
//	public String aaa() {
//		return "myPage";
//	} //servlet에서 안하고 여기서 새로 함수 만들어서 해도 되지만 귀찮으니 구냥 servlet에서 처리하자
	
	//
	@RequestMapping(value = "/idDuplicateCheck",produces = "text/plain;charset=UTF-8")	//한글처리
	@ResponseBody
	public String idCheck(@RequestParam("id") String userid){
		int count = service.idCheck(userid);
		System.out.println(count);
		String mesg = "아이디 사용 가능";
		if (count == 1) {
			mesg = "아이디 중복";
		} 
		return mesg;
	}
	
	@RequestMapping("/loginCheck/memberUpdate")
	public String update(MemberDTO m, HttpSession session) {
//		System.out.println(dto);
		service.memberUpdate(m);
		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		String userid = dto.getUserid();
		dto = service.mypage(userid);
//		System.out.println(dto);
		session.setAttribute("login", dto);	//세션에 수정된 정보 읽어와서 다시 저장.
		return "redirect:../myPage";	//다시 myPage로 (servlet-context.xml 주소 요청)
	}
	
	
	
	
	
}
