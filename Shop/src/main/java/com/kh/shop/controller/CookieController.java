package com.kh.shop.controller;

import java.net.http.HttpRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
	
	
	@GetMapping("/test1")
	public String test1(HttpServletResponse response) {
		//쿠키 객체 생성
		Cookie cookie = new Cookie("myId", "java");
		cookie.setMaxAge(60 * 5);//초단위
		response.addCookie(cookie);
		
		response.addCookie(new Cookie("myAge", "20"));
		
		return "cookie_test1";
	}

	@GetMapping("/test2")
	public String test2(HttpServletRequest request) {
		Cookie[] cookies =  request.getCookies();
		for(Cookie cookie : cookies) {
			System.out.println(cookie.getName() + " / " +  cookie.getValue());
		}
		
		return "";
	}
	
}













