package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.PolicyNotFoundException;
import com.model.Policy;
import com.utility.DBConnection;

public class PolicyDaoImpl implements PolicyDao{

	@Override
	public boolean createPolicy(Policy policy) throws SQLException, PolicyNotFoundException {
		// open connection
		Connection con = DBConnection.dbConnect();

		String sql = "insert into policy(policy_id, policy_name, policy_cost) "
				+ "values (?, ?, ?)";

		// prepare statement
		PreparedStatement pstmt = con.prepareStatement(sql);

		// attach the data
		pstmt.setInt(1, policy.getPolicyId());
		pstmt.setString(2, policy.getPolicyName());
		pstmt.setDouble(3, policy.getPolicyCost());
		
		// execute the query
		int status = pstmt.executeUpdate();

		// close db connection
		DBConnection.dbClose();

		return status == 1 ? true : false;
	}

	@Override
	public Policy getPolicy(int policyId) throws SQLException, PolicyNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from policy where policy_id = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);
		
		ResultSet rst = pstmt.executeQuery();
		
		Policy policy = null;
	while(rst.next()) {
		int id = rst.getInt("policy_id");
		String name = rst.getString("policy_name");
		Double cost = rst.getDouble("policy_cost");
		String isActive = rst.getString("isActive");
		policy = new Policy(id, name, cost,isActive);
	}
		DBConnection.dbClose();
		return policy;
	}

	@Override
	public List<Policy> getAllPolicies() throws SQLException, PolicyNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from policy";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rst = pstmt.executeQuery();
		List<Policy> list = new ArrayList<>();
		while (rst.next()) {
			int id = rst.getInt("policy_id");
			String name = rst.getString("policy_name");
			Double cost = rst.getDouble("policy_cost");
			String isActive = rst.getString("isActive");
			Policy policy = new Policy(id, name, cost, isActive);	
			list.add(policy);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public boolean updatePolicy(int id, Policy updatedPolicy) throws SQLException, PolicyNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "update policy "
				+ "set policy_id = ?, "
				+ "policy_name = ?, "
				+ "policy_cost = ?, "
				+ "isActive = ? "
				+ "where policy_id = ?";
		// prepare statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, updatedPolicy.getPolicyId());
		pstmt.setString(2, updatedPolicy.getPolicyName());
		pstmt.setDouble(3, updatedPolicy.getPolicyCost());
		pstmt.setString(4, updatedPolicy.getIsActive());
		pstmt.setInt(5, id);
		int status = pstmt.executeUpdate(); // 1 - updates/ 0 - not updated

		DBConnection.dbClose();
		return status == 1 ? true : false;

	}

	//SoftDelete
	@Override
	public boolean deletePolicy(int policyId) throws SQLException, PolicyNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "update policy "
				+ "set isActive = 'no' "
				+ "where policy_id = ?";

		// prepare and set statement
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, policyId);

		int status = pstmt.executeUpdate(); // 1 - updates/ 0 - not updated

		DBConnection.dbClose();
		return status == 1 ? true : false;
	}
	

}
