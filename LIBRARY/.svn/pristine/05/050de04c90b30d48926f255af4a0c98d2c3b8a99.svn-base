package com.kh.library.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.library.admin.service.ItemAdminService;
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
		return "manage/home";
	}
	
	@GetMapping("/insertItem")
	public String insertItemForm(Model model, String menuCode, String subMenuCode) {
		model.addAttribute("cateList",itemService.selectItemCategory());
		return "admin/add_item";
	}
}
