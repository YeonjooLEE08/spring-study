package com.kh.library.book.service;

import java.util.List;

import com.kh.library.book.vo.BookCategoryVO;
import com.kh.library.book.vo.BookVO;

public interface BookService {
	//카테고리목록조회
	List<BookCategoryVO> selectBookCategory();
	
	//도서 목록 조회
	List<BookVO> selectBookList();
	
	//도서 상세 조회
	BookVO selectBookDetail(String bookCode);
	
	//도서 예약 기능
	BookVO insertReserveBook(String bookCode);
	
	//희망도서 신청 기능
	void insertHopeBook(String memId);
}
