package com.dao;

import java.sql.SQLException;

import com.exception.ResourceNotFoundException;

public interface ClientDao {

	public int getClientIdByUsernamePassword(String username, String password) 
			throws SQLException, ResourceNotFoundException;
}
