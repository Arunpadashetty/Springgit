package com.policy.services;

import java.util.List;
import java.util.stream.Collectors;

import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyServiceImpl  implements IPolicyService{

	IPolicyDAO policyDAO=new PolicyDAOImpl();
	@Override
	public List<Policy> getAll() {
		List<Policy> policies=policyDAO.findAll();
		List<Policy> policyList=policies
		.stream()
		.sorted((Policy p1, Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
		.collect(Collectors.toList());
		return policyList;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		System.out.println(" ");
		List<Policy> policies=policyDAO.findByType(type);
		List<Policy> policyList=policies
				.stream()
				.sorted((Policy p1, Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		
		        if(policyList !=null) {
				return policyList;
		        }
		        else
		        	throw new PolicyNotFoundException(" policy not found");
		
	}

	@Override
	public List<Policy> getByCategory(String category) throws PolicyNotFoundException {
		System.out.println(" ");
		List<Policy> policies=policyDAO.findByCategory(category);
		List<Policy> policyList=policies
				.stream()
				.sorted((Policy p1, Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		
		        if(policyList !=null) {
				return policyList;
		        }
		        else
		        	throw new PolicyNotFoundException(" policy not found");
	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		System.out.println(" ");
		List<Policy> policies=policyDAO.findByHighSumAssured(sumAssured);
		List<Policy> policyList=policies
				.stream()
				.sorted((Policy p1, Policy p2)->p1.getPolicyName().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		
		        if(policyList !=null) {
				return policyList;
		        }
		        else
		        	throw new PolicyNotFoundException(" policy not found");
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		System.out.println(" ");
		List<Policy> policies=policyDAO.findByCoverage(coverage);
		List<Policy> policyList=policies
				.stream()
				.sorted((Policy p1, Policy p2)->p1.getCoverage().compareTo(p2.getPolicyName()))
				.collect(Collectors.toList());
		
		        if(policyList !=null) {
				return policyList;
		        }
		        else
		        	throw new PolicyNotFoundException(" policy not found");
	}
	

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		System.out.println(" ");
		List<Policy> policies=policyDAO.findByLessPremium(premium);
		List<Policy> policyList=policies
				.stream()
				.collect(Collectors.toList());
		
		        if(policies.isEmpty()) {
				return policyList;
		        }
		        else
		        	throw new PolicyNotFoundException(" policy not found");
	}
	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy=policyDAO.findById(policyId);
		if(policy==null) {
			throw new IdNotFoundException("Sorry policy id is not found");
		}
		return policy;
	}

}
