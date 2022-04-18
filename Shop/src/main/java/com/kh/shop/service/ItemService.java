package com.kh.shop.service;

import java.util.List;

import com.kh.shop.vo.CategoryVO;
import com.kh.shop.vo.ItemVO;

public interface ItemService {
	//카테고리 목록 조회
	List<CategoryVO> selectCategoryList();
	
	//상품 목록 조회
	List<ItemVO> selectItemList();
	
	//상품 상세정보 조회
	ItemVO selectItemDetail(String itemCode);

}











