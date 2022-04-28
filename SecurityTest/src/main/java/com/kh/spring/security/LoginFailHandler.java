package com.kh.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

//로그인 실패 시 진행되는 로직 구성하기 위한 클래스 
//AuthenticationFailureHandler 인터페이스를 구현하는 클래스는
//로그인 실패 시 로직 구성을 진행할 수 있다
@Component
public class LoginFailHandler implements AuthenticationFailureHandler {

	@Override
	//로그인 실패 시 자동으로 실행되는 메소드
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
			
		System.out.println("onAuthenticationFailure");
	}
	
}
