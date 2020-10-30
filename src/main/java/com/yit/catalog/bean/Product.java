package com.yit.catalog.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.gson.Gson;


@Entity
public class Product {

	@Id
	@GeneratedValue
	int id;
	String name;
	String description;
	int price;
	int instock;
	int warranty;

	public Product() {
		super();
	}
	
	
	public Product(int id, String name, String description, int price, int instock, int warranty) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.instock = instock;
		this.warranty = warranty;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getInstock() {
		return instock;
	}
	public void setInstock(int instock) {
		this.instock = instock;
	}
	public int getWarranty() {
		return warranty;
	}
	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	public static Product create(String name, String desc, int price,int warranty) {
		Product p = new Product();
        p.setName(name);
        p.setDescription(desc);
        p.setPrice(price);
        p.setWarranty(warranty);
        
        return p;
    }
	
	public static Product buildJsonToObject(String json){

		Gson gson = new Gson();

		Product c = gson.fromJson(json, Product.class);
		
		
		return c;
		
	}
	
}
