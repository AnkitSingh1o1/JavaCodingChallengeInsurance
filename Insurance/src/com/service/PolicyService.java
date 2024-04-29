package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.PolicyDao;
import com.dao.PolicyDaoImpl;
import com.exception.PolicyNotFoundException;
import com.model.Policy;

public class PolicyService {

	PolicyDao dao = new PolicyDaoImpl();
	
	public boolean createPolicy(Policy policy) throws SQLException, 
	PolicyNotFoundException {
		return dao.createPolicy(policy);
	}
	
	public Policy getPolicy(int policyId) throws SQLException, 
	PolicyNotFoundException {
		return dao.getPolicy(policyId);
	}
	
	public List<Policy> getAllPolicies() throws SQLException,
	PolicyNotFoundException {
		return dao.getAllPolicies();
	}

	public boolean updatePolicy(int id, Policy updatedPolicy)
throws SQLException, PolicyNotFoundException {
		return dao.updatePolicy(id, updatedPolicy);
	}
	
	public boolean deletePolicy(int policyId) throws SQLException, 
	PolicyNotFoundException {
		return dao.deletePolicy(policyId);
	}

}
