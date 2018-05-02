package com.hw.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.vo.User;

@Controller
public class UserController {
		
	@RequestMapping("/userlist.do")
	public String list(Model m) {
		//Database���� �����͸� ������ �´�.
		ArrayList<Object> list = null;
		list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "������"));
		list.add(new User("id02", "pwd02", "���ǥ"));
		list.add(new User("id03", "pwd03", "����ȯ"));
		list.add(new User("id04", "pwd04", "������"));
		list.add(new User("id05", "pwd05", "������"));
		m.addAttribute("userlist", list);
		m.addAttribute("center", "user/list"); // �ֻ����� view�� �ִٰ� ��������!
		return "main";
	}
	
	@RequestMapping("/useradd.do")
	public String add(Model m) {
		//View�� ������ Model�� ���� �� ����
		m.addAttribute("center", "user/add");
		return "main";
	}
	
	@RequestMapping("/useraddimpl.do")
	public String impl(Model m, User u){ // VO package���� user�� �Ѿ�� id pwd name ��� �ڵ����� �Ҵ�Ǽ� ����. ��, getter setter�� �ݵ�� ���������!
		//DB�� �Է��Ѵ�.
		System.out.println(m);
		m.addAttribute("center", "user/addok");
		return "main";
	}
	
}