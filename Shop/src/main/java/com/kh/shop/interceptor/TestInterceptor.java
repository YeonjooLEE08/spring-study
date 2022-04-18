package com.kh.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
// /cart/cartList -> 인터셉터 -> 컨트롤러
//HandlerInterceptorAdapter 클래스를 상속받으면
//인터셉터 기능을 사용할 수 있다.
//preHandle() : 컨트롤러의 동작 수행 전에 실행되는 메소드
//postHandle() : 컨트롤러의 동작 이후에 실행되는 메소드
//afterCompletion() : 화면 처리가 다 완료된 후 실행되는 메소드
@Service("testInterceptor")
public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("TestInterceptor -> preHandle() 실행");
		String name = request.getParameter("name");
		return true;//원래 요청 그대로 진행...
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor -> postHandle() 실행");
	}
	
	
	
	
}











