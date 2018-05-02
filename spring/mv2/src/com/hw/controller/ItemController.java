package com.hw.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.vo.Item;

@Controller
public class ItemController {
		
	@RequestMapping("/itemlist.do")
	public String list(Model m) {
		//Database에서 데이터를 가지고 온다.
		ArrayList<Object> list = null;
		list = new ArrayList<>();
		list.add(new Item(1, "item01", 2));
		list.add(new Item(2, "item02", 3));
		list.add(new Item(3, "item03", 4));
		list.add(new Item(4, "item04", 5));
		list.add(new Item(5, "item05", 6));
		m.addAttribute("itemlist", list);
		m.addAttribute("center", "item/list"); // 최상위는 view가 있다고 생각하자!
		return "main";
	}
	
	@RequestMapping("/itemadd.do")
	public String add(Model m) {
		//View를 제외한 Model을 보낼 수 있음
		m.addAttribute("center", "item/add");
		return "main";
	}
	
	@RequestMapping("/itemaddimpl.do")
	public String impl(Model m, Item u){ // VO package에서 user로 넘어옴 id pwd name 모두 자동으로 할당되서 들어옴. 단, getter setter가 반드시 있으어야함!
		//DB에 입력한다.	
		System.out.println(m);
		m.addAttribute("center", "item/addok");
		return "main";
	}
	
}