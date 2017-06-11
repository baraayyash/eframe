package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

	List<Product> findAll();
}
