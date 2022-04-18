package com.kh.shop.service;

import java.util.List;

import com.kh.shop.vo.CartVO;
import com.kh.shop.vo.CartViewVO;

public interface CartService {
	//장바구니 상품 등록
	void insertCart(CartVO cartVO);
	
	//장바구니 목록 조회
	List<CartViewVO> selectCartList(String memId);
	
	//장바구니 상품 삭제
	void deleteCart(CartVO cartVO);
	
	//장바구니 상품 수량 변경
	void updateItemCnt(CartVO cartVO);
	
	//장바구니 상품들 삭제
	void deleteCarts(CartVO cartVO);
	
}




















