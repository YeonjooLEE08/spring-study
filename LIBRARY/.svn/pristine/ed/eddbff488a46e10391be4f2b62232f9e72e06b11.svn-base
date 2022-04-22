package com.kh.library.club.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.library.club.vo.ClubApplyVO;

@Service("clubAdminService")
public class ClubAdminServiceImpl implements ClubAdminService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ClubApplyVO> selectClubApplyList(ClubApplyVO clubApplyVO) {
		return sqlSession.selectList("clubMapper.selectClubApplyList",clubApplyVO);
	}

}
