package com.yit.catalog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yit.catalog.bean.Product;
import com.yit.catalog.repository.ProductDAO;

@RestController
public class CatalogController {

	
	@Resource
    private ProductDAO productDao;
	
	@RequestMapping("/")
    public List<Product> catalog() {
       
        List<Product> list = productDao.getProducts();

		return list ;
        
    }
	
}
