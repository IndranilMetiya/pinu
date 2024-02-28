package com.business.pinu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.business.pinu.DTO.ProductRequest;
import com.business.pinu.DTO.StockDTO;
import com.business.pinu.repository.CatagoryRepo;
import com.business.pinu.repository.ProductRepo;
import com.business.pinu.repository.PropertyRepo;
import com.business.pinu.repository.StockRepo;
import com.business.pinu.service.DaoService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	DaoService daoService;
	
	@Autowired
	CatagoryRepo catagoryRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	PropertyRepo propertyRepo;
	
	@Autowired
	StockRepo stockRepo;
	
	   @PostMapping("/addCatagory")
	    public ResponseEntity<String> addCatagory(@RequestBody String catagoryName) {
	    String msg=    daoService.addcatagory(catagoryName);
	        return ResponseEntity.ok(msg);
	}
	   
	   @PostMapping("/addProductWithProprty")
	    public ResponseEntity<String> addProductWithProprty(@RequestBody ProductRequest productRequest) {
	        daoService.addProductWithProperty(productRequest);
	        return ResponseEntity.ok("Product added successfully with given properties");
	}
//	   @PostMapping("/addProductWithProperty")
//	    public ResponseEntity<String> addProductWithProperty(@RequestBody ProductRequest productRequest) {
//	        Product existingProduct = productRepo.findByProductName(productRequest.getProductName());
//	        if (existingProduct != null) {
//	            // Product already exists, associate it with the Property
//	            daoService.addProductWithProperty(productRequest);
//	            return ResponseEntity.ok("Product added successfully with given properties");
//	        } else {
//	            // Product doesn't exist, save it first, then associate it with the Property
//	            Product newProduct = new Product();
//	            newProduct.setProductName(productRequest.getProductName());
//	            // Set other properties of the product
//	            productRepo.save(newProduct);
//
//	            daoService.addProductWithProperty(productRequest);
//	            return ResponseEntity.ok("Product added successfully with given properties");
//	        }
//	    }
	   
	   
	   @GetMapping("/getAllStock")
	    public ResponseEntity<List<StockDTO>> getAllStock() {
		   List<StockDTO> stockDTOs  =  daoService.getAllStockDetails();
	        return ResponseEntity.ok(stockDTOs);
	}
	   
	   
	}




