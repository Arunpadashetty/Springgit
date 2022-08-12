package com.policy.services;

import java.util.List;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public interface IPolicyService {
	
	
	void addPolicy(Policy policy);
	void deletePolicy(int policyId);
	void updatePolicy(int policyId, String Coverage);

	List<Policy> getAll();
	List<Policy> getByType(String type) throws PolicyNotFoundException;
	List<Policy> getBYCategory(String category) throws PolicyNotFoundException ;
	List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException ;
	List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException;
	
	List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException;
	
	Policy getById(int policyId) throws IdNotFoundException;
	Policy getByBrand(String brand) throws PolicyNotFoundException;
}