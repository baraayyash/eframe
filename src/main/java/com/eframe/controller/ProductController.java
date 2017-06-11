package com.eframe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.model.Product;
import com.eframe.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	/**
	 * Get All products
	 * 
	 * @return List<Product>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "api/products")
    public ResponseEntity<List<Product>> test() {
		return ResponseEntity.ok(productService.findAll());
    }
}
