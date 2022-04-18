package com.kh.library.book.vo;

import java.util.List;

public class ImgVO {
	private String bkImgCode;
	private String bkOriginName;
	private String bkAtImagName;
	private String isMain;
	private String bookCode;
	private List<ImgVO> imgList;
	
	public String getBkImgCode() {
		return bkImgCode;
	}
	public void setBkImgCode(String bkImgCode) {
		this.bkImgCode = bkImgCode;
	}
	public String getBkOriginName() {
		return bkOriginName;
	}
	public void setBkOriginName(String bkOriginName) {
		this.bkOriginName = bkOriginName;
	}
	public String getBkAtImagName() {
		return bkAtImagName;
	}
	public void setBkAtImagName(String bkAtImagName) {
		this.bkAtImagName = bkAtImagName;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public List<ImgVO> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgVO> imgList) {
		this.imgList = imgList;
	}
}
