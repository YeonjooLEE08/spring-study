package com.kh.shop.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.shop.service.BuyService;
import com.kh.shop.service.BuyServiceImpl;
import com.kh.shop.service.CartService;
import com.kh.shop.vo.BuyVO;
import com.kh.shop.vo.CartVO;
import com.kh.shop.vo.MemberVO;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/buy")
public class BuyController {
	@Resource(name = "buyService")
	private BuyService buyService;

	@Resource(name = "cartService")
	private CartService cartService;

	@ResponseBody
	@PostMapping("/insertBuys")
	public void insertBuys(String data, HttpSession session) {
		
		System.out.println(data);
		String memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
		
		//SHOP_BUY 테이블에 저장된 가장큰 BUY_NUM +1 값을 조회
		int nextBuyNum = buyService.selectNextBuyNum();
		
		List<Map<String, String>> list = JSONArray.fromObject(data); 
		//itemCode가 담길 배열
		String[] itemCodeArr = new String[list.size()];
		//배열의 index
		int index = 0;
//		[
//		   {"itemCode":"ITEM_008","itemCnt":"3"}
//		   ,{"itemCode":"ITEM_001","itemCnt":"2"}
//		   ,{"itemCode":"ITEM_006","itemCnt":"1"}
//		   ,{"itemCode":"ITEM_007","itemCnt":"1"}
//		]
		List<BuyVO> buyList = new ArrayList<BuyVO>();
		BuyVO buyVO = new BuyVO();
		for(Map<String, String> map : list) {
			System.out.println("itemCode : " + map.get("itemCode") + " / itemCnt=" + map.get("itemCnt"));
			
			BuyVO vo = new BuyVO();
			vo.setItemCode(map.get("itemCode"));
			vo.setItemCnt(Integer.parseInt(map.get("itemCnt")));
			vo.setMemId(memId);
			vo.setBuyNum(nextBuyNum++);
			vo.setOrderNum(getNowDateTimeToString() + "_" + memId);
			
			buyList.add(vo);
			
			itemCodeArr[index++] = map.get("itemCode");
		}
		buyVO.setBuyList(buyList);
		
		
		//구매한 상품 장바구니에서 삭제
		CartVO cartVO = new CartVO();//memId, itemCode들
		cartVO.setMemId(memId);
		cartVO.setItemCodeArr(itemCodeArr);
		
		buyService.insertBuys(buyVO, cartVO);
		
		
		
	}
	
	
	public String getNowDateTimeToString() {
		//싱글톤 패턴
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;//1~12   0~11
		int date = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		String nowDateTime = "" + year + month + date + hour + minute + second;
		return nowDateTime;
		
	}
	
}




















