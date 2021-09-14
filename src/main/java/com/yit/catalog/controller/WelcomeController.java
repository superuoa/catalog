package com.yit.catalog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.yit.catalog.bean.Cart;
import com.yit.catalog.bean.Product;
import com.yit.catalog.bean.User;

@RestController
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping( value = "/", method = RequestMethod.GET)
	public List<Product> welcome(Map<String, Object> model) {
		List<Product> list = new ArrayList<Product>();
		
		Product p = new Product();
		p.setId(1);
		p.setDescription("ทดสอบภาษาไทย");
		p.setInstock(1);
		p.setName("Notebook DELL");
		p.setInstock(10);
		
		Product p2 = new Product();
		p2.setId(2);
		p2.setDescription("Smart TV TU7000");
		p2.setName("SAMSUNG Crystal UHD 4K");
		p2.setInstock(5);
		
		Product p3 = new Product();
		p3.setId(3);
		p3.setDescription("14976 BTU, Inverter");
		p3.setName("HAIER Air Conditioning");
		p3.setInstock(2);
		
		list.add(p);
		list.add(p2);
		list.add(p3);
		
		
		return list;
	}
	
	@RequestMapping( value = "/getProductById/{id}", method = RequestMethod.GET)
    public Product getById(@PathVariable int id) {
		Product p = new Product();
		p.setId(1);
		p.setDescription("RAM: 4, CPU: Intel Core i7-10750H");
		p.setInstock(1);
		p.setName("Notebook DELL");
		p.setInstock(10);
		return p;
	}

	
}
