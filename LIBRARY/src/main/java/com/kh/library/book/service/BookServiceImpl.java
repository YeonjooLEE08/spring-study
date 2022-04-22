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
	
	@Override
	public List<BookVO> selectBookList() {
		return sqlSession.selectList("bookMapper.selectBookList");
	}
	
	@Override
	public BookVO selectBookDetail(BookVO bookVO) {
		return sqlSession.selectOne("bookMapper.selectBookDetail", bookVO);
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
