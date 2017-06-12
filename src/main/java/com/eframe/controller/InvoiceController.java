package com.eframe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.model.Cridet;
import com.eframe.model.Debit;
import com.eframe.service.InvoiceService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	/**
	 * Get all debits
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/api/debits")
	public ResponseEntity<List<Debit>> getAllDebits() {
		return new ResponseEntity<List<Debit>>(invoiceService.getAllDebits(),HttpStatus.OK);
	}
	
	/**
	 * Get all cridets
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/api/cridets")
	public ResponseEntity<List<Cridet>> getAllCridets() {
		return ResponseEntity.ok(invoiceService.getAllCridets());
	}

	/**
	 * Get one debit
	 * 
	 * @param id
	 * @return Client
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/api/debits/{id}")
	public ResponseEntity<Debit> GetOneDebit(@PathVariable("id") String id) {
		return ResponseEntity.ok(invoiceService.findDebit(id));
	}

	/**
	 * Get one cridet
	 * 
	 * @param id
	 * @return Client
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/api/cridets/{id}")
	public ResponseEntity<Cridet> GetOneCridet(@PathVariable("id") String id) {
		return ResponseEntity.ok(invoiceService.findCridet(id));
	}
	
	/**
	 * Create Debit
	 * 
	 * @param Debit
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/api/debits", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Debit> createDebit(@RequestBody Debit debit) {
		return ResponseEntity.ok(invoiceService.save(debit));
	}
	
	/**
	 * Create Cridet
	 * 
	 * @param Cridet
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/api/cridets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cridet> createCridet(@RequestBody Cridet cridet) {
		return ResponseEntity.ok(invoiceService.save(cridet));
	}
}
