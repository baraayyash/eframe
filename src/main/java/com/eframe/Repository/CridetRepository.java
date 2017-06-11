package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eframe.model.Cridet;

@Repository
public interface CridetRepository extends JpaRepository<Cridet, String> {
	
	List<Cridet> findAll();
}
