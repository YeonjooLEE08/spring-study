package com.kh.validation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.validation.vo.MemberVO;

@Controller
@RequestMapping("/test")
public class TestController {

	@GetMapping("/insertForm")
	public String insertForm() {
		
		return "insert_form";
	}
	
	@PostMapping("/insert")
	public String insert(MemberVO memberVO) {
		System.out.println("회원을 등록합니다.");
		return "";
	}
}
