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
		//Database���� �����͸� ������ �´�.
		ArrayList<Object> list = null;
		list = new ArrayList<>();
		list.add(new Item(1, "item01", 2));
		list.add(new Item(2, "item02", 3));
		list.add(new Item(3, "item03", 4));
		list.add(new Item(4, "item04", 5));
		list.add(new Item(5, "item05", 6));
		m.addAttribute("itemlist", list);
		m.addAttribute("center", "item/list"); // �ֻ����� view�� �ִٰ� ��������!
		return "main";
	}
	
	@RequestMapping("/itemadd.do")
	public String add(Model m) {
		//View�� ������ Model�� ���� �� ����
		m.addAttribute("center", "item/add");
		return "main";
	}
	
	@RequestMapping("/itemaddimpl.do")
	public String impl(Model m, Item u){ // VO package���� user�� �Ѿ�� id pwd name ��� �ڵ����� �Ҵ�Ǽ� ����. ��, getter setter�� �ݵ�� ���������!
		//DB�� �Է��Ѵ�.	
		System.out.println(m);
		m.addAttribute("center", "item/addok");
		return "main";
	}
	
}