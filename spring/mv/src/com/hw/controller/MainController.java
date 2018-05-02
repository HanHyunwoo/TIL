package com.hw.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
   Connection conn;

   public MainController() {
      try {
         Class.forName("org.apache.hive.jdbc.HiveDriver");
         conn = DriverManager.getConnection("jdbc:hive2://192.168.111.100:10000/default","root","111111");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   @RequestMapping("/main.do")
   public String main() {
      return "main";
   }

   @RequestMapping("/chart1.do")
   public String chart1(Model m) {
      m.addAttribute("center", "chart1");
      return "main";
   }

   @RequestMapping("/chart2.do")
   public String chart2(Model m) {
      m.addAttribute("center", "chart2");
      return "main";
   }
   
   @RequestMapping("/chart3.do")
   public String chart3(Model m) {
      m.addAttribute("center", "chart3");
      return "main";
   }
   
   @RequestMapping("/chart4.do")
   public String chart4(Model m) {
      m.addAttribute("center", "chart4");
      return "main";
   }
   
   

   @RequestMapping("/chart1impl.do")
   @ResponseBody // data�� output�� �����ڴٴ� �ǹ�
   public void chart1impl(HttpServletResponse res) throws Exception {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT Year, Month, COUNT(*) " + "FROM airline_delay "
            + "WHERE delayYear=2006 " + "AND Month IN (1,2,3,4) " + "AND ArrDelay > 0 " + "GROUP BY Year, Month");
      JSONArray ja = new JSONArray();
      while (rs.next()) {
         JSONArray data = new JSONArray(); // []�ȿ� []�� ����
         data.add(rs.getInt(2) + "��");
         data.add(rs.getInt(3));
         // ["1��", 20000]
         ja.add(data);
      }
      res.setCharacterEncoding("EUC-KR");
      res.setContentType("application/json");
      PrintWriter out = res.getWriter();

      out.print(ja.toJSONString());
      //out.write("[['1',10], ['1',10], ['1',10] ]");
      out.close();

   }
   
   @RequestMapping("/chart2impl.do")
   @ResponseBody // data�� output�� �����ڴٴ� �ǹ�
   public void chart2impl(HttpServletResponse res) throws Exception {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT Year, Month, COUNT(*) " + "FROM airline_delay "
            + "WHERE delayYear=2006 " + "AND Month IN (1,2,3,4) " + "AND ArrDelay > 0 " + "GROUP BY Year, Month");
      JSONArray ja = new JSONArray();
      while (rs.next()) {
         //JSONArray data = new JSONArray(); // []�ȿ� []�� ����
          JSONObject data = new JSONObject(); // []�ȿ� []�� ���� 
    	  
         //{name:'����', y:70},
         data.put("name",rs.getInt(2) + "��");
         data.put("y",rs.getInt(3));
         //data.add(rs.getInt(2));
         //data.add(rs.getInt(3));
         // ["1��", 20000]
         ja.add(data);
      }
      res.setCharacterEncoding("EUC-KR");
      res.setContentType("application/json");
      PrintWriter out = res.getWriter();

      out.print(ja.toJSONString());
      //out.write("[['1',10], ['1',10], ['1',10] ]");
      out.close();
   }
   
   @RequestMapping("/chart3impl.do")
   @ResponseBody // data�� output�� �����ڴٴ� �ǹ�
   public void chart3impl(HttpServletResponse res) throws Exception {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select round(a.totalseoul/b.seoul*100000,1) �����ѹ�����, round(a.totalbusan/b.pusan*100000,1) �λ��ѹ�����, \r\n" + 
      		"       round(a.totaldaegu/b.daegu*100000,1) �뱸�ѹ�����, round(a.totalincheon/b.incheon*100000,1) ��õ�ѹ�����,\r\n" + 
      		"       round(a.totalgwangju/b.gwangju*100000,1) �����ѹ�����, round(a.totaldaejeon/b.daejeon*100000,1) �����ѹ�����,\r\n" + 
      		"       round(a.totalulsan/b.ulsan*100000,1) ����ѹ�����, round(a.totalsaejong/b.saejong*100000,1) �����ѹ�����\r\n" + 
      		"from (select sum(seoul) totalseoul, sum(busan) totalbusan, sum(daegu) totaldaegu, sum(incheon) totalincheon, sum(gwangju) totalgwangju, \r\n" + 
      		"      sum(daejeon) totaldaejeon, sum(ulsan) totalulsan, sum(saejong) totalsaejong, year \r\n" + 
      		"      from criminal \r\n" + 
      		"      where year=2016 group by year) A \r\n" + 
      		"inner join population B \r\n" + 
      		"on a.year=b.year");
      JSONArray ja = new JSONArray();
      
      while (rs.next()) {
          JSONObject data = new JSONObject(); // []�ȿ� []�� ���� 
         data.put("name",rs.getInt(1));
         data.put("y",rs.getInt(3));
         ja.add(data);
      }
      
      res.setCharacterEncoding("EUC-KR");
      res.setContentType("application/json");
      PrintWriter out = res.getWriter();

      out.print(ja.toJSONString());
      out.close();
   }
   
   @RequestMapping("/chart4impl.do")
   @ResponseBody // data�� output�� �����ڴٴ� �ǹ�
   public void chart4impl(HttpServletResponse res) throws Exception {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT Year, Month, COUNT(*) " + "FROM airline_delay "
            + "WHERE delayYear=2006 " + "AND Month IN (1,2,3,4) " + "AND ArrDelay > 0 " + "GROUP BY Year, Month");
      JSONArray ja = new JSONArray();
      while (rs.next()) {
         //JSONArray data = new JSONArray(); // []�ȿ� []�� ����
          JSONObject data = new JSONObject(); // []�ȿ� []�� ���� 
    	  
         //{name:'����', y:70},
         data.put("name",rs.getInt(2) + "��");
         data.put("y",rs.getInt(3));
         //data.add(rs.getInt(2));
         //data.add(rs.getInt(3));
         // ["1��", 20000]
         ja.add(data);
      }
      res.setCharacterEncoding("EUC-KR");
      res.setContentType("application/json");
      PrintWriter out = res.getWriter();

      out.print(ja.toJSONString());
      //out.write("[['1',10], ['1',10], ['1',10] ]");
      out.close();

   }
   

}