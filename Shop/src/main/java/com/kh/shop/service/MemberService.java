package com.kh.shop.service;

import com.kh.shop.vo.MemberVO;

public interface MemberService {
	//회원가입
	void join(MemberVO memberVO);
	
	//로그인
	MemberVO login(MemberVO memberVO);
	
	String selectMemEmail(MemberVO memberVO);
}









