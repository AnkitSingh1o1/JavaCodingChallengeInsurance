package com.service;

import java.sql.SQLException;

import com.dao.ClaimDao;
import com.dao.ClaimDaoImpl;
import com.exception.PolicyNotFoundException;
import com.model.Claim;

public class ClaimService {

	ClaimDao dao = new ClaimDaoImpl();
	
	public boolean createClaim(Claim claim) throws SQLException, PolicyNotFoundException {
		return dao.createClaim(claim);
	}
			
			
}
