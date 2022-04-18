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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.library.admin.service.BookAdminService;
import com.kh.library.admin.service.ItemAdminService;
import com.kh.library.book.service.BookService;
import com.kh.library.book.vo.BookImgVO;
import com.kh.library.book.vo.BookVO;
import com.kh.library.item.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	/*
	 * @Resource(name = "itemAdminService") private ItemAdminService
	 * itemAdminService;
	 * 
	 * @Resource(name = "itemService") private ItemService itemService;
	 * 
	 * @GetMapping("/test") public String test() { return "manage/home"; }
	 * 
	 * @GetMapping("/insertItem") public String insertItemForm(Model model, String
	 * menuCode, String subMenuCode) {
	 * model.addAttribute("cateList",itemService.selectItemCategory()); return
	 * "admin/add_item"; }
	 */
	@Resource(name = "bookService")
	private BookService bookService;
	
	@Resource(name = "bookAdminService")
	private BookAdminService bookAdminService;
	
	// 책 등록 
	@PostMapping("/regBook")
	public String regBook(BookVO bookVO, MultipartHttpServletRequest multi) {
		//여러 이미지 정보 셋팅 공간 생성
		List<BookImgVO> bookImgList = new ArrayList<BookImgVO>();
		
		//이미지 삽입 쿼리 실행 시 빈값 채우는 객체
		BookImgVO bookImgVO = new BookImgVO();
		
		//다음에 들어갈 img_code조회
		int nextBookImgCode = bookAdminService.selectNextImgCode();
		
		//다음에 들어갈 book코드 조회
		String nextBookCode = bookAdminService.selectNextBookCode();
		
		//이미지 첨부
		Iterator<String> inputTagNames = multi.getFileNames();
		
		String uploadPath = "D:git\\spring-study\\LIBRARY\\src\\main\\webapp\\resources\\images\\book\\";
		
		while(inputTagNames.hasNext()) {
			String inputTagName = inputTagNames.next();
			
			if(inputTagName.equals("subImg")) {
				List<MultipartFile> fileList = multi.getFiles(inputTagName);
				
				for(MultipartFile file : fileList) {
					
					String originFileName = file.getOriginalFilename();
					
					if(!originFileName.equals("")) {
						String attachedFileName = System.currentTimeMillis()+"_"+ originFileName;
						
						try {
							file.transferTo(new File(uploadPath+attachedFileName));
							BookImgVO vo = new BookImgVO();
							vo.setBkImgCode(nextBookImgCode++);
							vo.setBkOriginName(originFileName);
							vo.setBkAtImgName(attachedFileName);
							vo.setIsMain("N");
							vo.setBookCode(nextBookCode);
							bookImgList.add(vo);
						
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					
					}
				}
			}
			
			//단일 첨부
			else {
				MultipartFile file = multi.getFile(inputTagName);
				
				String originFileName = file.getOriginalFilename();
				
				if(!originFileName.equals("")) {
					String attachedFileName = System.currentTimeMillis()+"_"+originFileName;
					
					try {
						file.transferTo(new File(uploadPath+attachedFileName));
						BookImgVO vo = new BookImgVO();
						vo.setBkImgCode(nextBookImgCode++);
						vo.setBkOriginName(originFileName);
						vo.setBkAtImgName(attachedFileName);
						vo.setIsMain("N");
						vo.setBookCode(nextBookCode);
						bookImgList.add(vo);
					
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		// 도서 정보 INSERT
		bookVO.setBookCode(nextBookCode);
		bookImgVO.setImgList(bookImgList);
		bookAdminService.insertBook(bookVO,bookImgVO);
		
		return "book/book_list";
	
	}
}
