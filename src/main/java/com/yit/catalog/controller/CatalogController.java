package com.yit.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yit.catalog.bean.Product;

@RestController
public class CatalogController {

	@RequestMapping("/")
    public List<Product> catalog() {
       
        List<Product> list = new ArrayList<Product>();
        
        Product p1 = new Product();
        p1.setDescription("aaa");
        p1.setId(1);
        p1.setName("test1");
        p1.setPrice(200);
        
        Product p2 = new Product();
        p2.setDescription("bbb");
        p2.setId(2);
        p2.setName("test2");
        p2.setPrice(300);
        
        list.add(p1);
        list.add(p2);
        
        
        
        
        
		return list ;
        
    }
	
}
