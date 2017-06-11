package com.eframe.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.service.InvoiceService;
import com.eframe.service.ClientService;
import com.eframe.model.Invoice;
import com.eframe.model.Client;
import com.eframe.model.Debit;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@Autowired
	InvoiceService invoiceService;

	/**
	 *  test
	 * test
	 * @param test
	 * @param test
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "api/clients")
    public ResponseEntity<List<Client>> test() {
		
		Client client = new Client();
		
		client.setName("bara");
		client.setPhone("0599437784");
		client = clientService.save(client);
		
		Debit bill = new Debit("test");
		bill.setClient(client);
		bill = invoiceService.save(bill);

		Set<Invoice> bills = new HashSet<Invoice>(); 
		bills.add(bill);
		
		client.setBills(bills);
		
		clientService.save(client);
		
		return ResponseEntity.ok(clientService.findAll());
    }

}
