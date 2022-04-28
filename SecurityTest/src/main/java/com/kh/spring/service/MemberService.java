package com.kh.spring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.kh.spring.vo.MemberVO;

//시큐리티의 로그인 기능을 구현하기 위해서는
//UserDetailsService 인터페이스 안의 로그인 메소드를 구현 
public interface MemberService extends UserDetailsService{
	
	//회원가입
	void join(MemberVO memberVO);
	
	//로그인
	MemberVO login( String memId);
	
	List<String> selectUserRoleList(String memId);
	
}
