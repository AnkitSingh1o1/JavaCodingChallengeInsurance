package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.ResourceNotFoundException;
import com.model.User;
import com.utility.DBConnection;

public class ClientDaoImpl implements ClientDao{

	@Override
	public int getClientIdByUsernamePassword(String username, String password)
			throws SQLException, ResourceNotFoundException {
		Connection con = DBConnection.dbConnect();
		String sql = "select c.client_id from client c JOIN user u ON c.user_id=u.user_id "
				+ "where u.user_username=? AND u.user_password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		int clientId = 0;
		if (rs.next())
			clientId = rs.getInt("customer_id");
		DBConnection.dbClose();
		return clientId;

	}

}
