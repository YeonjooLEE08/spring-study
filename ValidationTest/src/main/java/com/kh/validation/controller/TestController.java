package com.kh.validation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.validation.vo.MemberVO;

//해당 클래스가 컨트로러임을 인지 + 해당 클래스의 객체 생성;
@Controller 
@RequestMapping("/test")
public class TestController {
	@Autowired
	private BCryptPasswordEncoder pwEncoder;
	
	@GetMapping("/insertForm")
	public String insertForm() {
		
		return "insert_form";
	}
	
	@PostMapping("/insert")
	public String insert(MemberVO memberVO) {
		System.out.println("회원을 등록합니다.");
		return "";
	}
	
	//
	//회원가입
	@GetMapping("/securityTest") //pw = oracle
	public String securityTest(MemberVO memberVO) {
		memberVO.setPw("oracle"); 
		
		//비밀번호 암호화
		String encodePw = pwEncoder.encode(memberVO.getPw());
		System.out.println(encodePw);
		
		Boolean aaa = pwEncoder.matches("oracle","암호화된 비번(디비에저장된비번)"); //return타입 boolean 
		System.out.println(aaa);
		
		return "";
	}
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	
}
