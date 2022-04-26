package com.kh.library.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.library.book.vo.BookCategoryVO;
import com.kh.library.book.vo.BookVO;
import com.kh.library.book.vo.HopeBookVO;
import com.kh.library.book.vo.RecommendImgVO;
import com.kh.library.book.vo.RecommendVO;
import com.kh.library.book.vo.ReserveVO;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BookCategoryVO> selectBookCategory(){
		return sqlSession.selectList("bookMapper.selectBookCategory");
	}
	
	//책 전체 조회
	@Override
	public List<BookVO> selectBookList() {
		return sqlSession.selectList("bookMapper.selectBookList");
	}
	
	//검색 키워드 조회
	@Override
	public List<BookVO> selectSearchSub(){
		return sqlSession.selectList("bookMapper.selectSearchList()");
	}
	//검색어 저장
	@Override
	public void insertSearch(BookVO bookVO) {
		sqlSession.insert("bookMapper.insertSearch", bookVO);
	}
	//도서 검색결과 조회
	@Override
	public List<BookVO> selectSearchList(BookVO bookVO){
		return sqlSession.selectList("bookMapper.selectSearchList",bookVO);
	}
	//도서 상세보기
	@Override
	public BookVO selectBookDetail(BookVO bookVO) {
		return sqlSession.selectOne("bookMapper.selectBookDetail", bookVO);
	}
	//도서 추천
	@Override
	public void updateRcdCnt(BookVO bookVO) {
		sqlSession.update("bookMapper.updateRcdCnt",bookVO);
	}
	
	//추천도서 랭킹
	@Override
	public List<BookVO> selectRcdBook(){
		return sqlSession.selectList("bookMapper.selectRcdBook");
	}
	
	//신간도서 조회
	@Override
	public List<BookVO> selectNewBook(){
		return sqlSession.selectList("bookMapper.selectNewBook");
	}
	
	
	@Override
	public void insertReserveBook(ReserveVO reserveVO) {
		sqlSession.insert("bookMapper.insertReserveBook", reserveVO);
	}
	
	@Override
	public void insertHopeBook(HopeBookVO hbVO) {
		sqlSession.insert("bookMapper.insertHopeBook", hbVO);
	}
	


}
