package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.exception.PolicyNotFoundException;
import com.exception.ResourceNotFoundException;
import com.model.Policy;
import com.service.AdminService;
import com.service.PolicyService;
import com.utility.RandomId;


public class AdminController {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PolicyService policyService = new PolicyService();
		
		
		
		while(true) {
			System.out.println("      Welcome Admin");
			System.out.println("-------------------------- ");
			System.out.println("1. Create Policy");
			System.out.println("2. Get a Policy");
			System.out.println("3. Get All Policy");
			System.out.println("4. Update Policy");
			System.out.println("5. Delete Policy");
			System.out.println("0. Exit");
			
			int choice = sc.nextInt();
			if(choice == 0)
				break;
			
			switch(choice) {
			case 1:
				System.out.println("Enter Policy Details");
				sc.nextLine();
				System.out.println("Enter Policy Name");
				String name = sc.nextLine();
				System.out.println("Enter Policy Cost");
				double cost = sc.nextDouble();
				
				int policyId = RandomId.getRandomId();
				
				Policy policy = new Policy(policyId, name, cost, "yes");
				try {
					boolean b = policyService.createPolicy(policy);
					if(b)
					System.out.println("Policy created sucessfully");
					else 
						System.out.println("Failed to create");
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 2:
				
				System.out.println("Enter Policy Id");
				int id = sc.nextInt();
				
				Policy policy1 = null;
				try {
					policy1 = policyService.getPolicy(id);
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(policy1.toString());
				
				break;
				
			case 3:
				System.out.println("All Policies");
				
				List<Policy> list = null;
				try {
					list = policyService.getAllPolicies();
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(list);
				
				break;
				
			case 4:
				System.out.println("Enter Policy Details");
				System.out.println("Enter Policy Id");
				int pId = sc.nextInt();
				System.out.println("Enter Policy Name");
				sc.nextLine();
				String name1 = sc.nextLine();
				System.out.println("Enter Policy Cost");
				double cost1 = sc.nextDouble();
				System.out.println("Enter Policy isActive Status(yes/no):");
				String isActive = sc.next();
				
				
				Policy updatesPolicy = new Policy(pId, name1, cost1, isActive);
				try {
					boolean b = policyService.updatePolicy(pId, updatesPolicy);
					if(b)
					System.out.println("Policy updated sucessfully");
					else 
						System.out.println("Failed to update");
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				break;
				
			case 5:
				System.out.println("Enter Policy Id");
				int policyId1 = sc.nextInt();
				
				try {
					boolean b = policyService.deletePolicy(policyId1);
					if(b)
						System.out.println("Policy deleted sucessfully");
						else 
							System.out.println("Failed to delete");
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				
				
				break;
			}
		}
		
		sc.close();
	}

	public static void adminMenu(String username, String password) {
		AdminService adminService = new AdminService();
		
			
			try {
				int adminId = adminService.getAdminIdByUsernamePassword(username, 
						password);
			} catch (SQLException | ResourceNotFoundException e) {
				System.out.println(e.getMessage());
			}
			
			String[] sarr = { "adminId" };
			main(sarr);
		
	}

}
