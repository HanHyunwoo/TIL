package com.hw.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.UserMapper;
import com.hw.vo.User;

@Repository("userDao")
public class UserDao implements Dao<User, String> {

	@Autowired
	UserMapper mapper;

	@Override
	public User select(String s) {
		// TODO Auto-generated method stub
		return mapper.select(s);
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}


	@Override
	public void update(User u) {
		mapper.update(u);
		
	}
	
	@Override
	public void insert(User t) {
		mapper.insert(t);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> find() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
