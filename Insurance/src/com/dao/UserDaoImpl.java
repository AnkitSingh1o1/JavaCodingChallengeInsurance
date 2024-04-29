package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;
import com.utility.DBConnection;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(String username, String password) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM user WHERE user_username = ? AND user_password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1,username);
		pstmt.setString(2,password);
		ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			User user = new User();
			user.setUserId(rst.getInt("user_id"));
			user.setUserName(username);
			user.setUserPassword(password);   // password should not be displayed on the admin page menu console
			user.setUserRole(rst.getString("user_role"));
			DBConnection.dbClose();
			return user;
		}
		else {
			DBConnection.dbClose();
			return null;
		}
	}

}
