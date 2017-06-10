package com.eframe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
	
	List<Client> findAll();
}