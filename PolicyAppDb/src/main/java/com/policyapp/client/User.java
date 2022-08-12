package com.policyapp.client;

import java.util.List;
import java.util.Scanner;

import com.policy.services.IPolicyService;
import com.policy.services.PolicyServiceImpl;
import com.policyapp.dao.IPolicyDAO;
import com.policyapp.dao.PolicyDAOImpl;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;


public class User {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		IPolicyService policyServices=new PolicyServiceImpl();
		
//		System.out.println();
//		System.out.println("update operation");
//		System.out.println("enter coverage to set");
//		String coverage=sc.next();
//		System.out.println("enter id to change coverage");
//		int policyId=sc.nextInt();
//		policyServices.updatePolicy(policyId,coverage);
		
//		System.out.println();
//		System.out.println("select all policy operation");
//		IPolicyDAO policyDAOImpl=new PolicyDAOImpl();
//		List<Policy> policyList =policyServices.getAll();
//		for(Policy policy:policyList) {
//			System.out.println(policy);
//		}
		
//		System.out.println();
//		System.out.println("Delete from policy operation");
//		System.out.println("enter id to delete the policy: ");
//		int dpolicyId=sc.nextInt();
//		policyServices.deletePolicy(dpolicyId);
		
		policyServices.getAll().forEach(System.out::println);
		
	}

}
