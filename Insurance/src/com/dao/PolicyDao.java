package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.PolicyNotFoundException;
import com.model.Policy;

public interface PolicyDao {

	public boolean createPolicy(Policy policy) throws SQLException, 
	PolicyNotFoundException;
	
	public Policy getPolicy(int policyId) throws SQLException, 
	PolicyNotFoundException;
	
	public List<Policy> getAllPolicies()throws SQLException, 
	PolicyNotFoundException;
	
	public boolean updatePolicy(int policyId, Policy updatedPolicy)throws SQLException, 
	PolicyNotFoundException;
	
	public boolean deletePolicy(int policyId)throws SQLException, 
	PolicyNotFoundException;
	
}
