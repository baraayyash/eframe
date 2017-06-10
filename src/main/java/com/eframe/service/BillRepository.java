package com.eframe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Bill;

public interface BillRepository extends JpaRepository<Bill, String> {
	
	List<Bill> findAll();
}

