package com.eframe.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.service.BillService;
import com.eframe.service.ClientService;
import com.eframe.model.Bill;
import com.eframe.model.Client;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientService;
	@Autowired
	BillService billService;

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
		
		Bill bill = new Bill();
		bill.setClient(client);
		bill = billService.save(bill);

		Set<Bill> bills = new HashSet<Bill>(); 
		bills.add(bill);
		
		client.setBills(bills);
		
		clientService.save(client);
		
		return ResponseEntity.ok(clientService.findAll());
    }

}
