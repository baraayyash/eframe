package com.eframe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eframe.service.ClientService;
import com.eframe.utils.ListRequest;
import com.eframe.utils.ListResponse;
import com.eframe.utils.OffsetBasedPageRequest;
import com.eframe.model.Client;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;

	/**
	 * Get all clients
	 * 
	 * @return List<Client>
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "api/clients")
	public ResponseEntity<ListResponse> getAll(ListRequest request) {
		Pageable pageable = new OffsetBasedPageRequest(request.getStart(), request.getLength());
		System.out.println("---" + request.getDraw());
		return ResponseEntity.ok(new ListResponse(clientService.findAll(pageable), request.getDraw()));
	}

	/**
	 * Get one client
	 * 
	 * @param id
	 * @return Client
	 */
	@RequestMapping(method = RequestMethod.GET ,value = "api/clients/{id}")
	public ResponseEntity<Client> GetOne(@PathVariable("id") String id) {
		return ResponseEntity.ok(clientService.findOne(id));
	}

	/**
	 * Create Product
	 * 
	 * @param Client
	 * @return
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "api/clients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> create(@RequestBody Client client) {
		return ResponseEntity.ok(clientService.save(client));
	}

	/**
	 * Update existing product
	 * 
	 * @param Client
	 * @return Client
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "api/clients/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Client> update(@RequestBody Client client) {
		return ResponseEntity.ok(clientService.save(client));
	}
}
