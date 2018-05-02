package com.hw.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hw.vo.Product;

@Controller
public class ProductController {
		
	@RequestMapping("/productlist.do")
	public String list(Model m) {
		//DB에 데이터를 조회한다.
		ArrayList<Object> list = new ArrayList<>();
		list.add(new Product(100, "test1", 1000, new Date(2018, 03, 06), "picture.jpg"));
		list.add(new Product(200, "test2", 2000, new Date(2018, 03, 06), "p1.jpg"));
		list.add(new Product(300, "test3", 3000, new Date(2018, 03, 06), "p2.jpg"));
		list.add(new Product(400, "test4", 4000, new Date(2018, 03, 06), "m1.jpg"));
		list.add(new Product(500, "test5", 5000, new Date(2018, 03, 06), "m2.jpg"));
		//-----------------
		m.addAttribute("productlist", list);
		m.addAttribute("center", "product/list");
		return "main";
	}
	
	@RequestMapping("/productadd.do")
	public String add(Model m) {
		//View를 제외한 Model을 보낼 수 있음
		m.addAttribute("center", "product/add");
		return "main";
	}
	
	@RequestMapping("/productaddimpl.do")
	public String addimpl(Model m, Product p){
		System.out.println(p);
		MultipartFile mf = p.getMf();
		String imgName = mf.getOriginalFilename();
		System.out.println(imgName);
		FileOutputStream fo = null;
		byte[] data = null;
		try {
			data = mf.getBytes();
			fo = new FileOutputStream("C:\\spring\\mv\\web\\img\\"+imgName);
			fo.write(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				if(fo != null)
					fo.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
		// C:\\spring\\mv\\web\\img
		
		
		
		
		//DB에 입력
		m.addAttribute("imgname", "imgName");
		m.addAttribute("center", "product/addok");
		return "main";
	}
}