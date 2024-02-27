package com.business.pinu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.pinu.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	Product findByProductName(String productName);
	
	

}
