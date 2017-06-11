package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eframe.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	
	List<Client> findAll();
}