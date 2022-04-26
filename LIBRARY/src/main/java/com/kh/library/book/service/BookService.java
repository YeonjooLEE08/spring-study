package com.kh.library.book.service;

import java.util.List;

import com.kh.library.book.vo.BookCategoryVO;
import com.kh.library.book.vo.BookVO;
import com.kh.library.book.vo.HopeBookVO;
import com.kh.library.book.vo.RecommendImgVO;
import com.kh.library.book.vo.RecommendVO;
import com.kh.library.book.vo.ReserveVO;

public interface BookService {
	//카테고리목록조회
	List<BookCategoryVO> selectBookCategory();
	
	//도서 목록 조회
	List<BookVO> selectBookList();
	
	//검색 키워드 조회
	List<BookVO> selectSearchSub();
	
	//검색어 등록 
	void insertSearch(BookVO bookVO);
	
	//도서 검색결과 조회
	List<BookVO> selectSearchList(BookVO bookVO);
	
	//도서 상세 조회
	BookVO selectBookDetail(BookVO bookVO);
	
	//도서 추천 
	void updateRcdCnt(BookVO bookVO);
	
	//추천도서 랭킹 
	List<BookVO> selectRcdBook();
	
	//신간도서 select
	List<BookVO> selectNewBook();
	
	//도서 예약 기능
	void insertReserveBook(ReserveVO reserveVO);
	
	//희망도서 신청 기능
	void insertHopeBook(HopeBookVO hbVO);
	

	
}
