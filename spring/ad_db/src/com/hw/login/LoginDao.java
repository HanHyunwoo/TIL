package com.hw.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.LoginMapper;
import com.hw.vo.Login;

@Repository("loginDao")
public class LoginDao implements Dao<Login, String> {

	@Autowired
	LoginMapper mapper;

	@Override
	public Login select(String s) {
		// TODO Auto-generated method stub
		return mapper.select(s);
	}

	@Override
	public List<Login> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectall();
	}

	@Override
	public void insert(Login t) {
		mapper.insert(t);
		
	}

	@Override
	public void update(Login t) {
		mapper.update(t);
		
	}

	@Override
	public List<Login> find() {
		// TODO Auto-generated method stub
		return mapper.find();
	}
	
	
}
