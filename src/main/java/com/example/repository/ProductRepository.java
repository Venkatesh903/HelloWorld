package com.example.repository;

import java.util.Optional;
import java.util.List;
import com.example.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByVendor(String value);
}
