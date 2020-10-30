package com.yit.catalog.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yit.catalog.bean.Product;

@Repository
public interface ProductDAO {

	List<Product> getProducts();
	Product getProductById(int id);
	
	int save(Product product);
	int delete(int id);
}
