package com.eframe.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.Debit;

public interface DebitRepository extends JpaRepository<Debit, String> {
	
}
