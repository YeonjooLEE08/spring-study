package com.kh.shop.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

//컬랙션 프레임워크
//List, Map, Set, Queue
public class MapTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("python");
		list.get(1);
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "홍길동");
		map.put(2, "이순신");
		map.put(3, "이순신");
		
		List<Map<Integer, String>> list1 = new ArrayList<Map<Integer,String>>();
				
		
		
		
	}
}

















