package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.model.Bill;

@Service
public class BillService {

	@Autowired
	public BillRepository billRepository;
	
	public List<Bill> findAll() {
		return billRepository.findAll();
	}
	
	public Bill save(Bill bill) {
		return billRepository.save(bill);
	}
}
