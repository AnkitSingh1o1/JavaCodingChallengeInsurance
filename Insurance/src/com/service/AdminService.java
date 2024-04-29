package com.service;

import java.sql.SQLException;

import com.dao.AdminDao;
import com.dao.AdminDaoImpl;
import com.exception.ResourceNotFoundException;

public class AdminService {

	AdminDao dao = new AdminDaoImpl();
	
	public int getAdminIdByUsernamePassword(String username, String password) throws SQLException, ResourceNotFoundException {
		return dao.getVendorIdByUsernamePassword(username, password);
	}

}
