package com.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.frame.Biz;
import com.vo.User;

@Controller
public class MainController {

	@Resource(name = "userBiz")
	Biz<User> biz;

	Logger log = Logger.getLogger("sensor");

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

	@RequestMapping("/logApply.do")
	public String apply(HttpServletRequest res, User user) {
		// http://70.12.114.143/Server/logApply.do?id=a&pwd=123&name=take
		// http://70.12.114.143/Server/logApply.do?USERID=hhw1990&USERPW=1234&USERPHONE=01093471926&USERBIRTH=900525&USERADDR=seoul&CATE=0
		biz.register(user);

		String id = res.getParameter("id");
		String pwd = res.getParameter("pwd");
		String name = res.getParameter("name");

		System.out.println(id + " " + pwd + " " + name);

		log.debug("ID= " + id + " PWD= " + pwd + " NAME= " + name);
		return "logApply";
	}

}
