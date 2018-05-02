package com.hw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.frame.Biz;
import com.hw.vo.User;

@Controller
public class UserController {
		
	@Resource(name="userBiz")
	Biz<User,String> biz;
	
	@RequestMapping("/userlist.do")
	public String list(Model m) {
		// Database���� �����͸� ������ �´�.
		List<User> list = null;
		list = biz.get();
		m.addAttribute("userlist", list);
		m.addAttribute("center", "user/list");
		return "main";
	}
	
	@RequestMapping("/detailsearch.do")
	public String detail(Model m) {
		User list = null;
		
		return "main";
	}
	
		
	@RequestMapping("/useradd.do")
	public String add(Model m) {
		m.addAttribute("center", "user/add");
		return "main";
	}
	
	@RequestMapping("/usermodify.do")
	public String modify(Model m, String id) {
		m.addAttribute("user", biz.get(id));
		m.addAttribute("center","user/modify");
		return "main";
	}
	
	@RequestMapping("/useraddimpl.do")
	public String addimpl(Model m,User u) {
		System.out.println("addimpl:"+m);
		// DB�� �Է� �Ѵ�.
		biz.register(u);
		m.addAttribute("center", "user/addok");
		return "main";
	}
	
	@RequestMapping("/userupdate.do")
	public String update(Model m, User u) {
		biz.modify(u);
		return list(m);
	}
	
	@RequestMapping("/userdelete.do")
	public String delete(Model m, User u) {
		biz.remove(u.getId());
		return list(m);
	}
	
}



