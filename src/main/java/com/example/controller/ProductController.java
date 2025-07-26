package com.example.controller;
import com.example.model.*;
import com.example.service.*;
import com.example.repository.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product/add")
	private Object postProduct(@RequestBody Product product) {
		Object  product_ = productService.postProduct(product);
		if(product_ == null) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		}
		
	}
	

	@GetMapping("/product/get")
	private Object getProduct() {
		Object products = new ArrayList<>();
		products = productService.getProduct();
		 if (((ArrayList<Object>) products).isEmpty()) {
	            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	        } else {
	       
	            return new ResponseEntity<>(products, HttpStatus.OK);
	        }
	
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product){
		return productService.updateProduct(id, product);
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProductById(@PathVariable int id){
		return productService.deleteProductByID(id);
	}
	@GetMapping("/product/vendor")
	public ResponseEntity<Object> getSimilarVendor(@RequestParam("value") String value){
		return productService.getSimilorVendor(value);
	}
	

}
