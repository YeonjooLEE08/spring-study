package com.kh.library.admin.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kh.library.book.vo.BookImgVO;
import com.kh.library.book.vo.BookVO;

public class BookAdminServiceImpl implements BookAdminService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBook(BookVO bookVO, BookImgVO bookImgVO) {
		sqlSession.insert("bookMapper.insertBook",bookVO);
		sqlSession.insert("bookMapper.insertBookImages", bookImgVO);
	}
	
	@Override
	public void insertBookImages(BookImgVO bookImgVO) {
		sqlSession.insert("bookMapper.insertBookImages", bookImgVO);
	}
	
	@Override
	public int selectNextImgCode() {
		return sqlSession.selectOne("bookMapper.selectNextImgCode");
	}

	@Override
	public String selectNextBookCode() {
		return sqlSession.selectOne("bookMapper.selectNextBookCode");
	}
	
}
