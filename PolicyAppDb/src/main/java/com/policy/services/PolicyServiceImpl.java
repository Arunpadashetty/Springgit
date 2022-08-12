package com.policy.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	public void addPolicy(Policy policy) {
		policyDAO.addPolicy(policy);
	}
	
	@Override
	public void deletePolicy(int policyId) {
		policyDAO.deletePolicy(policyId);
	}
	@Override
	public void updatePolicy(int policyId, String Coverage) {
		policyDAO.updatePolicy(policyId, Coverage);
	}
	
	@Override
	public List<Policy> getAll() {
		List<Policy> policyList=policyDAO.findAll();
		if(policyList!=null) {
			return policyList
					.stream()
					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<Policy> getByType(String type) throws PolicyNotFoundException {
		List<Policy> policyList=policyDAO.findByType(type);
		if(policyList!=null) {
			return policyList
					.stream()
					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
					.collect(Collectors.toList());
		}
		return null;
	}

//	@Override
//	public List<Policy> getBYCategory(String category) throws PolicyNotFoundException {
//		List<Policy> policyList=policyDAO.findBYCategory(category);
//		if(policyList!=null) {
//			return policyList
//					.stream()
//					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
//					.collect(Collectors.toList());
//		}
//		return null;
//	}

	@Override
	public List<Policy> getByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policyList=policyDAO.findByHighSumAssured(sumAssured);
		if(policyList!=null) {
			return policyList
					.stream()
					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<Policy> getByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policyList=policyDAO.findByCoverage(coverage);
		if(policyList!=null) {
			return policyList
					.stream()
					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<Policy> getByLessPremium(double premium) throws PolicyNotFoundException {
		List<Policy> policyList=policyDAO.findByPremium(premium);
		if(policyList!=null) {
			return policyList
					.stream()
					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public Policy getById(int policyId) throws IdNotFoundException {
		Policy policy=new Policy();
		if(policy!=null) {
		policy.getPolicyNumber();
		}
		return null;
	}

	@Override
	public Policy getByBrand(String brand) throws PolicyNotFoundException {
		List<Policy> policyList=policyDAO.findByBrand(brand);
		if(policyList!=null) {
			 policyList
					.stream()
					.sorted((p1,p2)->p1.getType().compareTo(p2.getType()))
					.collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public List<Policy> getBYCategory(String category) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
