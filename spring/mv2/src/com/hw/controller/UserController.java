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
		//Database에서 데이터를 가지고 온다.
		ArrayList<Object> list = null;
		list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "장태익"));
		list.add(new User("id02", "pwd02", "고경표"));
		list.add(new User("id03", "pwd03", "구일환"));
		list.add(new User("id04", "pwd04", "누구의"));
		list.add(new User("id05", "pwd05", "곽도원"));
		m.addAttribute("userlist", list);
		m.addAttribute("center", "user/list"); // 최상위는 view가 있다고 생각하자!
		return "main";
	}
	
	@RequestMapping("/useradd.do")
	public String add(Model m) {
		//View를 제외한 Model을 보낼 수 있음
		m.addAttribute("center", "user/add");
		return "main";
	}
	
	@RequestMapping("/useraddimpl.do")
	public String impl(Model m, User u){ // VO package에서 user로 넘어옴 id pwd name 모두 자동으로 할당되서 들어옴. 단, getter setter가 반드시 있으어야함!
		//DB에 입력한다.
		System.out.println(m);
		m.addAttribute("center", "user/addok");
		return "main";
	}
	
}