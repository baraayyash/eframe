package com.eframe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.model.Client;
import com.eframe.model.Debit;
import com.eframe.service.ClientService;

@RestController
public class NotificationController {
	
	@Autowired
	ClientService clientService;
	
	/**
	 * Get all debits
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/test")
	public ResponseEntity<String> getAllDebits() {
		while(true) {
			
			Client c = clientService.findOne("cli102");
			
		  if (c != null ) return ResponseEntity.ok("done");
			  
	           try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		}
		
	}
	
	/**
	 * Get all debits
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/test1")
	public ResponseEntity<String> test() {

		for(int i = 0; i<3 ; i++) {
			Client client = new Client();
			clientService.save(client);
		}
		
		return ResponseEntity.ok("test");
	}

}
