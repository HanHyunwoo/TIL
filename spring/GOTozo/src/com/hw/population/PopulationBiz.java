package com.hw.population;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hw.frame.Biz;
import com.hw.frame.Dao;
import com.hw.vo.Population;

@Service("populationBiz")
public class PopulationBiz implements Biz<Population, String> {

	@Resource(name="populationDao")
	Dao<Population, String> dao;


	@Override
	public List<Population> get() {
		// TODO Auto-generated method stub
		return dao.select();
	}


	@Override
	public void register(Population t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remove(String s) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modify(Population t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Population get(String s) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Population> getoccur(String s) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Population> getcatch(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
