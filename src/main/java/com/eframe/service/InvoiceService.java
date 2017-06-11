package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.Repository.InvoiceRepository;
import com.eframe.model.Invoice;

@Service
public class InvoiceService {

	@Autowired
	public InvoiceRepository invoiceRepository;
	
	public List<Invoice> findAll() {
		return invoiceRepository.findAll();
	}
	
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
}
