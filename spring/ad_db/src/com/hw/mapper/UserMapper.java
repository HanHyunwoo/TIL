package com.hw.mapper;
import java.util.List;
import com.hw.vo.User;

public interface UserMapper {
	public void insert(User u);
	public void update(User u);
	public User select(String s);
	public List<User> selectAll();
	public List<User> find();
}
