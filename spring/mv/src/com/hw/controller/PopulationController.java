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
import com.hw.vo.Population;

@Controller
public class PopulationController {
      
   @Resource(name="populationBiz")
   Biz<Population,String> biz;
   
   @RequestMapping("/populationlist.do")
   @ResponseBody
   public void list(HttpServletResponse res) throws Exception {
      
         res.setCharacterEncoding("EUC-KR");
         res.setContentType("application/json");

         List<Population> list = biz.get();
         PrintWriter out = res.getWriter();
         JSONArray ja = new JSONArray();

         System.out.println(list.toString());
         for(Population d:list) {
            JSONObject data = new JSONObject();
            data.put("name",d.getDong());
            data.put("y", d.getOne());
            ja.add(data);
            System.out.println(d.toString());
         }
         
         out.print(ja.toJSONString());
         out.close();
         
       // return "main";
   }
   
   @RequestMapping("/populationdetail.do")
   public String detail(Model m, @RequestParam(value="id")String populationid) {
      System.out.println(populationid);
      Population population = biz.get(populationid);
      m.addAttribute("userselect", population);
      m.addAttribute("center", "user/detail");
      return "main";
   }
   
}


