package com.kh.shop.vo;

import java.util.List;

public class ImgVO {
	private int imgCode;
	private String originImgName;
	private String attachedImgName;
	private String isMain;
	private String itemCode;
	private List<ImgVO> imgList;
	
	public List<ImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgVO> imgList) {
		this.imgList = imgList;
	}
	public int getImgCode() {
		return imgCode;
	}
	public void setImgCode(int imgCode) {
		this.imgCode = imgCode;
	}
	public String getOriginImgName() {
		return originImgName;
	}
	public void setOriginImgName(String originImgName) {
		this.originImgName = originImgName;
	}
	public String getAttachedImgName() {
		return attachedImgName;
	}
	public void setAttachedImgName(String attachedImgName) {
		this.attachedImgName = attachedImgName;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	@Override
	public String toString() {
		return "ImgVO [imgCode=" + imgCode + ", originImgName=" + originImgName + ", attachedImgName=" + attachedImgName
				+ ", isMain=" + isMain + ", itemCode=" + itemCode + ", imgList=" + imgList + "]";
	}
	
	
}







