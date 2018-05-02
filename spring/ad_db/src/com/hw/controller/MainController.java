package com.hw.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hw.frame.Biz;
import com.hw.vo.Login;
import com.hw.vo.User;

@Controller
public class MainController {

	@Resource(name = "userBiz")
	Biz<User, String> uBiz;
	
	@Resource(name = "loginBiz")
	Biz<Login, String> lBiz;

	@RequestMapping("/main.do")
	public String main() {
		return "main";
	}

//	@RequestMapping("/apply.do")
//	public String apply(HttpServletRequest res, Model m) {
//
//		String id = res.getParameter("id");
//		String pwd = res.getParameter("pwd");
//		String name = res.getParameter("name");
//		System.out.println(id + " " + pwd + " " + name);
//
//		User u = new User(id, pwd, name);
//		uBiz.insert(u);
//		Login l = new Login(id, 0, 0);		
//		lBiz.insert(l);
//		
//		m.addAttribute("isOk", 1);
//		return "apply";
//	}
//
//	@RequestMapping("/login.do")
//	public String login(Model m, HttpServletRequest res, HttpSession session) {
//		System.out.println("------login.do-------------------");
//		String id = res.getParameter("id");
//		String pwd = res.getParameter("pwd");
//
//		
//		User u = new User(id);
//		User result = uBiz.select(u.getId());
//
//		
//		m.addAttribute("key", 0);
//		
//		if (result != null)
//			if ((result.getPwd()).equals(pwd)) {	
//				Login login = new Login();
//				login = lBiz.select(u.getId());
//				login.setLoginstate(1);
//				lBiz.update(login);		
//				m.addAttribute("key", 1);
//			}
//		System.out.println("------login.do-------------------");
//		return "login";
//	}
//
//	@RequestMapping("/loginuser.do") 
//	public String loginuser(Model m) {
//		System.out.println("loginuser.do--------------------");
//		
//		List<Login> list = lBiz.find();
//		System.out.println(list);
//		
//		//m.addAttribute("loginIds", null);
//		
//		if(list != null) {
//			JSONArray ja = new JSONArray();				
//			for (Login index : list) {
//				JSONObject ids = new JSONObject();
//				ids.put("id", index.getId());		
//				ids.put("connection", index.getConn());	
//				ids.put("data", index.getData());	
//				ids.put("lat", index.getLat());	
//				ids.put("lon", index.getLon());	
//				ja.add(ids);
//			}			
//			m.addAttribute("loginIds",ja);				
//		}
//
//		System.out.println("loginuser.do--------------------");
//		return "loginuser";
//	}
//
////	@RequestMapping("/data.do") // 테블릿으로 로그인한 정보 보내기
////	public String data(Model m, HttpServletRequest request) {
////		System.out.println("data.do");
////		String data = request.getParameter("data");
////		m.addAttribute("data", data);
////		return "data";			
////	}	
////	
//	@RequestMapping("/location.do") // 테블릿으로 로그인한 정보 보내기
//	public String location(Model m, HttpServletRequest request) {
//		System.out.println("---[location.do]-----------");
//		String comm = request.getParameter("comm");
//		
//		if(comm.equals("s")) {
//			String id = request.getParameter("id");
//			String lat = request.getParameter("lat");
//			String lon = request.getParameter("lon");
//			Login l = lBiz.select(id);
//			l.setId(id); l.setLat(Double.parseDouble(lat)); l.setLat(Double.parseDouble(lon));
//			lBiz.update(l);
//			m.addAttribute("ja", 1);
//			System.out.println("comm : " + comm + ", id : "+ id + ", "+lat + ", "+lon);
//		}else if(comm.equals("t")) {
//			List<Login> list = lBiz.find();
//			if(list != null) {
//				JSONArray ja = new JSONArray();				
//				for (Login index : list) {
//					JSONObject ids = new JSONObject();
//					ids.put("id", index.getId());	
//					ids.put("lat", index.getLat());	
//					ids.put("lon", index.getLon());	
//					ja.add(ids);
//				}			
//				m.addAttribute("ja",ja);
//				System.out.println("comm : " + comm + ", location has updated on tablet");
//			}else
//				System.out.println("comm : " + comm + ", nothing has updated on tablet");
//		}
//		return "location";			
//	}	
//
//	@RequestMapping("/alluser.do") // 테블릿으로 로그인한 정보 보내기
//	public String allUser(Model m) {
//		System.out.println("allUser.do");
//		List<User> u = uBiz.selectAll();
//
//		JSONArray ja = new JSONArray();
//		for(int i=0;i<u.size();i++) {
//	    	 JSONObject member = new JSONObject();
//	    	 member.put("id",u.get(i).getId());
//	    	 member.put("name", u.get(i).getName());
//	    	 member.put("registdate", u.get(i).getRegistdate());
//	    	 member.put("img", null);
//	         ja.add(member);	      
//	      }	
//		System.out.println(ja.toString());
//		m.addAttribute("allUser", ja);		
//		return "allUser";	
//	}
//	
//	@RequestMapping("/connection.do") // 안드로이드에서 오는 신호 들어오기
//	public String connection(Model m,HttpServletRequest request, HttpSession session) {
//		System.out.println("---[connection.do]-------------");
//		
//		String comm = request.getParameter("comm");
//		String id = request.getParameter("id");
//		System.out.println(comm);
//		
//		if(comm.equals("s")) {		
//			
//			Login login = lBiz.select(id);
//			login.setConn(login.getConn()+1);
//			lBiz.update(login);
//			request.setAttribute("id", "connected with server");
//			return "connectionS";
//			
//		}else if(comm.equals("t")) {
//			
//			List<Login> login = lBiz.find();		
//			
//			if(login != null) {
//				
//				JSONArray connIds = new JSONArray();
//				for(Login index : login) {
//					if(index.getConn() > 0) {
//						JSONObject ids = new JSONObject();
//						ids.put("id", index);
//						connIds.add(ids);
//					}
//				}				
//				m.addAttribute("connIds", connIds);
//			}
//			return "connectionT";
//		}
//		return "connectionE";
//		
//	}
//
//	@RequestMapping("/disconnect.do")
//	public String disconnect(Model m, HttpServletRequest request) {
//		System.out.println("disconnect.do");
//		
//		String comm = request.getParameter("comm");
//		if(comm.equals("comm")) {
//			String id = request.getParameter("id");
//			m.addAttribute("id", id);
//		}		
//		return "disconnect";
//	}
//
//	@RequestMapping("/logout.do")
//	public String logout(Model m, HttpServletRequest request) {
//		System.out.println("------[logout.do]-------------------");
//		String id = request.getParameter("id");
//		Login login = new Login();
//		login = lBiz.select(id);
//		login.setConn(0);
//		lBiz.update(login);		
//		return "logout";
//	}

}