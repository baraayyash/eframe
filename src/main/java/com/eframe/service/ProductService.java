package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.Repository.ProductRepository;
import com.eframe.model.Product;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;

	public Product findOne(String id) {
		return productRepository.findOne(id);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product save(Product prodcut) {
		return productRepository.save(prodcut);
	}
}
