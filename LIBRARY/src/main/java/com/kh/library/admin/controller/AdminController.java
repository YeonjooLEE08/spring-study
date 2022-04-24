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

import com.kh.library.admin.service.BookAdminService;
import com.kh.library.admin.service.ItemAdminService;
import com.kh.library.book.service.BookService;
import com.kh.library.book.vo.ReserveVO;
import com.kh.library.book.vo.BookImgVO;
import com.kh.library.book.vo.BookVO;
import com.kh.library.item.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	  
	   
		
	@Resource(name = "itemAdminService") 
	private ItemAdminService itemAdminService;
		  
	@Resource(name = "itemService") 
	private ItemService itemService;
		 
	@GetMapping("/test") 
	public String test() { 
		 return "manage/home"; }
		  
		 
	@Resource(name = "bookService")
	private BookService bookService;
	
	@Resource(name = "bookAdminService")
	private BookAdminService bookAdminService;
	
	//도서 예약
	@RequestMapping("/reserveBook")
	public String reserveBook(ReserveVO reserveVO) {
		return "redirect:/admin/reserveList";
	}
	
	//책 등록페이지
	@GetMapping("/regBookForm")
	public String regBookForm(Model model) {
		model.addAttribute("cateList",bookService.selectBookCategory());
		return "admin/reg_book";
	}
	
	//책 리스트 조회
	@GetMapping("/bookList")
	public String selectBookList(Model model) {
		model.addAttribute("bookList", bookService.selectBookList());
		return "book/book_list";
	}
	
	//책 상세 조회
	@GetMapping("/bookDetail")
	public String selectBookDetail(Model model, BookVO bookVO) {
		model.addAttribute("book", bookService.selectBookDetail(bookVO));
		return "book/book_detail";	
	}
	
	
	// 책 등록 
	@PostMapping("/regBook")
	public String regBook(BookVO bookVO, MultipartHttpServletRequest multi) {
		
		  //이미지 저장 공간
	      List<BookImgVO> imgList = new ArrayList<BookImgVO>();
	      BookImgVO bookImgVO = new BookImgVO();
	      
	      String nextBookCode = bookAdminService.selectNextBookCode();
	      int nextBookImgCode = bookAdminService.selectNextBookImgCode();
	      
	      Iterator<String> inputTagsNames = multi.getFileNames();
	      String uploadPath = "D:Git\\spring-study\\LIBRARY\\src\\main\\webapp\\resources\\images\\book\\";
	      
	      while(inputTagsNames.hasNext()) {
	    	  String inputTagName = inputTagsNames.next();
	    	  
	    	  if(inputTagName.equals("")) {
	    		  MultipartFile file = multi.getFile(inputTagName);
	    		  String originFileName = file.getOriginalFilename();
	    		  
	    		  if(!originFileName.equals("")) {
	    			  String attachedFileName = System.currentTimeMillis()+"_"+originFileName;
	    			  
	    			  try {
	    				  file.transferTo(new java.io.File(uploadPath+attachedFileName));
	    				  BookImgVO vo = new BookImgVO();
	    				  vo.setBkImgCode(nextBookImgCode++);
	    				  vo.setBkOriginName(originFileName);
	    				  vo.setBkAtName(attachedFileName);
	    				  vo.setBookCode(nextBookCode);
	    				  imgList.add(vo);
	    				  
	    			  } catch(IllegalStateException e) {
	    				  e.printStackTrace();
	    			  } catch(IOException e) {
	    				  e.printStackTrace();
	    			  }
	    		  }
	    	  }
	      }
	      
	      //책 insert
	      bookVO.setBookCode(nextBookCode);
	      bookImgVO.setBookImgList(imgList);
	      bookAdminService.insertBook(bookVO, bookImgVO);
	      
		return "redirect:/admin/bookList";
	
	}
	
}
