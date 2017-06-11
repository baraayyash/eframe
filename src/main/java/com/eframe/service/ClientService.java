package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.Repository.ClientRepository;
import com.eframe.model.Client;


@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
}
