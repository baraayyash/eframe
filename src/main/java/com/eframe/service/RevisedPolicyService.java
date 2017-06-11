package com.eframe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eframe.Repository.RevisedPolicyRepository;
import com.eframe.model.RevisedPolicy;

@Service
public class RevisedPolicyService {
	
	@Autowired
	public RevisedPolicyRepository revisedPolicyRepository;
	
	public List<RevisedPolicy> findAll() {
		return revisedPolicyRepository.findAll();
	}
	
	public RevisedPolicy save(RevisedPolicy revisedPolicy) {
		return revisedPolicyRepository.save(revisedPolicy);
	}
}
