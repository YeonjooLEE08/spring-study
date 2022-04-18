package com.kh.shop.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kh.shop.service.CartService;
import com.kh.shop.vo.CartVO;
import com.kh.shop.vo.CartViewVO;
import com.kh.shop.vo.MemberVO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource(name = "cartService")
	private CartService cartService;
	
	//장바구니에 상품 등록
	//커맨드객체는 자동으로 jsp로 데이터 가져간다.
	@PostMapping("/insertCart")
	public String insertCart(CartVO cartVO, HttpSession session) {
		String loginId = ((MemberVO)(session.getAttribute("loginInfo"))).getMemId();
		cartVO.setMemId(loginId);
		cartService.insertCart(cartVO);
		
		return "cart/insert_result";
	}
	
	//장바구니 목록 페이지
	@GetMapping("/cartList")
	public String cartList(Model model, HttpSession session) {
		String memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
		
		//장바구니 목록 조회
		List<CartViewVO> cartList = cartService.selectCartList(memId);
		model.addAttribute("cartList", cartList);
		
		//구매가격
		int totalPrice = 0;
		for(CartViewVO e : cartList) {
			totalPrice = totalPrice + e.getTotalPrice();
		}
		model.addAttribute("totalPrice", totalPrice);
		
		return "cart/cart_list";
	}
	
	@PostMapping("/deleteCart")
	public String deleteCart(CartVO cartVO, HttpSession session) {
		String memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
		cartVO.setMemId(memId);
		cartService.deleteCart(cartVO);
		
		return "redirect:/cart/cartList";
	}
	
	@ResponseBody
	@PostMapping("/updateItemCnt")
	public void updateItemCnt(CartVO cartVO, HttpSession session) {
		String memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
		cartVO.setMemId(memId);
		cartService.updateItemCnt(cartVO);
	}
	
	//선택 상품 장바구에서 삭제
	@GetMapping("/deleteCarts")
	public String deleteCarts(CartVO cartVO, HttpSession session) {
		String memId = ((MemberVO)session.getAttribute("loginInfo")).getMemId();
		cartVO.setMemId(memId);
		cartService.deleteCarts(cartVO);
		
		return "redirect:/cart/cartList";
	}
	
	
}













