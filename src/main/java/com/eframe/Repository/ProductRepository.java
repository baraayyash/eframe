package com.eframe.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.eframe.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, String> {
}
