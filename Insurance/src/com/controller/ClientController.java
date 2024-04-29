package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.PolicyNotFoundException;
import com.exception.ResourceNotFoundException;
import com.model.Claim;
import com.model.Payment;
import com.model.Policy;
import com.service.AdminService;
import com.service.ClaimService;
import com.service.ClientService;
import com.service.PaymentService;
import com.service.PolicyService;
import com.utility.RandomId;

public class ClientController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PolicyService policyService = new PolicyService();
		PaymentService paymentService = new PaymentService();
		ClaimService claimService = new ClaimService();
		
		
		int clientId = Integer.parseInt(args[0]);
		
		while(true) {
			System.out.println("      Welcome Client");
			System.out.println("-------------------------- ");
			System.out.println("1. List all Policies");
			System.out.println("2. Buy a Policy");
			System.out.println("3. Claim a Policy");
			System.out.println("0. Exit");
			
			int choice = sc.nextInt();
			if(choice == 0)
				break;
			
			switch(choice) {
			case 1:
				System.out.println("All Policies");
				
				List<Policy> list = null;
				try {
					list = policyService.getAllPolicies();
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(list);
				
				break;
				
			case 2:
				System.out.println("Enter Policy Id");
				int id = sc.nextInt();
				
				Policy policy1 = null;
				try {
					policy1 = policyService.getPolicy(id);
					double amount = policy1.getPolicyCost();
					
					System.out.println("Total Amount:"+amount);
					System.out.println("Shall we proceed to payment?:(y/n)");
					String c = sc.next();
					if(c.equalsIgnoreCase("n"))
						break;
					
					System.out.println("Payment Details:");
					sc.nextLine();
					System.out.println("Enter Paymeny date:");
					String date = sc.nextLine();
					
					Payment p = new Payment(RandomId.getRandomId(), date, amount, clientId);
					int status = paymentService.save(p);
					
					if(status == 1)
						System.out.println("Payment made Sucessfully");
					else
						System.out.println("Payment failed");
					
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(policy1.toString());
				
				break;
				
			case 3:
				System.out.println("Enter Todays date");
				String date = sc.nextLine();
				System.out.println("Enter Claim Amount");
				double amount = sc.nextDouble();
				System.out.println("Enter Policy Id");
				int id1 = sc.nextInt();
				
				int claimId = RandomId.getRandomId();
				int claimNumber = RandomId.getRandomId();;
				
				Claim c = new Claim(claimId, claimNumber, date, amount, "Pending", clientId, id1);
				try {
					boolean status = claimService.createClaim(c);
					if(status)
					System.out.println("Claim created");
					else
						System.out.println("Failed");
				} catch (SQLException | PolicyNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
		}
	}

	public static void clientMenu(String username, String password) {
		ClientService clientService = new ClientService();
		
		try {
			int adminId = clientService.getClientIdByUsernamePassword(username, 
					password);
			String[] sarr = { ""+adminId };
			main(sarr);
		} catch (SQLException | ResourceNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
