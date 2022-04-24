package com.kh.emp.service;

import java.util.List;

import com.kh.emp.vo.DeptVO;
import com.kh.emp.vo.EmpVO;

public interface EmpService {
	
	//부서 등록
	void insertDept(DeptVO deptVO);
	
	//부서 조회
	List<DeptVO> selectDeptList();
	
	//회원 등록
	void insertEmp(EmpVO empVO);
	
	//회원 조회
	List<EmpVO> selectEmpList();
}
