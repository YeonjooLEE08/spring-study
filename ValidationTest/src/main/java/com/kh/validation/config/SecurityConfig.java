package com.kh.validation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// 해당 클래스가 설정 파일임을 인지시킴 +  객체 생성
//security 설정을 위해서는 WebSecurityConfigurerAdapter
//안에 정의된 메소드를 오버라이딩 해야 한다.
@Configuration
//설정 파일 활성화 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		//해당 url의 자원 접근은 인증을 무시한다.
		web.ignoring().antMatchers("/resources/**");
		
	}

	@Override
	//인증 처리 메소드 
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() //요청 url에 따른 인증 처리 설정
			.antMatchers("/"
						,"/WEB-INF/views/index.jsp"
						,"/test/main").permitAll() // 요청 경로가 "/"면 인증 없이 모두 접근 가능
			.antMatchers("/admin/*").hasRole("ADMIN") 
			.anyRequest().authenticated(); // 그 밖의 요청은 인증이 되어야만 접근 가능 
		
		http.formLogin() //시큐리티 로그인 기능 정의 시작
			.loginPage("/member/loginForm")	//로그인 폼 url 작성 
			.loginProcessingUrl("/member/login") //실제 로그인을 처리하는 url
			.failureForwardUrl("/member/loginError") //로그인 실패 시 이동할 url
			.defaultSuccessUrl("/") //로그인 성공 시 기본 url , 초기화면 
			.permitAll(); //위에서 작성한 url은 아무나 접근 가능함
	}
	
	//인증이 안 되면 바로 loginForm 페이지로 이동
	//도서 예약 시 바로 loginForm으로 이동하는 기능 넣어도 될 듯 
	
	
}
