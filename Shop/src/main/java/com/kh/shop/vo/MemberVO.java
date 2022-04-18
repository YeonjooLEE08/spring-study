package com.kh.shop.vo;

public class MemberVO {
	private String memId;
	private String memPw;
	private String memName;
	private String memTell;// 010-555-555
	private String memEmail;
	private String memAddr;
	private String isAdmin;
	private String joinDate;

	// 배열 데이터를 받기 위한 변수
	private String[] memTells;
	private String[] memAddrs;
	

//	public void setMemAddrs(String[] memAddrs) {
//		this.memAddrs = memAddrs;
//	}

//	public void setMemTells(String[] memTells) {
//		this.memTells = memTells;
//	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemTell() {
		return memTell;
	}

	public void setMemTell(String memTell) {
		this.memTell = memTell;
	}
	public void setMemTells(String[] memTells) {
		this.memTell = memTells[0] + "-" +  memTells[1] + "-" + memTells[2];
	}
//	public void setMemTells() {
//		this.memTell = memTells[0] + "-" +  memTells[1] + "-" + memTells[2];
//	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public void setMemAddrs(String[] memAddrs) {
		this.memAddr =memAddrs[0] + "-" + memAddrs[1];
	}
	
//	public void setMemAddr() {
//		this.memAddr = memAddrs[0] + "-" + memAddrs[1] + "-" + memAddrs[2];
//	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPw=" + memPw + ", memName=" + memName + ", memTell=" + memTell
				+ ", memEmail=" + memEmail + ", memAddr=" + memAddr + ", isAdmin=" + isAdmin + ", joinDate=" + joinDate
				+ "]";
	}

}
