package com.kh.library.admin.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.library.item.vo.ItemImgVO;
import com.kh.library.item.vo.ItemVO;
@Service("itemAdminService")
public class ItemAdminServiceImpl implements ItemAdminService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertItem(ItemVO itemVO, ItemImgVO itemImgVO) {
		sqlSession.insert("itemAdminMapper.insertItem", itemVO);
		sqlSession.insert("itemAdminMapper.insertItemImg", itemImgVO);
	}

	@Override
	public void insertItemImges(ItemImgVO itemImgVO) {
		sqlSession.insert("itemAdminMapper.insertItemImg", itemImgVO);
		
	}

	@Override
	public String selectNextItemImgCode() {
		return sqlSession.selectOne("itemAdminMapper.selectNextItemCode");
	}

	@Override
	public String selectNextItemCode() {
		return sqlSession.selectOne("itemAdminMapper.selectNectImgCode");
	}

}
