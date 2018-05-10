package com.hw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	Logger logger = Logger.getLogger("work");// work라는 로거파일에 저장됨

	@RequestMapping("/main.do")
	@ResponseBody
	public void main(HttpServletRequest request, HttpServletResponse response) {
		String speed = request.getParameter("speed");
		String temp = request.getParameter("temp");
		logger.debug(speed + ":" + temp);
		// return "main";

		PrintWriter out;
		try {
			out = response.getWriter();
			out.print(speed);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

}