package com.policyapp.client;

import com.policy.services.IPolicyService;
import com.policy.services.PolicyServiceImpl;
import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;


public class User {

	public static void main(String[] args) {
		
		IPolicyService policyService=new PolicyServiceImpl();
		policyService.getAll().forEach(System.out::println);
		try {
			policyService.getByType("single").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		try {
			policyService.getByCategory("life").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		try {
			policyService.getByHighSumAssured(2000).forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		try {
			policyService.getByCoverage("child").forEach(System.out::println);
		} catch (PolicyNotFoundException e) {
			System.out.println(e.getMessage());
			
		}
		
			try {
				System.out.println(policyService.getById(1002));
			} catch (IdNotFoundException e) {
				System.out.println(e.getMessage());
			}
	
			
		}
		
		

	}

