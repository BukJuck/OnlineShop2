package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	// /loginCheck/** 밑에 들어가는 모든 것은 intercept 처리 할거임.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle 실행===");
		HttpSession session = request.getSession();
		if (session.getAttribute("login")==null) {
			response.sendRedirect("../loginForm");
			// /loginCheck/**  주소 시 /loginCheck가 남아 있게 되어 /loginCheck/loginForm 주소요청이 됨 ../ 이용해서 하나 위로 찾게함
			//servlet-context.xml
			//<mvc:view-controller path="/loginFrom" view-name="loginForm"/><-- loginForm.jsp-->
			return false;
		}else {
			return true;	//회원이라면 계속 진행.
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

	
}
