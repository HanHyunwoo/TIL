package com.hw.user;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.User;

@Service("userBiz")
public class UserBiz implements Biz<User, String>{

	@Resource(name="userDao") 
	Dao<User, String> dao;

	@Override
	public User select(String s) {
		// TODO Auto-generated method stub
		return dao.select(s);
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();	
	}

	@Override
	public void insert(User t) {
		dao.insert(t);
		
	}

	@Override
	public void update(User t) {
		dao.update(t);
		
	}

	@Override
	public List<User> find() {
		// TODO Auto-generated method stub
		return null;
	}

}
