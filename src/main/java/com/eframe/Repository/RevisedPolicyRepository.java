package com.eframe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eframe.model.RevisedPolicy;

public interface RevisedPolicyRepository extends JpaRepository<RevisedPolicy, String> {

}

