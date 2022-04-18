package com.kh.shop.vo;

public class CartVO {
	private int cartNum;
	private String itemCode;
	private String memId;
	private int itemCnt;
	private String createDate;
	private String[] itemCodeArr;
	private CartVO[] buyList;
	
	
	
	public CartVO[] getBuyList() {
		return buyList;
	}
	public void setBuyList(CartVO[] buyList) {
		this.buyList = buyList;
	}
	public String[] getItemCodeArr() {
		return itemCodeArr;
	}
	public void setItemCodeArr(String[] itemCodeArr) {
		this.itemCodeArr = itemCodeArr;
	}
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getItemCnt() {
		return itemCnt;
	}
	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", itemCode=" + itemCode + ", memId=" + memId + ", itemCnt=" + itemCnt
				+ ", createDate=" + createDate + "]";
	}
	
	
	
}







