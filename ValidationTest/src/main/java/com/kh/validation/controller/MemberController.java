package com.kh.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "join";
	}
	
}
