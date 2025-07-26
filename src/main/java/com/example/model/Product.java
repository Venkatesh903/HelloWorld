package com.example.model;
import jakarta.persistence.*;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private String vendor;
	private int price;
	private int stock;
	private String currency;
	
	@Column(unique=true)
	private String sku;
	public String getSku() {
		return this.sku;
	}
	
	private String image_url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Product() {
		
	}
	public Product(String name, String description, String vendor, int price, int stock,String currency,String image_url, String sku) {
		this.name = name;
		this.description = description;
		this.vendor = vendor;
		this.price = price;
		this.stock = stock;
		this.currency = currency;	
		this.image_url = image_url;
		this.sku = sku;
		
	}
	public Product(int id, String name, String description, String vendor, int price, int stock,String currency, String image_url,String sku) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.vendor = vendor;
		this.price = price;
		this.stock = stock;
		this.currency = currency;
		this.image_url = image_url;
		this.sku = sku;
		
	}
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
}
