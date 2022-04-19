package com.kh.library.admin.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.library.book.vo.ImgVO;
import com.kh.library.book.vo.ReserveVO;
import com.kh.library.book.vo.BookVO;

@Service("bookAdminService")
public class BookAdminServiceImpl implements BookAdminService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBook(BookVO bookVO, ImgVO bookImgVO) {
		sqlSession.insert("bookMapper.insertBook",bookVO);
		sqlSession.insert("bookMapper.insertBookImages", bookImgVO);
	}
	
	@Override
	public void insertBookImages(ImgVO bookImgVO) {
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
	
	@Override
	public void insertReserve(ReserveVO reserveVO) {
		sqlSession.insert("bookMapper.insertReserve",reserveVO);
	}
	
}
