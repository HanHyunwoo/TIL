package com.hw.crime;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Crime;

@Service("crimeBiz")
public class CrimeBiz implements Biz<Crime, String> {

	@Resource(name="crimeDao")
	Dao<Crime, String> dao;

	@Override
	public void register(Crime t) {
	}

	@Override
	public void remove(String s) {
	}

	@Override
	public void modify(Crime t) {	
	}

	@Override
	public Crime get(String s) {
		return null;
	}

	@Override
	public List<Crime> get() {
		return null;
	}

	@Override
	public List<Crime> getoccur(String s) {
		return dao.selectoccur(s);
	}

	@Override
	public List<Crime> getcatch(String s) {
		return dao.selectcatch(s);
	}
}
