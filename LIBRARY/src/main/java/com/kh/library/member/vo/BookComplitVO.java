package com.kh.library.member.vo;

public class BookComplitVO {
	private String complitCode;
	private String complitDate;
	private String bookCode;
	private String memId;
	
	private String title;
	private String writer;
	private int bkPage;
	
	
	
	
	public int getBkPage() {
		return bkPage;
	}
	public void setBkPage(int bkPage) {
		this.bkPage = bkPage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getComplitCode() {
		return complitCode;
	}
	public void setComplitCode(String complitCode) {
		this.complitCode = complitCode;
	}
	public String getComplitDate() {
		return complitDate;
	}
	public void setComplitDate(String complitDate) {
		this.complitDate = complitDate;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	
}
