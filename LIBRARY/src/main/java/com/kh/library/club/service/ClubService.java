package com.kh.library.club.service;

import java.util.List;

import com.kh.library.club.vo.ClubApplyVO;
import com.kh.library.club.vo.ClubBoardCmtVO;
import com.kh.library.club.vo.ClubBoardVO;
import com.kh.library.club.vo.ClubVO;
import com.kh.library.member.vo.MemberVO;

public interface ClubService {
	
	//모임생성 + 클럽어드민 부여
	void insertUpdateClubCreate(ClubVO clubVO);
	
	//모임조회
	List<ClubVO> selectClubList();
	
	//모임상세조회
	ClubVO selectClubDetail(ClubVO clubVO);
	
	//모임정보수정
	void updateClubDetail(ClubVO clubVO);
	
	//모임게시판 등록
	void insertClubBoard(ClubBoardVO clubBoardVO);
	
	//모임게시글 조회
	List<ClubBoardVO> selectClubBoardList(ClubVO clubVO);
	
	//모임게시글 상세조회
	ClubBoardVO selectClubBoardDetail(ClubBoardVO clubBoardVO);
	
	//모임게시글 수정
	void updateClubBoardDetail(ClubBoardVO clubBoardVO);
	
	//게시글 삭제
	void deleteClubBoard(ClubBoardVO clubBoardVO);

	//클럽어드민 클럽코드 수정
	void updateClubAdminClubCode(ClubVO clubVO);
	
	//댓글등록
	void insertRegBoardCmt(ClubBoardCmtVO clubBoardCmtVO);
	
	//댓글조회
	List<ClubBoardCmtVO> selectCbCmtList(ClubBoardCmtVO clubBoardCmtVO);
	
	//댓글수정
	void updateCbCmt(ClubBoardCmtVO clubBoardCmtVO);
	
	//모입 가입
	void insertClubJoin(ClubApplyVO clubApplyVO);
	
	//모임퇴출
	void clubMemberKick(MemberVO memberVO);
	
}
