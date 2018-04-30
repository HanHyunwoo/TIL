package com.hw.controller;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.frame.Biz;
import com.hw.vo.Crime;
import com.hw.vo.Population;

@Controller
public class RController {
      
	   RConnection rconn = null;
 
	  public RController() {
		  
			try {
				rconn = new RConnection();
				System.out.println("OK!!");
			} catch (RserveException e) {
				System.out.println("R Connection Error");
			}
			System.out.println();
		  
	  }
	  
	  
	  @RequestMapping("/r.do")
	   @ResponseBody // data를 output로 보내겠다는 의미
	   public void r(HttpServletResponse res) throws Exception {
	    
		
		  try {
				rconn.setStringEncoding("utf8");
				rconn.eval("source('C:/Users/student/Documents/TIL/R/day08/r10.R',encoding='UTF-8')");
				RList list = 
						rconn.eval("food()").asList();
				System.out.println(list.size());
				
				int good[] = 
						list.at("good").asIntegers(); //컬럼명칭을 통해서 가져온다.
				
				int bad[] = 
						list.at("bad").asIntegers();
				
				int snow[] = 
						list.at("snow").asIntegers();
				

				String[] food_type = {"족발보쌈","중국음식","치킨","피자"};
				JSONArray ja = new JSONArray();
				
				for(int i=0; i<good.length; i++) {
					
					JSONObject jo = new JSONObject();
					jo.put("name", food_type[i]);
					
					JSONArray ja2 = new JSONArray();
					ja2.add(good[i]);
					ja2.add(bad[i]);
					ja2.add(snow[i]);
					
					jo.put("data", ja2);
					
					ja.add(jo);
	
				}
				
				  res.setCharacterEncoding("EUC-KR");
			      res.setContentType("application/json");
			      PrintWriter out = res.getWriter();

			      out.print(ja.toJSONString());
			      out.close();

					
			} catch (Exception e) {
				e.printStackTrace();
			}
		  
		  
	   }
	   
	  
	  
   
}


