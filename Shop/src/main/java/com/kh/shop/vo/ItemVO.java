package com.kh.shop.vo;

import java.util.List;

public class ItemVO {
	private String itemCode;
	private String itemName;
	private int itemPrice;
	private String itemDetail;
	private int itemStock;
	private String cateCode;
	private String attachedImgName;
	private List<ImgVO> imgList;
	
	public List<ImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgVO> imgList) {
		this.imgList = imgList;
	}
	public String getAttachedImgName() {
		return attachedImgName;
	}
	public void setAttachedImgName(String attachedImgName) {
		this.attachedImgName = attachedImgName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	public String getCateCode() {
		return cateCode;
	}
	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}
	@Override
	public String toString() {
		return "ItemVO [itemCode=" + itemCode + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemDetail="
				+ itemDetail + ", itemStock=" + itemStock + ", cateCode=" + cateCode + ", attachedImgName="
				+ attachedImgName + ", imgList=" + imgList + "]";
	}
	
	
}










