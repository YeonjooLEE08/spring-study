package com.kh.library.member.service;

import com.kh.library.member.vo.MemberVO;

public interface MemberService {
	//----------회원가입---------//
	//아이디 중복 체크
	int checkId (String memId);
	//회원가입
	void joinMember(MemberVO memberVO);
	
	//-----------로그인-------------//
	//로그인
	MemberVO login(MemberVO memberVO);
	//아이디찾기
	String findId(MemberVO memberVO);
}
