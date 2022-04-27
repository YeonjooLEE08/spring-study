package com.kh.library.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.library.book.vo.RecommendImgVO;
import com.kh.library.book.vo.RecommendVO;
import com.kh.library.book.vo.ReserveVO;
import com.kh.library.book.vo.BookImgVO;
import com.kh.library.book.vo.BookVO;
import com.kh.library.book.vo.BorrowVO;
import com.kh.library.book.vo.HopeBookApplyVO;
import com.kh.library.book.vo.HopeBookVO;

@Service("bookAdminService")
public class BookAdminServiceImpl implements BookAdminService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	//도서 등록
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBook(BookVO bookVO, BookImgVO bookImgVO) {
		sqlSession.insert("bookMapper.insertBook",bookVO);
		sqlSession.insert("bookMapper.insertBookImg",bookImgVO);
	}
	
	//도서 표지 등록
	@Override
	public void insertBookImg(BookImgVO bookImgVO) {
		sqlSession.insert("bookMapper.insertBookImg",bookImgVO);
	}
	
	//이미지코드숫자
	@Override
	public int selectNextBookImgCode() {
		return sqlSession.selectOne("bookMapper.selectNextImgCode");
	}
	
	//책 코드
	@Override
	public String selectNextBookCode() {
		return sqlSession.selectOne("bookMapper.selectNextBookCode");
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
	
	//예약 추가 
	@Override
	public void insertReserve(ReserveVO reserveVO) {
		sqlSession.insert("bookMapper.insertReserve",reserveVO);
	}
	
	//예약 목록 조회
	@Override
	public List<ReserveVO> selectRsvList(ReserveVO reserveVO) {
		return sqlSession.selectList("bookMapper.selectRsvAdmin",reserveVO);
	}
	
	//도서 대여 insert
	@Override
	public void insertBorrow(ReserveVO reserveVO) {
		sqlSession.insert("bookMapeer.insertBorrow", reserveVO);
		//여기서 예약 어쩌고 걍 삭제해버리기 .. 
		sqlSession.delete("bookMapper.deleteRsvList", reserveVO);
	}
	
	//도서 및 멤버 대여정보 update
	@Override
	public void updateBorrow(BorrowVO borrowVO) {
		sqlSession.update("bookMapper.updateBrCnt", borrowVO);
		sqlSession.insert("bookMapper.updateBrCode", borrowVO);
		
		//reserveVO랑 borrowVO 사용해서 merge into 하기..불가능할듯
		//걍 조건 맞는 거 삭제하기 .. ...
		sqlSession.delete("bookMapper.deleteRsvList", borrowVO);
	}
	
	@Override
	public List<HopeBookVO> selectHopeBookList(){
		return sqlSession.selectList("bookMapper.selectHopeBook");
	}
	
	@Override
	public void insertHopeBookApply(HopeBookApplyVO hopeBookApply) {
		sqlSession.insert("bookMapper.insertHopeBookApply", hopeBookApply);
	}
	
	
	@Override
	public void regRecommend(RecommendVO rcVO, RecommendImgVO rcImgVO) {
		sqlSession.insert("bookMapper.insertRecommend",rcVO);
		sqlSession.insert("bookMapper.insertRecommendImg",rcImgVO);
	}

	

	
	
	
}
