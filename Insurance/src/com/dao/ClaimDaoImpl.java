package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.exception.PolicyNotFoundException;
import com.model.Claim;
import com.utility.DBConnection;

public class ClaimDaoImpl implements ClaimDao{

	@Override
	public boolean createClaim(Claim claim) throws SQLException, PolicyNotFoundException {
		Connection con = DBConnection.dbConnect();

		String sql = "insert into claim(claim_id, claim_number, claim_date_filed, claim_amount, claim_status, client_id, policy_id) values "
				+ "(?, ?, ?, ?, ?, ?, ?);";

		// prepare statement
		PreparedStatement pstmt = con.prepareStatement(sql);

		// attach the data
		pstmt.setInt(1, claim.getClaimId());
		pstmt.setInt(2,claim.getClaimNumber());
		pstmt.setString(3, claim.getClaimDate());
		pstmt.setDouble(4,claim.getClaimAmount());
		pstmt.setString(5, claim.getClaimStatus());
		pstmt.setInt(6, claim.getClientId());
		pstmt.setInt(7, claim.getPolicyId());
		// execute the query
		int status = pstmt.executeUpdate();

		// close db connection
		DBConnection.dbClose();

		return status == 1 ? true : false;
	}

}
