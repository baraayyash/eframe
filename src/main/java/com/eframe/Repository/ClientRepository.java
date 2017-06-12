package com.eframe.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
	
}