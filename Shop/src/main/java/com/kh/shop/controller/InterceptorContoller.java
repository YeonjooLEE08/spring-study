package com.kh.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class InterceptorContoller {
	
	@GetMapping("/test1")
	public String test1() {
		System.out.println("test1() 메소드 실행");
		return "test1";
	}

	@GetMapping("/test2")
	public String test2() {
		System.out.println("test2() 메소드 실행");
		return "test2";
	}

	@GetMapping("/test3")
	public String test3() {
		System.out.println("test3() 메소드 실행");
		return "test3";
	}
	
}












