package com.eframe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
