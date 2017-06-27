package com.eframe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.model.Product;
import com.eframe.service.ProductService;
import com.eframe.utils.ListRequest;
import com.eframe.utils.ListResponse;
import com.eframe.utils.OffsetBasedPageRequest;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	/**
	 * Get all products
	 * 
	 * @return List<Product>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "api/products")
	public ResponseEntity<ListResponse> getAll(ListRequest request) {
		Pageable pageable = new OffsetBasedPageRequest(request.getStart(), request.getLength());
		return ResponseEntity.ok(new ListResponse(productService.findAll(pageable), request.getDraw()));
	}

	/**
	 * Get one product
	 * 
	 * @param id
	 * @return Product
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "api/products/{id}")
	public ResponseEntity<Product> GetOne(@PathVariable("id") String id) {
		return ResponseEntity.ok(productService.findOne(id));
	}
	
	/**
	 * Create product
	 * 
	 * @param Product
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "api/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}
	
	/**
	 * Update existing product
	 * 
	 * @param Product
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "api/products/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> update(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}
}
