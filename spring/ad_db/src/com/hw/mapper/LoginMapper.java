package com.hw.mapper;
import java.util.List;

import com.hw.vo.Login;

public interface LoginMapper {	
	public void update(Login u);
	public void insert(Login u);
	public Login select(String s);
	public List<Login> selectall();
	public List<Login> find();
}
