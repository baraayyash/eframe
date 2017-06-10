package com.eframe.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.RevisedPolicy;


public interface RevisedPolicyRepository extends JpaRepository<RevisedPolicy, String> {
	
	List<RevisedPolicy> findAll();
}

