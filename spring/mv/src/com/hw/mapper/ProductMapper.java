package com.hw.mapper;

import java.util.List;

import com.hw.vo.Product;

public interface ProductMapper {
	public void insert(Product obj);	/*���� ����Ȱ���? */
	public void delete(Integer id);
	public void update(Product obj);
	public Product select(Integer id);
	public List<Product> selectall();
}
