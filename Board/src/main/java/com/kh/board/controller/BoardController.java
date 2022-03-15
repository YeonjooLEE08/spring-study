package com.kh.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller 어노테이션의 역할
//1.해당 클래스를 controller로 인식
@Controller
//@RequestMapping("/board")
//-요청 경로가 /board로 시작하면 BoardController 실행 
@RequestMapping("/board")
public class BoardController {
	//게시글목록페이지이동
	@GetMapping("/boardList")
	public String boardList() {
		return "board_list"; // /WEB-INF/views/index.jsp
	}
} 
