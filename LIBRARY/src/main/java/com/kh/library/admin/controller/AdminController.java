package com.kh.library.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.library.admin.service.ItemAdminService;
import com.kh.library.admin.service.MemberAdminService;
import com.kh.library.admin.vo.MessageVO;
import com.kh.library.book.service.BookService;
import com.kh.library.book.vo.ReserveVO;
import com.kh.library.book.vo.BookImgVO;
import com.kh.library.book.vo.BookVO;
import com.kh.library.item.service.ItemService;
import com.kh.library.member.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	  
	   
		
	@Resource(name = "itemAdminService") 
	private ItemAdminService itemAdminService;
		  
	@Resource(name = "itemService") 
	private ItemService itemService;
	
	@Resource(name = "memberAdminService") 
	private MemberAdminService memberAdminService;
	
	@Resource(name="bookService")
	private BookService bookService;
	
		 
	@GetMapping("/test") 
	public String test() { 
		 return "manage/home"; }
		  

	
	//도서 예약
	@RequestMapping("/reserveBook")
	public String reserveBook(ReserveVO reserveVO) {
		return "redirect:/admin/reserveList";
	}
	
	//회원관리 페이지
	@GetMapping("/memberManage")
	public String memberManage(Model model, MemberVO memberVO) {
		model.addAttribute("memList", memberAdminService.selectMemberList());
		return "admin/member_list";
	}
	
	//알림 전송
	@PostMapping("/sendMessage")
	public String sendMessage(MessageVO messageVO) {
		memberAdminService.insertSendMessage(messageVO);
		return "redirect:/admin/memberManage";
	}
	
	
}
