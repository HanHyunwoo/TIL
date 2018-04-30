package com.hw.mapper;

import java.util.List;

import com.hw.vo.Population;

public interface PopulationMapper {
	public Population select(String id);
	public List<Population> selectall();
}
