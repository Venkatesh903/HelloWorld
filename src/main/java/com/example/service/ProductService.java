package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.model.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public Object postProduct(Product product) {
		
		return productRepository.save(product);	
	}
	public Object getProduct() {
		List<Product> product  = new ArrayList<>();
		productRepository.findAll().forEach(product::add);
		
		return product;
	}
	
	public ResponseEntity<Object> updateProduct(int id, Product product){
	Optional<Product> prod = productRepository.findById(id);
	if(prod.isPresent()) {
		Product prodd = prod.get();
		prodd.setPrice(product.getPrice());
		prodd.setStock(product.getStock());
		return new ResponseEntity<Object>(productRepository.save(prodd),HttpStatus.OK);
		
	}
	else {
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

	}
	public ResponseEntity<Object> deleteProductByID(int id){
		Optional<Product> prod = productRepository.findById(id);
		if(prod.isPresent()) {
			productRepository.deleteById(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}

	
	}
	public ResponseEntity<Object> getSimilorVendor(String value){
	
		List<Product> product = productRepository.findByVendor(value);
		System.out.println(product);
		if(product == null) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		}
	}
	


}
