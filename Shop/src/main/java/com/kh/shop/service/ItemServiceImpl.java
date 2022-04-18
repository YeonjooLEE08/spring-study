package com.kh.shop.service;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.shop.vo.CategoryVO;
import com.kh.shop.vo.ItemVO;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CategoryVO> selectCategoryList() {
		return sqlSession.selectList("itemMapper.selectCategoryList");
	}

	@Override
	public List<ItemVO> selectItemList() {
		return sqlSession.selectList("itemMapper.selectItemList");
	}

	@Override
	public ItemVO selectItemDetail(String itemCode) {
		return sqlSession.selectOne("itemMapper.selectItemDetail", itemCode);
	}


}






