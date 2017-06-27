package com.eframe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.eframe.Repository.ClientRepository;
import com.eframe.model.Client;


@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Page<Client> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable);
	}

	public Client findOne(String id) {
		return clientRepository.findOne(id);
	}

	public Client save(Client client) {
		return clientRepository.save(client);
	}
}
