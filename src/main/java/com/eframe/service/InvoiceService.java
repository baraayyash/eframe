package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.Repository.CridetRepository;
import com.eframe.Repository.DebitRepository;
import com.eframe.model.Cridet;
import com.eframe.model.Debit;

@Service
public class InvoiceService {

	@Autowired
	public CridetRepository cridetRepository;

	@Autowired
	public DebitRepository debitRepository;

	public List<Debit> getAllDebits() {
		return debitRepository.findAll();
	}

	public Debit save(Debit debit) {
		return debitRepository.save(debit);
	}

	public Debit findDebit(String id) {
		return debitRepository.findOne(id);
	}

	public List<Cridet> getAllCridets() {
		return cridetRepository.findAll();
	}

	public Cridet save(Cridet cridet) {
		return cridetRepository.save(cridet);
	}

	public Cridet findCridet(String id) {
		return cridetRepository.findOne(id);
	}
}
