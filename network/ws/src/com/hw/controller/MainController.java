package com.hw.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
   Logger logger = Logger.getLogger("work");//work라는 로거파일에 저장됨
   
   @RequestMapping("/main.do")
   @ResponseBody
   public void main(HttpServletRequest request) {
	   String speed = request.getParameter("speed");
	   String temp = request.getParameter("temp");
	   logger.debug(speed + ":" + temp);
	   //return "main";
   }
   
}