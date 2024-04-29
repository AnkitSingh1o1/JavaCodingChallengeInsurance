package com.service;

import java.sql.SQLException;

import com.dao.ClientDao;
import com.dao.ClientDaoImpl;
import com.exception.ResourceNotFoundException;

public class ClientService {
	
	ClientDao dao = new ClientDaoImpl();
	
	public int getClientIdByUsernamePassword(String username, String password)
			throws SQLException, ResourceNotFoundException {
		return dao.getClientIdByUsernamePassword(username, password);
	}

}
