package com.kh.spring.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.kh.spring.service.MemberService;

//스프링 시큐리티의 설정을 위해
// WebSecurityConfigurerAdapter을 상속받아서
// 해당 클래스에 있는 설정 관련 메소드를 오버라이딩한다.

@Configuration //객체 생성 어노테이션
@EnableWebSecurity //스프링 시큐리티 기능 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Autowired
	private AuthenticationFailureHandler failHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService);
		
	
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	}

	@Override
	//인증과 관련된 설정
	protected void configure(HttpSecurity http) throws Exception {
		
		//보안 
		http.csrf().disable(); 
		
		http.authorizeRequests() //요청에 대한 인증 설정 시작
			.antMatchers("/"
						, "/WEB-INF/views/index.jsp"
						, "/member/main"
						, "/member/joinForm"
						, "/member/join").permitAll() //"/" 요청은 인증 받지 않아도 접근 가능
		.antMatchers("/member/board").hasRole("USER") //"member/board"는 사용자 권한이 있어야 접근 가능
			.anyRequest().authenticated(); //나머지 요청에 대해서는 인증을 받아야 사용 가능
		
		//로그인 관련 설정
		http.formLogin()
			.loginPage("/member/loginForm")
			.loginProcessingUrl("/member/login")
			.failureHandler(failHandler)
			.defaultSuccessUrl("/member/main").permitAll();
	}
	
	
	
}
