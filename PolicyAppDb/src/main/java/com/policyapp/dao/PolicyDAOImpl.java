package com.policyapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.policyapp.exceptions.IdNotFoundException;
import com.policyapp.exceptions.PolicyNotFoundException;
import com.policyapp.model.Policy;
import com.policyapp.util.DbConnection;

public class PolicyDAOImpl implements IPolicyDAO{
	
	
	@Override
	public void addPolicy(Policy policy) {
		String sql="insert into policy values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedstatement=null;
		Connection connection=DbConnection.openConnection();
		try {
		preparedstatement=connection.prepareStatement(sql);
		preparedstatement.setString(1,policy.getPolicyName());
		preparedstatement.setInt(2,policy.getPolicyNumber());
		preparedstatement.setDouble(3,policy.getPremium());
		preparedstatement.setString(4,policy.getType());
		preparedstatement.setInt(5,policy.getDuration());
		preparedstatement.setString(6,policy.getCoverage());
		preparedstatement.setString(7,policy.getCategory());
		preparedstatement.setString(8,policy.getBrand());
		preparedstatement.setDouble(9,policy.getSumAssured());
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	@Override
	public void deletePolicy(int policyId) {
		String sql="delete  policy where policyId="+policyId;
		Connection connection=DbConnection.openConnection();
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				DbConnection.closeConnection();
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updatePolicy(int policyId, String Coverage) {
		
	Connection connection=DbConnection.openConnection();
	String sql="update policy set coverage=? where policy_id=?";
	

	try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,Coverage);
		preparedStatement.setInt(2,policyId);
		preparedStatement.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
	
	@Override
	public List<Policy> findAll() {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from policy ";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();
				
				String policyName=resultset.getString("policy_name");
				int policyNumber=resultset.getInt("policy_id");
				double premium=resultset.getDouble("premium");
				String type=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
	//			String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double sumAssured=resultset.getDouble("sum_assured");
				
				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
			    policy.setDuration(duration);	
			    policy.setCoverage(coverage);
			//    policy.setCategory(category);
			    policy.setBrand(brand);
			    policy.setSumAssured(sumAssured);
			    policies.add(policy);
			    
			}
			DbConnection.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return policies;
	}

	@Override
	public List<Policy> findByType(String type) throws PolicyNotFoundException {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from policy where type=? ";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,type);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();
				
				String policyName=resultset.getString("policyName");
				int policyNumber=resultset.getInt("policyNumber");
				double premium=resultset.getDouble("premium");
				String mtype=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double sumAssured=resultset.getDouble("sumAssured");
				
				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
			    policy.setDuration(duration);	
			    policy.setCoverage(coverage);
			    policy.setCategory(category);
			    policy.setBrand(brand);
			    policy.setSumAssured(sumAssured);
			}
			DbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return policies;
	}
		
//	@Override
//	public List<Policy> findBYCategory(String category) throws PolicyNotFoundException {
//		List<Policy> policies=new ArrayList<Policy>();
//		String sql="select * from policy where category=?";
//		Connection connection=DbConnection.openConnection();
//		ResultSet resultset=null;
//		PreparedStatement preparedStatement=null;
//		
//		try {
//			preparedStatement=connection.prepareStatement(sql);
//			preparedStatement.setString(1,category);
//			resultset=preparedStatement.executeQuery();
//			while(resultset.next()) {
//				Policy policy=new Policy();
//				
//				String policyName=resultset.getString("policyName");
//				int policyNumber=resultset.getInt("policyNumber");
//				double premium=resultset.getDouble("premium");
//				String type=resultset.getString("type");
//				int duration=resultset.getInt("duration");
//				String coverage=resultset.getString("coverage");
//				String mcategory=resultset.getString("category");
//				String brand=resultset.getString("brand");
//				double sumAssured=resultset.getDouble("sumAssured");
//				
//				policy.setPolicyName(policyName);
//				policy.setPolicyNumber(policyNumber);
//				policy.setPremium(premium);
//				policy.setType(type);
//			    policy.setDuration(duration);	
//			    policy.setCoverage(coverage);
//			    policy.setCategory(category);
//			    policy.setBrand(brand);
//			    policy.setSumAssured(sumAssured);
//			}
//			DbConnection.closeConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			DbConnection.closeConnection();
//		}
//		return policies;
//	}

	@Override
	public List<Policy> findByHighSumAssured(double sumAssured) throws PolicyNotFoundException {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from policy where SumAssured=>?";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1,sumAssured);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();
				
				String policyName=resultset.getString("policyName");
				int policyNumber=resultset.getInt("policyNumber");
				double premium=resultset.getDouble("premium");
				String type=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double msumAssured=resultset.getDouble("sumAssured");
				
				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
			    policy.setDuration(duration);	
			    policy.setCoverage(coverage);
			    policy.setCategory(category);
			    policy.setBrand(brand);
			    policy.setSumAssured(sumAssured);
			}
			DbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return policies;
	}

	@Override
	public List<Policy> findByCoverage(String coverage) throws PolicyNotFoundException {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from policy where coverage=?";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,coverage);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();
				
				String policyName=resultset.getString("policyName");
				int policyNumber=resultset.getInt("policyNumber");
				double premium=resultset.getDouble("premium");
				String type=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String mcoverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double sumAssured=resultset.getDouble("sumAssured");
				
				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
			    policy.setDuration(duration);	
			    policy.setCoverage(coverage);
			    policy.setCategory(category);
			    policy.setBrand(brand);
			    policy.setSumAssured(sumAssured);
			}
			DbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return policies;
	}
	

	@Override
	public List<Policy> findByPremium(double premium) throws PolicyNotFoundException {
		List<Policy> policies=new ArrayList<Policy>();
		String sql="select * from policy where premium=?";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1,premium);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				Policy policy=new Policy();
				
				String policyName=resultset.getString("policyName");
				int policyNumber=resultset.getInt("policyNumber");
				double mpremium=resultset.getDouble("premium");
				String type=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double sumAssured=resultset.getDouble("sumAssured");
				
				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
			    policy.setDuration(duration);	
			    policy.setCoverage(coverage);
			    policy.setCategory(category);
			    policy.setBrand(brand);
			    policy.setSumAssured(sumAssured);
			}
			DbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return policies;
	}

	@Override
	public Policy findById(int policyId) throws IdNotFoundException {
		Policy policy=null;
		String sql="select * from policy where policyId=?";
		Connection connection=DbConnection.openConnection();
		ResultSet resultset=null;
		PreparedStatement preparedStatement=null;
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,policyId);
			resultset=preparedStatement.executeQuery();
			while(resultset.next()) {
				 policy=new Policy();
				
				String policyName=resultset.getString("policyName");
				int policyNumber=resultset.getInt("policyNumber");
				double premium=resultset.getDouble("premium");
				String type=resultset.getString("type");
				int duration=resultset.getInt("duration");
				String coverage=resultset.getString("coverage");
				String category=resultset.getString("category");
				String brand=resultset.getString("brand");
				double sumAssured=resultset.getDouble("sumAssured");
				
				policy.setPolicyName(policyName);
				policy.setPolicyNumber(policyNumber);
				policy.setPremium(premium);
				policy.setType(type);
			    policy.setDuration(duration);	
			    policy.setCoverage(coverage);
			    policy.setCategory(category);
			    policy.setBrand(brand);
			    policy.setSumAssured(sumAssured);
			}
			DbConnection.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DbConnection.closeConnection();
		}
		return policy;
	}
	@Override
	public List<Policy> findByBrand(String brand) throws PolicyNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

	
}
