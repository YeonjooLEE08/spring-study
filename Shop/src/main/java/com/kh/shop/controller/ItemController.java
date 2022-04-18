package com.kh.shop.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.shop.service.ItemService;
import com.kh.shop.vo.CategoryVO;
import com.kh.shop.vo.ItemVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource(name = "itemService")
	private ItemService itemService;
	
	//전체상품 목록 페이지
	@GetMapping("/itemList")
	public String itemList(Model model, String cateCode) {
		//카테고리 목록
		model.addAttribute("categoryList", itemService.selectCategoryList());
		//메뉴에서 클릭한 카테고리의 코드값
		model.addAttribute("selectedCategory", cateCode);
		
		//상품 목록 조회
		model.addAttribute("itemList", itemService.selectItemList());
		
		return "item/item_list";
	}
	
	//상품 상세보기 페이지
	@GetMapping("/itemDetail")
	public String itemDetail(String itemCode, Model model) {
		ItemVO result = itemService.selectItemDetail(itemCode);
		System.out.println(result);
		
		model.addAttribute("item", result);
		
		return "item/item_detail";
	}
	
	
}











