package com.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.exception.InvalidInputException;
import com.model.User;
import com.service.UserService;

public class MainModule {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();
		
		
		
		System.out.println("Login");
		System.out.println("Enter username:");
		String username = sc.next();
		System.out.println("Enter password:");
		String password = sc.next();
		
		try {
			User userLogin = userService.login(username, password);
					
			//System.out.println("Logged in "+userLogin.getUserRole());
			if (userLogin.getUserRole().equalsIgnoreCase("client")) {
				ClientController.clientMenu(username, password);
			}

			else if (userLogin.getUserRole().equalsIgnoreCase("admin")) {
				 AdminController.adminMenu(username, password);
			}

		} catch (SQLException | InvalidInputException e) {
			System.out.println("try Loggin in again");
			System.out.println(e.getMessage());
		}
	
	}

}
