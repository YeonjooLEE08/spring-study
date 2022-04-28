package com.kh.spring.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//로그인하는 사람의 id, pw, 권한 정보가 들어있는 vo
//UserDetails인터페이스를 반드시 구현 
public class SecurityVO implements UserDetails{
	
	private String username;//id
	private String password;//pw
	private List<GrantedAuthority> authorities;
	
	
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(List<GrantedAuthority> authList) {
		//모든 권한 정보를 가질 수 있는 리스트 객체
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(GrantedAuthority authority: authList) {
			authorities.add(new SimpleGrantedAuthority(authority.toString()));
		}
		
		this.authorities = authorities;
	}
	
	
	/////////////////////////////////////////////////
	//이 밑은 UserDetails 인더페이스 정의된 메소드 구현 
	//////////////////////////////////////////////////
	
	

	@Override
	//사용자의 권한 정보를 불러옴
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		return authorities;
	}

	//pw 값 받아오는 메소드
	@Override
	public String getPassword() {
		return password;
	}

	//id 값 받아오는 메소드
	//id, 연락처, 이메일 
	@Override
	public String getUsername() {
		return username;
	}
	
	//계정 만료 여부
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	//계정 잠김 유무
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	//패스워드 만료 여부 
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	@Override
	//계정 활성화 여부 
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
