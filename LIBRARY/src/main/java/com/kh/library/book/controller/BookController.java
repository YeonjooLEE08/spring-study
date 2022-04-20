package com.kh.library.book.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.library.book.service.BookService;
import com.kh.library.book.vo.HopeBookVO;

@Controller
@RequestMapping("/book")
public class BookController {
	
	@Resource(name="bookService")
	private BookService bookService;
	
	//전체도서 목록 페이지
	@GetMapping("/bookList")
	public String bookList(Model model, String bookCode) {
		//도서 목록 조회
		model.addAttribute("bookList", bookService.selectBookList());
		
		return "book/book_list";
	}
	//희망도서  등록
	@RequestMapping("/regHopeBook")
	public String regHopeBook(HopeBookVO hbVO) {
		
		bookService.regHopeBook(hbVO);
		return "book/book_list";
	}

}
