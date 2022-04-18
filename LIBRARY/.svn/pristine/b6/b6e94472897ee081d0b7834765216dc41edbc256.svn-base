package com.kh.library.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.library.book.vo.BookVO;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BookVO> selectBookList() {
		return sqlSession.selectList("bookMapper.selectBookList");
	}
	
	@Override
	public BookVO selectBookDetail(String bookCode) {
		return sqlSession.selectOne("bookMapper.selectBookDetail", bookCode);
	}

	@Override
	public BookVO insertReserveBook(String bookCode) {
		return null;
	}
	


}
