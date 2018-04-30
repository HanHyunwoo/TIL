package com.hw.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hw.frame.Biz;
import com.hw.vo.Product;
import com.hw.vo.User;

@Controller
public class ProductController {
	
	@Resource(name="productBiz")
	Biz<Product,Integer> biz;
	
	@RequestMapping("/productlist.do")
	public String list(Model m) {
		// DB에서 데이터를 조회 한다.
		/*new ArrayList<>();
		list.add(new Product(100, "k1", 1000, new Date(2018, 03, 06), "m1.jpg"));
		list.add(new Product(200, "k2", 2000, new Date(2018, 03, 06), "m2.jpg"));
		list.add(new Product(300, "k3", 3000, new Date(2018, 03, 06), "m3.jpg"));
		list.add(new Product(400, "k4", 4000, new Date(2018, 03, 06), "m4.jpg"));
		list.add(new Product(500, "k5", 5000, new Date(2018, 03, 06), "m5.jpg"));
		// ------------------------\
*/		
		List<Product> list = biz.get();
		m.addAttribute("productlist", list);
		m.addAttribute("center", "product/list");
		return "main";
	}
	                  
	@RequestMapping("/productmodify.do")
	public String modify(Model m, Integer id) {
		m.addAttribute("product", biz.get(id));
		m.addAttribute("center","product/modify");
		return "main";
	}
	
	@RequestMapping("/productadd.do")
	public String add(Model m) {
		m.addAttribute("center", "product/add");
		return "main";
	}
	
	@RequestMapping("/productupdate.do")
	public String update(Model m, Product p) {//mf
		
		
		
		// 안하면 null 로 오류 뜸.
		
		System.out.println(p.getImgname());
		
		// C:\\spring\\mv\\web\\img
		if (!p.getMf().isEmpty()) {
			MultipartFile mf = p.getMf();
			String imgName = mf.getOriginalFilename();
			p.setImgname(imgName);	
			byte[] data = null;
			FileOutputStream fo = null;
			try {
				data = mf.getBytes();
				fo = 
				new FileOutputStream("C:\\spring\\mv\\web\\img\\"+imgName);
				fo.write(data);
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				try {
					fo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			
		}
		
		
		
		biz.modify(p);
		return "main";
	}
	
	@RequestMapping("/productdelete.do")
	public String delete(Model m, Product p) {
		biz.remove(p.getId());
		return "main";
	}
	
	@RequestMapping("/productaddimpl.do")
	public String addimpl(Model m,Product p) {
		System.out.println(p);
		MultipartFile mf = p.getMf();
		String imgName = mf.getOriginalFilename();
		
		p.setImgname(imgName);	// 안하면 null 로 오류 뜸.
		
		System.out.println(imgName);
		
		// C:\\spring\\mv\\web\\img
		
		byte[] data = null;
		FileOutputStream fo = null;
		try {
			data = mf.getBytes();
			fo = 
			new FileOutputStream("C:\\spring\\mv\\web\\img\\"+imgName);
			fo.write(data);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// DB에 입력
		biz.register(p);
		m.addAttribute("imgname",imgName);
		m.addAttribute("center", "product/addok");
		return "main";
	}
}




