package com.kh.library.book.vo;

import java.util.List;

public class BookVO {
	private String bookCode;
	private String title;
	private String writer;
	private String keyword;
	private String publisher;
	private String cateCode;
	private String inputDate;
	private String pubDate;//yyyy
	private int reserveCnt;
	private int bookStock;
	private String status;
	private String bkImg;
	
	//검색 기능
	private String searchCode;
	private String searchSub;
	private String searchTxt;
	
	

	public String getSearchCode() {
		return searchCode;
	}
	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}
	public String getSearchSub() {
		return searchSub;
	}
	public void setSearchSub(String searchSub) {
		this.searchSub = searchSub;
	}
	public String getSearchTxt() {
		return searchTxt;
	}
	public void setSearchTxt(String searchTxt) {
		this.searchTxt = searchTxt;
	}
	public String getBkImg() {
		return bkImg;
	}
	public void setBkImg(String bkImg) {
		this.bkImg = bkImg;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	public int getReserveCnt() {
		return reserveCnt;
	}
	public void setReserveCnt(int reserveCnt) {
		this.reserveCnt = reserveCnt;
	}
	public int getBookStock() {
		return bookStock;
	}
	public void setBookStock(int bookStock) {
		this.bookStock = bookStock;
	}


	
	
	
}
