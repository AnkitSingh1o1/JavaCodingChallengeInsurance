package com.service;

import java.sql.SQLException;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.exception.InvalidInputException;
import com.model.User;

public class UserService {

	UserDao userDao = new UserDaoImpl();
	
	public User login(String username, String password) throws SQLException, InvalidInputException {
		
		User loginUser = userDao.login(username, password);
		
		//if the any of the entered credentials are incorrect it throws an InvalidCredentialException
		if(loginUser == null) {
			throw new InvalidInputException("Invalid Credentials");
		}
		
		return loginUser;
	}

}
