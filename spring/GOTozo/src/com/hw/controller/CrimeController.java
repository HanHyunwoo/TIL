package com.hw.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hw.frame.Biz;
import com.hw.vo.Crime;
import com.hw.vo.Population;

@Controller
public class CrimeController {
      
   @Resource(name="crimeBiz")
   Biz<Crime, String> biz;
   
   @RequestMapping("/crimelist.do")
   @ResponseBody
   public void list(HttpServletResponse res, String guName) throws Exception {	  
	   
	      res.setCharacterEncoding("EUC-KR");
	      res.setContentType("application/json");
	      
	      guName = "Á¾·Î";
	      List<Crime> listoccur = biz.getoccur(guName);	      
	      List<Crime> listcatch = biz.getcatch(guName);
	      PrintWriter out = res.getWriter();
	      JSONArray ja = new JSONArray();	
	      
	      for(int i=0;i<5;i++) {
	    	 JSONObject data = new JSONObject();
	    	 data.put("name",listoccur.get(i).getCriminal());
	         data.put("y", listoccur.get(i).getOccurnum());
	         data.put("rate", listcatch.get(i).getOccurnum()/listoccur.get(i).getOccurnum());
	         ja.add(data);
	      
	      }	 
	      System.out.println(ja.toString());
	      ja.toString();
	      out.print(ja.toJSONString());
	      out.close();
	      
	    // return "main";
   }
   
}


