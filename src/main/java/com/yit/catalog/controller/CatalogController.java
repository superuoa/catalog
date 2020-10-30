package com.yit.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yit.catalog.bean.Product;
import com.yit.catalog.repository.ProductDAO;

@RestController
public class CatalogController {

	
	@Resource
    private ProductDAO productDao;
	
	@GetMapping("/getProduct")
    public List<Product> catalog() {
       
        List<Product> list = productDao.getProducts();

		return list ;

    }

	@GetMapping("/getProduct/{id}")
    public Product catalogById(@PathVariable int id) {
       
        Product p = productDao.getProductById(id);

		return p ;

    }
	
	@PostMapping("/save")
    public int create(@RequestBody String json) {
       
		System.out.println(">>>>>>>> Add product json " + json);
		
		Product c = Product.buildJsonToObject(json);

		int s = productDao.save(c);
		System.out.println("result save Cart " + s);
		
		return s;

    }
	
	
	@DeleteMapping("/delete/{id}")
    public Object deleteItem(@PathVariable int id) {
        
		System.out.println(">>>>>>>> Delete product id " + id);
	
		int s = productDao.delete(id);
	
		System.out.println("result delete Cart " + s);
		return s;
		
    }
	
	
	
}
