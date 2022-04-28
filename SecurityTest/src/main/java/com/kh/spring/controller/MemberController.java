package com.kh.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.service.MemberService;
import com.kh.spring.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name="memberService")
	private MemberService memberService;
	
	//시작페이지
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	//회원가입페이지
	@GetMapping("/joinForm")
	public String joinForm() {
		return "join";
	}
	
	//회원가입
	@PostMapping("/join")
	public String join(MemberVO memberVO) {
		
		memberService.join(memberVO);
		return "redirect:/member/main";
	}
	
	//로그인페이지
	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
	
//	//로그인
//	@PostMapping("/login")
//	public String login(MemberVO memberVO, HttpSession session) {
//		
//		MemberVO loginInfo = memberService.login(memberVO);
//		
//		if(loginInfo != null) {
//			session.setAttribute("loginInfo", loginInfo);
//			
//		}
//		return "redirect:/member/main";
//	}
	
	@GetMapping("/board")
	public String board() {
		return "board";
	}
	
	@RequestMapping("/loginError")
	public String loginError() {
		return "login_errer";
	}
}
