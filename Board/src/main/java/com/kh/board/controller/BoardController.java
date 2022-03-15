package com.kh.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller ������̼��� ����
//1.�ش� Ŭ������ controller�� �ν�
@Controller
//@RequestMapping("/board")
//-��û ��ΰ� /board�� �����ϸ� BoardController ���� 
@RequestMapping("/board")
public class BoardController {
	//�Խñ۸���������̵�
	@GetMapping("/boardList")
	public String boardList() {
		return "board_list"; // /WEB-INF/views/index.jsp
	}
} 
