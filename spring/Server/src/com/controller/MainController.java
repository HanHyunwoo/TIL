package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	Logger log = Logger.getLogger("sensor"); 
	
	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/logApply.do")
	public String apply(HttpServletRequest res) { // , Model m
		//http://70.12.114.143/Server/logApply.do?id=a&pwd=123&name=take
		String id = res.getParameter("id");
		String pwd = res.getParameter("pwd");
		String name = res.getParameter("name");
		System.out.println(id + " " + pwd + " " + name);
		
		log.debug("ID= " +id + " PWD= " + pwd + " NAME= " + name);
		// User user = new User(id,pwd,name);
		// uBiz.insert(user);
		// m.addAttribute("isOk", 1);
		return "logApply";
	}

}
