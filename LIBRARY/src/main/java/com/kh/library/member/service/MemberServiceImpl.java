package com.kh.library.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.library.member.vo.MemberImageVO;
import com.kh.library.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//-----------------회원가입-------------//
	//아이디 중복 체크
	@Override
	public int checkId(String memId) {
		int cnt = sqlSession.selectOne("memberMapper.checkId", memId);
		return cnt;
	}
	
	//MEM_IMG_CODE 설정
	@Override
	public int selectNextMemImgCode() {
		return sqlSession.selectOne("memberMapper.selectNextMemImgCode");
	}
	
	//프로필 사진 넣기
	@Override
	public void insertMemberImage(MemberImageVO imageVO) {
		sqlSession.insert("memberMapper.insertMemberImage", imageVO);
	}
	
	//회원가입
	@Override
	public void joinMember(MemberVO memberVO) {
		sqlSession.insert("memberMapper.join", memberVO);
	}
	
	//-----------------로그인-------------//
	//로그인
	@Override
	public MemberVO login(String memId) {
		return sqlSession.selectOne("memberMapper.login", memId);
	}
	//아이디 찾기
	@Override
	public String findId(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.findId", memberVO);
	}
	// 비밀번호찾기 : 임시 비번 발송 위한 이메일 조회
	@Override
	public String selectEmail(MemberVO memberVO) {
		return sqlSession.selectOne("memberMapper.selectEmail", memberVO);
	}
	// 임시 비밀번호로 정보 수정
	@Override
	public void updateTempPwd(MemberVO memberVO) {
		sqlSession.update("memberMapper.updateTempPwd", memberVO);
	}

	//내 정보 상세조회
	@Override
	public MemberVO selectMyPageDetail(String memId) {
		return sqlSession.selectOne("memberMapper.selectMyPageDetail", memId);
	}
	//정보 수정 - 기본 정보, 프로필 수정
	@Override
	public void updateBasicInfo(MemberVO memberVO) {
		sqlSession.update("memberMapper.updateBasicInfo", memberVO);
	}
	
	@Override
	public void updateMemImage(MemberImageVO imageVO) {
		sqlSession.update("memberMapper.updateMemImage", imageVO);
		
	}

	@Override
	public String selectMemAtImgName(String memId) {
		return sqlSession.selectOne("memberMapper.selectMemAtImgName", memId);
	}

	

}
