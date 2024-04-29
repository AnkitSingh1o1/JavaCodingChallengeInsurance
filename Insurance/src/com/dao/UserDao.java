package com.dao;

import java.sql.SQLException;

import com.model.User;

public interface UserDao {

	User login(String username, String password) throws SQLException;
}
