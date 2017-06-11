package com.eframe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eframe.model.RevisedPolicy;

@Repository
public interface RevisedPolicyRepository extends JpaRepository<RevisedPolicy, String> {
	
	List<RevisedPolicy> findAll();
}

