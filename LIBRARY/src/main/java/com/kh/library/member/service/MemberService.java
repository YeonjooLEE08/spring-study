package com.kh.library.member.service;

import com.kh.library.club.vo.ClubVO;
import com.kh.library.member.vo.MemberImageVO;
import com.kh.library.member.vo.MemberVO;

public interface MemberService {
	//----------회원가입---------//
	//아이디 중복 체크
	int checkId (String memId);
	//프로필 이미지 코드
	int selectNextMemImgCode();
	//프로필 이미지 넣기
	void insertMemberImage(MemberImageVO imageVO);
	//회원가입
	void joinMember(MemberVO memberVO);
	
	//-----------로그인-------------//
	//로그인
	MemberVO login(String memId);
	//아이디찾기
	String findId(MemberVO memberVO);
	//비밀번호찾기 : 임시 비번 발송 위한 이메일 조회
	String selectEmail(MemberVO memberVO);
	//임시 비밀번호 설정
	void updateTempPwd(MemberVO memberVO);
	
	//----------마이페이지----------//
	//상세 조회
	MemberVO selectMyPageDetail(String memId);
	//정보 수정 - 기본 정보
	void updateBasicInfo(MemberVO memberVO);
				//프로필 이미지 수정
	void updateMemImage(MemberImageVO imageVO);
				//프로필 이미지 수정 x 을 위한 파일명 조회
	String selectMemAtImgName(String memId);
	
	//북클럽 조회
	ClubVO selectMyBookClub(String memId);
}
