package com.yit.catalog.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yit.catalog.bean.Product;
import com.yit.catalog.mapper.ProductRowMapper;


@Repository
public class ProductDAOForTest {
	
	@Autowired
	private JdbcTemplate template;

	
	public List<Product> getProducts() {
		String sql = "select * from product";
       
		List<Product> mm = this.template.query(sql, new ProductRowMapper());
		
		return mm;
	}

	public Product save(Product product) {
		
		String sql = "insert into product(description,name,price,warranty) "
        			+ "values(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
        
        this.template.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getDescription());
            statement.setString(2, product.getName());
            statement.setInt(3, product.getPrice());
            statement.setInt(4, product.getWarranty());
            return statement;
        }, keyHolder);
        
        Integer newProductId = keyHolder.getKey().intValue();
        product.setId(newProductId);
		
		return product;

	}

	public Product getProductById(int id) {
		
		String sql = "select * from product where id=?";
		
		Object[] params = new Object[]{id};
        
		Product mm = template.queryForObject(sql, params, new ProductRowMapper());
		
		return mm;
	}

	
	
}
