package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.Biz;
import com.vo.User;


@Controller
public class MainController {

		@Resource(name="userBiz")
		Biz<User> biz;

	   @RequestMapping("/main.do")
	   public String main() {
	      return "main";
	   }
	   
	   @RequestMapping("/insert.do")
	   public String insert(User t) {
		   //db에 정보 등록
		   
		   biz.register(t);
		   
	      return "login";
	   }
	
}
