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
public class PopulationController {

	@Resource(name = "populationBiz")
	Biz<Population, String> biz;
	@Resource(name = "crimeBiz")
	Biz<Crime, String> cbiz;

	@RequestMapping("/populationlist.do")
	@ResponseBody
	public void list(HttpServletResponse res) throws Exception {

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");

		List<Population> list = biz.get();
		PrintWriter out = res.getWriter();
		JSONArray ja = new JSONArray();

		// System.out.println(list.toString());
		for (Population d : list) {
			JSONObject data = new JSONObject();
			data.put("name", d.getDong());
			data.put("y", d.getOne());
			data.put("drilldown", d.getGu());
			ja.add(data);
		}

		out.print(ja.toJSONString());
		out.close();
		System.out.println("data¿¡¼­ µé¾î¿È");
		System.out.println(ja.toString().toString());
		// return "main";
	}

	@RequestMapping("/populationlist2.do")
	@ResponseBody
	public void list2(HttpServletResponse res) throws Exception {

		res.setCharacterEncoding("EUC-KR");
		res.setContentType("application/json");

		List<Population> list = biz.get();
		PrintWriter out = res.getWriter();
		JSONArray ja = new JSONArray();
		JSONArray dataSet = new JSONArray();

		for (Population d : list) {
			JSONObject data2 = new JSONObject();
			// data2.put("data", list1.toString());

			List<Crime> listoccur = cbiz.getoccur(d.getGu());
			List<Crime> listcatch = cbiz.getcatch(d.getGu());
			JSONArray ja1 = new JSONArray();
			for (int i = 0; i < 5; i++) {
				JSONObject crDa = new JSONObject();
				crDa.put("name", listoccur.get(i).getCriminal());
				crDa.put("y", listcatch.get(i).getOccurnum()*100 / listoccur.get(i).getOccurnum());
				ja1.add(crDa);

			}
			data2.put("data", ja1);
			data2.put("name", d.getDong());
			data2.put("id", d.getGu());

			// data2.put("data", value)
			ja.add(data2);
		}

		System.out.println("data2¿¡¼­ µé¾î¿È");
		System.out.println(ja.toString().toString());
		out.print(ja.toJSONString());
		out.close();

		// return "main";
	}

	@RequestMapping("/populationadd.do")
	public String add(Model m) {
		m.addAttribute("center", "population/add");
		return "main";
	}

	@RequestMapping("/populationaddimpl.do")
	public String addimpl(Model m, Population u) {
		System.out.println("addimpl:" + m);
		// DBï¿½ï¿½ ï¿½Ô·ï¿½ ï¿½Ñ´ï¿½.
		biz.register(u);
		m.addAttribute("center", "population/addok");
		return "main";
	}

	@RequestMapping("/populationdetail.do")
	public String detail(Model m, @RequestParam(value = "id") String userid) {
		System.out.println(userid);

		Population population = biz.get(userid);
		m.addAttribute("populationselect", population);
		m.addAttribute("center", "population/detail");
		return "main";
	}

	@RequestMapping("/populationupdate.do")
	public String update(Model m, Population u) {
		biz.modify(u);
		m.addAttribute("center", "population/modifyok");
		return "main";
	}

	@RequestMapping("/populationdelete.do")
	public String delete(Model m, @RequestParam(value = "id") String userid) {
		biz.remove(userid);
		m.addAttribute("center", "population/deleteok");
		return "main";
	}
}
