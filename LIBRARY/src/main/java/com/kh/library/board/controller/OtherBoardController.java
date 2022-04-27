package com.kh.library.board.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.library.board.service.FreeBoardService;
import com.kh.library.board.vo.FreeBoardCmtVO;
import com.kh.library.board.vo.FreeBoardVO;
import com.kh.library.member.vo.MemberVO;

@Controller
@RequestMapping("/otherB")
public class OtherBoardController {
	
	@Resource(name = "freeBoardService")
	private FreeBoardService freeBoardService;

	//자유게시판 리스트 조회
	@GetMapping("/freeBoard")
	public String freeBoardList(Model model, String keyword) {
		model.addAttribute("BoardList", freeBoardService.selectFreeBoardList());
		return "board/free_board_list";
	}
	
	//자유게시판 검색
	@PostMapping("/searchFreeBoard")
	public String searchFreeBoard(Model model, FreeBoardVO freeBoardVO) {
		model.addAttribute("BoardList", freeBoardService.searchFreeBoard(freeBoardVO));		
		return "board/free_board_list";
	}
	
	
	//자유게시판 등록 양식 이동
	@GetMapping("/regFreeBoard")
	public String insertFreeBoardForm() {
		return "board/free_board_reg";
	}
	
	//자유게시판 등록
	@PostMapping("/regFreeBoard")
	public String insertFreeBoard(FreeBoardVO freeBoardVO, HttpSession session) {
		String nextBoardNum = freeBoardService.nextFreeBoardNum();
		String memId =((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		freeBoardVO.setMemId(memId);
		String memName =((MemberVO)(session.getAttribute("loginInfo"))).getMemName();
		freeBoardVO.setMemName(memName);
		freeBoardVO.setBoardNum(nextBoardNum);
		freeBoardService.insertFreeBoard(freeBoardVO);
		return "redirect:/otherB/freeBoard";
	}
	
	//자유게시판 상세보기
	@GetMapping("/selectFreeBoardDetail")
	public String selectFreeBoardDetail(String boardNum, Model model) {
		freeBoardService.updateFreeBoardReadCnt(boardNum);
		model.addAttribute("board",freeBoardService.selectFreeBoardDetail(boardNum));
		model.addAttribute("cmtList",freeBoardService.selectFreeBoardCmt(boardNum));
		return "board/free_board_detail";
	}
	
	//자유게시판 수정페이지이동
	@GetMapping("/updateFreeBoard")
	public String updateFreeBoardForm(String boardNum, Model model) {
		freeBoardService.updateFreeBoardReadCnt(boardNum);
		model.addAttribute("board",freeBoardService.selectFreeBoardDetail(boardNum));
		return "board/free_board_update";
	}
	
	//자유게시판 수정
	@PostMapping("/updateFreeBoard")
	public String updateFreeBoard(FreeBoardVO freeBoardVO) {
		freeBoardService.updateFreeBoard(freeBoardVO);
		String boardNum = freeBoardVO.getBoardNum();
		return "redirect:/otherB/selectFreeBoardDetail?boardNum="+boardNum;
	}
	
	//자유게시판 삭제
	@GetMapping("/deleteFreeBoard")
	public String deleteFreeBoard(String boardNum) {
		freeBoardService.deleteFreeBoard(boardNum);
		return "redirect:/otherB/freeBoard";
	}
	
	//자유게시판 댓글작성
	@PostMapping("/regFreeBoardCmt")
	public String regFreeBoardCmt(FreeBoardCmtVO freeBoardCmtVO, HttpSession session) {
		String memId =((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		freeBoardCmtVO.setMemId(memId);
		
		String memName =((MemberVO)(session.getAttribute("loginInfo"))).getMemName();
		freeBoardCmtVO.setMemName(memName);
		
		String memImage =((MemberVO)(session.getAttribute("loginInfo"))).getMemImage();
		freeBoardCmtVO.setMemImage(memImage);
		
		int commentNum = freeBoardService.selectNextFrCmtNum();
		freeBoardCmtVO.setCommentNum(commentNum);
		
		freeBoardService.insertFrBoardCmt(freeBoardCmtVO);
		
		String boardNum = freeBoardCmtVO.getBoardNum();
		return "redirect:/otherB/selectFreeBoardDetail?boardNum="+boardNum;
	}
	
	//자유게시판 댓글 수정
	@PostMapping("/updateFreeCmt")
	public String updateFreeCmt(FreeBoardCmtVO freeBoardCmtVO) {
		String boardNum = freeBoardCmtVO.getBoardNum();
		freeBoardService.updateFreeBoardCmt(freeBoardCmtVO);
		return "redirect:/otherB/selectFreeBoardDetail?boardNum="+boardNum;
	}
	
	//자유게시판 댓글 삭제
	@GetMapping("/deleteFreeCmt")
	public String deleteFreeCmt(FreeBoardCmtVO freeBoardCmtVO) {
		String boardNum = freeBoardCmtVO.getBoardNum();
		freeBoardService.deleteFreeBoardCmt(freeBoardCmtVO.getCommentNum());
		return "redirect:/otherB/selectFreeBoardDetail?boardNum="+boardNum;
	}
	
	
	
	@GetMapping("/qnaBoard")
	public String qnaBoardList() {
		
		return "board/qna_board_list";
	}
}
