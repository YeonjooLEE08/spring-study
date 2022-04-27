package com.kh.spring.service;

import com.kh.spring.vo.MemberVO;


public interface MemberService {
	
	//회원가입
	void join(MemberVO memberVO);
	
	//로그인
	MemberVO login(MemberVO memberVO);
	
}
