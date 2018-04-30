package com.hw.frame;

import java.util.List;

public interface Biz<T, S> {
	public T select(S s);
	public List<T> selectAll();
	public void insert(T t);
	public void update(T t);
	public List<T> find();
}
