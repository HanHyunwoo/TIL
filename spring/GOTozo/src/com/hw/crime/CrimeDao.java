package com.hw.crime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.CrimeMapper;
import com.hw.vo.Crime;

@Repository("crimeDao")
public class CrimeDao implements Dao<Crime, String> {

	@Autowired
	CrimeMapper mapper;

	@Override
	public void insert(Crime t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Crime t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Crime select(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crime> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Crime> selectoccur(String s) {
		// TODO Auto-generated method stub
		return mapper.selectoccur(s);
	}

	@Override
	public List<Crime> selectcatch(String s) {
		// TODO Auto-generated method stub
		return mapper.selectcatch(s);
	}

}
