package com.kh.shop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kh.shop.service.AdminService;
import com.kh.shop.service.ItemService;
import com.kh.shop.util.MyDateUtil;
import com.kh.shop.vo.BuySearchVO;
import com.kh.shop.vo.BuyVO;
import com.kh.shop.vo.ImgVO;
import com.kh.shop.vo.ItemVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "itemService")
	private ItemService itemService;
	
	//카테고리 관리 페이지로 이동(상단에 관리자 메뉴 클릭 시 실행)
	@GetMapping("/categoryManage")
	public String categoryManage(Model model, String menuCode, String subMenuCode) {
		return "admin/category_manage";
	}
	
	//상품등록 페이지로 이동
	@GetMapping("/regItem")
	public String regItem(Model model, String menuCode, String subMenuCode) {
		//카테고리 목록 조회
		model.addAttribute("categoryList", itemService.selectCategoryList());
		
		return "admin/reg_item";
	}
	
	//상품등록
	@PostMapping("/regItem")
	public String regItem(ItemVO itemVO, MultipartHttpServletRequest multi) {
		//여러 이미지 정보를 세팅할 공간 생성
		List<ImgVO> imgList = new ArrayList<ImgVO>();
		
		//이미지 삽입 쿼리 실행 시 빈값을 채워줄 객체
		ImgVO imgVO = new ImgVO();
		
		//다음에 들어갈 IMG_CODE 값을 조회
		int nextImgCode = adminService.selectNextImgCode();
		
		//다음에 들어갈 ITEM_CODE값을 조회
		String nextItemCode = adminService.selectNextItemCode();
		
		//------------이미지 첨부(파일 업로드)--------------//
		//첨부파일이 들어가는 input 태그들의 name 속성 값을 가져온다.
		Iterator<String> inputTagNames = multi.getFileNames();
		
		//첨부파일이 저장될 위치 지정
		String uploadPath = "D:\\Git\\workspaceSTS\\Shop\\src\\main\\webapp\\resources\\images\\";
		
		//첨부파일이 들어간 input 태그의 개수만큼 반복
		while(inputTagNames.hasNext()) {
			//"mainImg", "subImg"
			String inputTagName = inputTagNames.next();
			
			//다중 첨부...
			if(inputTagName.equals("subImg")) {
				List<MultipartFile> fileList = multi.getFiles(inputTagName);
				
				for(MultipartFile file : fileList) {
					//원본 파일명
					String originFileName = file.getOriginalFilename();
					
					if(!originFileName.equals("")) {
						//첨부할 파일명
						String attachedFileName = System.currentTimeMillis() + "_" + originFileName;
						
						try {
							file.transferTo(new File(uploadPath + attachedFileName));
							ImgVO vo = new ImgVO();
							vo.setImgCode(nextImgCode++);
							vo.setOriginImgName(originFileName);
							vo.setAttachedImgName(attachedFileName);
							vo.setIsMain("N");
							vo.setItemCode(nextItemCode);
							imgList.add(vo);
							
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
			//단일 첨부...
			else{
				//name이 "mainImg"인 input태그의 파일 정보를 가져 옴. 
				MultipartFile file = multi.getFile(inputTagName);
				
				//첨부하고자 하는 파일명
				String originFileName = file.getOriginalFilename();

				if(!originFileName.equals("")) {
					//첨부할 파일명
					String attachedFileName = System.currentTimeMillis() + "_" + originFileName;
					
					//파일 업로드
					//매개변수로 경로 및 파일명을 넣어줌
					try {
						file.transferTo(new File(uploadPath + attachedFileName));
						
						ImgVO vo = new ImgVO();
						vo.setImgCode(nextImgCode++);
						vo.setOriginImgName(originFileName);
						vo.setAttachedImgName(attachedFileName);
						vo.setIsMain("Y");
						vo.setItemCode(nextItemCode);
						imgList.add(vo);
						
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		//------------이미지 첨부 끝!!!!!!!--------------//
	
		
		//상품 정보 INSERT (SHOP_ITEM)
		itemVO.setItemCode(nextItemCode);
		imgVO.setImgList(imgList);
		adminService.insertItem(itemVO, imgVO);
		
		//상품 이미지 정보 INSERT(ITEM_IMAGE)
		//adminService.insertImages(imgVO);
		
		
		return "redirect:/admin/regItem?menuCode=MENU_001&subMenuCode=SUB_MENU_002";
	}
	
	//상품관리 페이지로 이동(싸이드)
	@GetMapping("/itemManage")
	public String itemManage(Model model, String menuCode, String subMenuCode, ItemVO itemVO) {
		//관리자 메뉴 목록 조회
		//model.addAttribute("menuList", adminService.selectMenuList());
		
		//상품관리 메뉴의 하위메뉴목록 조회
		//model.addAttribute("subMenuList", adminService.selectSubMenuList(menuCode));
		
		//model.addAttribute("selectedMenu", menuCode);
		//model.addAttribute("selectedSubMenu", subMenuCode);	
		
		//ItemVO itemVO = new ItemVO();
		//itemVO.setItemName("테스트상품");	
		//model.addAttribute("itemVO", itemVO);
		
		
		return "admin/item_manage";
	}
	
	//회원 목록 페이지로 이동
	@GetMapping("/memberList")                                                
	public String memberList(Model model, String menuCode, String subMenuCode) {
		
		return "admin/member_list";
	}
	
	//구매목록관리
	@RequestMapping("/buyManage")
	public String buyManage(Model model, String menuCode, String subMenuCode, BuySearchVO buySearchVO) {
		//이달의 1일
		String firstDate = MyDateUtil.getFirstDateOfNowMonth();
		
		//오늘날짜를 구함
		String nowDate = MyDateUtil.getNowDateToString();
	
		if(buySearchVO.getSearchFromDate() == null) {
			buySearchVO.setSearchFromDate(firstDate);
		}
		if(buySearchVO.getSearchToDate() == null) {
			buySearchVO.setSearchToDate(nowDate);
		}
		
		//---------페이징 정보 세팅----------//
		// 1. 전체 데이터의 개수 조회
		int listCnt = adminService.selectBuyListCnt(buySearchVO);
		buySearchVO.setTotalCnt(listCnt);
		
		// 2. 페이징 처리를 위한 세팅 메소드 호출
		buySearchVO.setPageInfo();
		
		model.addAttribute("buyList", adminService.selectBuyList(buySearchVO));
		
		return "admin/buy_manage";
	}
	
	@ResponseBody
	@PostMapping("/selectBuyListDetail")
	public List<BuyVO> selectBuyListDetail(String orderNum) {
		return adminService.selectBuyListDetail(orderNum);
	}
	
	
}













