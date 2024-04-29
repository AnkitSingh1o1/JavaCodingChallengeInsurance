package com.dao;

import java.sql.SQLException;

import com.exception.ResourceNotFoundException;

public interface AdminDao {

	public int getVendorIdByUsernamePassword(String username, String password) 
	throws SQLException, ResourceNotFoundException;
}
