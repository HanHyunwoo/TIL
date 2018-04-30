package com.hw.mapper;

import java.util.List;

import com.hw.vo.Crime;

public interface CrimeMapper {
	public List<Crime> selectoccur(String s);
	public List<Crime> selectcatch(String s);
}
