package com.kh.emp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.emp.service.EmpService;
import com.kh.emp.vo.DeptVO;
import com.kh.emp.vo.EmpVO;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Resource(name="empService")
	private EmpService empService;
	
	//초기화면
	@GetMapping("/home")
	public String home() {
		return "emp/home";
	}
	
	//부서관리화면
	@GetMapping("/deptManage")
	public String goDept() {
		
		return "emp/dept_manage";
	}
	
	//부서 등록
	@PostMapping("/regDept")
	public String insertDept(Model model, DeptVO deptVO) {
		empService.insertDept(deptVO);
		return "redirect:/emp/deptList";
	}
	
	//부서관리조회
	@GetMapping("/deptList")
	public String selectDeptList(Model model) {
		model.addAttribute("deptList", empService.selectDeptList());
		return "emp/dept_manage";
	}
	
	//회원 등록 폼
	@GetMapping("/regEmpForm")
	public String insertEmp(Model model, EmpVO empVO) {
		model.addAttribute("deptList", empService.selectDeptList());
		return "emp/emp_manage";
	}
	
	//회원 등록
	@PostMapping("/regEmp")
	public String insertEmp(EmpVO empVO) {
		empVO.setTell(empVO.getTell().replace(",", "-"));
		empService.insertEmp(empVO);
		return "redirect:/emp/empList";
	}
	
	//회원 조회
	@GetMapping("/empList")
	public String selectEmpList(Model model) {
		model.addAttribute("empList", empService.selectEmpList());
		return "emp/emp_list";
	}
}














