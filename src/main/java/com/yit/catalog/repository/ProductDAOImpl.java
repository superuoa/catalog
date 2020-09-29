package com.yit.catalog.repository;

import java.util.Date;
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


	@Override
	public int save(Product product) {
		
		MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("description",product.getDescription());
        param.addValue("name", product.getName());
        param.addValue("price", product.getPrice());
        param.addValue("warranty", product.getWarranty());
        
        int mm = template.update("insert into product(description,name,price,warranty) "
        		+ "values(:description,:name,:price,:warranty)", param);
		
		return mm;

	}


	@Override
	public Product getProductById(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id",id);
		
		Product mm = template.queryForObject(
				"select * from product where id=:id", param, new ProductRowMapper());
		
		return mm;
	}

	
	
}
