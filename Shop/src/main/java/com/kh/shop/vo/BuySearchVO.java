package com.kh.shop.vo;

//구매 목록 조회 시 검색 데이터를 가질 VO
public class BuySearchVO extends PageVO{
	private String searchOrderNum;
	private String searchBuyer;
	private String searchFromDate;
	private String searchToDate;
	
	public String getSearchOrderNum() {
		return searchOrderNum;
	}
	public void setSearchOrderNum(String searchOrderNum) {
		this.searchOrderNum = searchOrderNum;
	}
	public String getSearchBuyer() {
		return searchBuyer;
	}
	public void setSearchBuyer(String searchBuyer) {
		this.searchBuyer = searchBuyer;
	}
	public String getSearchFromDate() {
		return searchFromDate;
	}
	public void setSearchFromDate(String searchFromDate) {
		this.searchFromDate = searchFromDate;
	}
	public String getSearchToDate() {
		return searchToDate;
	}
	public void setSearchToDate(String searchToDate) {
		this.searchToDate = searchToDate;
	}
	
	
}
