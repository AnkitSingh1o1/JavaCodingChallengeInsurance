package com.dao;

import java.sql.SQLException;

import com.exception.PolicyNotFoundException;
import com.model.Claim;
import com.model.Policy;

public interface ClaimDao {

	public boolean createClaim(Claim claim) throws SQLException, 
	PolicyNotFoundException;
}
