package com.yit.catalog.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yit.catalog.bean.Product;
import com.yit.catalog.mapper.ProductRowMapper;

@Repository
public class ProductDAOImpl implements ProductDAO{

	NamedParameterJdbcTemplate template;

	public ProductDAOImpl(NamedParameterJdbcTemplate template) {  
        this.template = template;  
	}
	
	
	@Override
	public List<Product> getProducts() {
		MapSqlParameterSource param = new MapSqlParameterSource();
        
		
		List<Product> mm = template.query("select * from product", param,new ProductRowMapper());
		
		return mm;
	}

	
	
}
