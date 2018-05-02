package com.hw.population;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hw.frame.Dao;
import com.hw.mapper.PopulationMapper;
import com.hw.vo.Population;


@Repository("populationDao")
public class PopulationDAO implements Dao<Population, String> {
	
	@Autowired
	PopulationMapper mapper;	//얘가 마이바티스 연동하는 거

	@Override
	public void insert(Population t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Population t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Population select(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Population> select() {
		// TODO Auto-generated method stub
		return mapper.selectall();
	}

}
