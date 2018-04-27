package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/plain;charset=utf-8");  //들어올때
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		
		name = new String(name.getBytes("8859_1"),"UTF-8"); //8859_1 : 표준 캐릭터셋코드
		System.out.println(name);
		String result = "";
		
		response.setCharacterEncoding("utf-8");		//나갈때 
        
        
		if (id.equals("qq") && pwd.equals("11")) {
			result = "정상";
		}else {
			result = "비정상";
		}
		
		PrintWriter out = response.getWriter();
		out.print(result);
		out.close();
	}

}
