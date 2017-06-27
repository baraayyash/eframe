package com.eframe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eframe.Repository.CridetRepository;
import com.eframe.Repository.DebitRepository;
import com.eframe.model.Client;
import com.eframe.model.Cridet;
import com.eframe.model.Debit;

@Service
public class InvoiceService {

	@Autowired
	public CridetRepository cridetRepository;

	@Autowired
	public DebitRepository debitRepository;
	
	@Autowired
	public ClientService clientService;

	public Page<Debit> getAllDebits(Pageable pageable) {
		return debitRepository.findAll(pageable);
	}

	public Debit save(Debit debit) {
		Client client = clientService.findOne(debit.getClient().getClientId());
		debit.setClient(client);
		client.getInvoices().add(debit);
		client = clientService.save(client);
		return (Debit) client.getInvoices().get(client.getInvoices().size() - 1);
	}

	public Debit findDebit(String id) {
		return debitRepository.findOne(id);
	}

	public Page<Cridet> getAllCridets(Pageable pageable) {
		return cridetRepository.findAll(pageable);
	}

	public Cridet save(Cridet cridet) {
		Client client = clientService.findOne(cridet.getClient().getClientId());
		cridet.setClient(client);
		client.getInvoices().add(cridet);
		client = clientService.save(client);
		return (Cridet) client.getInvoices().get(client.getInvoices().size() - 1);
	}

	public Cridet findCridet(String id) {
		return cridetRepository.findOne(id);
	}
}
