package com.policyapp.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;

public class PolicyDAOImpl implements IPolicyDAO{

	@Override
	public List<Policy> findAll() {
		// TODO Auto-generated method stub
		return showAllpolicies();
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllpolicies().stream().filter(policy -> policy.getType().equalsIgnoreCase(type)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCategory(String category) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllpolicies().stream().filter(policy -> policy.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllpolicies().stream().filter(policy -> policy.getSumAssured()==(sumAssured)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return showAllpolicies().stream().filter(policy -> policy.getCoverage().equalsIgnoreCase(coverage)).collect(Collectors.toList());
	}

	@Override
	public List<Policy> findByLessPremium(double premium) throws PolicyNotFoundException {
		return showAllpolicies().stream().filter(policy -> policy.getPremium()==(premium)).collect(Collectors.toList());
	}

	private List<Policy> showAllpolicies(){
		return Arrays.asList(
				new Policy("Jeevan Sathi",1001,2000,"term",10,"marriage","general",20000),
				new Policy("Jeevan Anand",1002,3000,"endowment",40,"life","life",500000),
				new Policy("Life Saral",1003,1600,"pension",50,"retirement","general",2000000),
				new Policy("Bajaj Allianz",1004,2000,"endowment",20,"accidents","motor",200000),
				new Policy("Tata Allianz",1005,3000,"term",30,"marriage","general",250000)
				);
		
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		Optional<Policy> Policy= showAllpolicies().stream().filter(policy -> policy.getPolicyNumber()==(policyId)).findFirst();
		if(Policy.isPresent()) {
			return Policy.get();
		}
		return null;
	}

	

}
