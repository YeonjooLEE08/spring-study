package com.kh.shop.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.shop.vo.BuySearchVO;
import com.kh.shop.vo.BuyVO;
import com.kh.shop.vo.ImgVO;
import com.kh.shop.vo.ItemVO;
import com.kh.shop.vo.MenuVO;
import com.kh.shop.vo.SubMenuVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertItem(ItemVO itemVO, ImgVO imgVO) {
		sqlSession.insert("adminMapper.insertItem", itemVO);
		sqlSession.insert("adminMapper.insertImages",imgVO);
	}

	@Override
	public List<MenuVO> selectMenuList() {
		return sqlSession.selectList("adminMapper.selectMenuList");
	}

	@Override
	public List<SubMenuVO> selectSubMenuList(String menuCode) {
		return sqlSession.selectList("adminMapper.selectSubMenuList", menuCode);
	}

	@Override
	public void insertImages(ImgVO imgVO) {
		sqlSession.insert("adminMapper.insertImages",imgVO);
	}

	@Override
	public int selectNextImgCode() {
		return sqlSession.selectOne("adminMapper.selectNextImgCode");
	}

	@Override
	public String selectNextItemCode() {
		return sqlSession.selectOne("adminMapper.selectNextItemCode");
	}

	@Override
	public List<BuyVO> selectBuyList(BuySearchVO buySearchVO) {
		return sqlSession.selectList("adminMapper.selectBuyList", buySearchVO);
	}

	@Override
	public List<BuyVO> selectBuyListDetail(String orderNum) {
		return sqlSession.selectList("adminMapper.selectBuyListDetail", orderNum);
	}

	@Override
	public int selectBuyListCnt(BuySearchVO buySearchVO) {
		return sqlSession.selectOne("adminMapper.selectBuyListCnt", buySearchVO);
	}
}








