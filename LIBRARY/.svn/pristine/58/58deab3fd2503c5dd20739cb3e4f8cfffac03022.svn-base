package com.kh.library.club.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.library.club.service.ClubAdminService;
import com.kh.library.club.vo.ClubApplyVO;

@Controller
@RequestMapping("/clubAdmin")
public class ClubAdminController {
	@Resource(name = "clubAdminService")
	private ClubAdminService clubAdminService;

	//클럽관리
	@GetMapping("/clubAdmin")
	public String clubAdmin(ClubApplyVO clubApplyVO, Model model) {
		model.addAttribute("applyList", clubAdminService.selectClubApplyList(clubApplyVO));
		return "club/club_manage";
	}
		
}
