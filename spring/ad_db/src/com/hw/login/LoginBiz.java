package com.hw.login;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Login;

@Service("loginBiz")
public class LoginBiz implements Biz<Login, String>{

	@Resource(name="loginDao")
	Dao<Login, String> dao;

	@Override
	public Login select(String s) {
		// TODO Auto-generated method stub
		return dao.select(s);
	}

	@Override
	public List<Login> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public void insert(Login t) {
		dao.insert(t);
		
	}

	@Override
	public void update(Login t) {
		dao.update(t);
		
	}

	@Override
	public List<Login> find() {
		return dao.find();
	}
	
	
	
}
