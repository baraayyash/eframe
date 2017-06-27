package com.eframe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	public Product save(Product prodcut) {
		return productRepository.save(prodcut);
	}
}
