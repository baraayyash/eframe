package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
	
	List<Invoice> findAll();
}
