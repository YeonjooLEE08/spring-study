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
	//비밀번호찾기 : 임시 비번 발송 위한 이메일 조회
	String selectEmail(MemberVO memberVO);
	//임시 비밀번호 설정
	void updateTempPwd(MemberVO memberVO);
	
	//----------마이페이지----------//
	//상세 조회
	MemberVO selectMyPageDetail(String memId);
}
