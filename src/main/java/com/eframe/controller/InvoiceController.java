package com.eframe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
import com.eframe.utils.ListRequest;
import com.eframe.utils.ListResponse;
import com.eframe.utils.OffsetBasedPageRequest;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	
	/**
	 * Get all debits
	 * 
	 * @return List<Client>
	 * @throws GenaricException 
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/debits")
	public ResponseEntity<ListResponse> getAllDebits(ListRequest request) {
		Pageable pageable = new OffsetBasedPageRequest(request.getStart(), request.getLength());
		return new ResponseEntity<ListResponse>(new ListResponse(invoiceService.getAllDebits(pageable), request.getDraw()),HttpStatus.OK);
	}
	
	/**
	 * Get all cridets
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/cridets")
	public ResponseEntity<ListResponse> getAllCridets(ListRequest request) {
		Pageable pageable = new OffsetBasedPageRequest(request.getStart(), request.getLength());
		return ResponseEntity.ok(new ListResponse(invoiceService.getAllCridets(pageable), request.getDraw()));
	}

	/**
	 * Get one debit
	 * 
	 * @param id
	 * @return Client
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/debits/{id}")
	public ResponseEntity<Debit> GetOneDebit(@PathVariable("id") String id) {
		return ResponseEntity.ok(invoiceService.findDebit(id));
	}

	/**
	 * Get one cridet
	 * 
	 * @param id
	 * @return Client
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "/cridets/{id}")
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
	@RequestMapping(method = RequestMethod.POST, value = "/debits", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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
	@RequestMapping(method = RequestMethod.POST, value = "/cridets", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cridet> createCridet(@RequestBody Cridet cridet) {
		return ResponseEntity.ok(invoiceService.save(cridet));
	}
}
