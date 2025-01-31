package com.codingNinjas.Bank.Account.Registration;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class BankAccountRegistrationApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.
		
		* 1. Fetch context from ApplicationContext.xml and initiate scanner.
		* 2. Get user details from console.
		* 3. Get account details from user and add them to the account list.
		* 4. Display the list of accounts with their reference ids.
		* 
		*/
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		User user=(User) context.getBean("myUser");
		System.out.println("Welcome to the Account Registration Application ");
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter your name ");
		String name=sc.nextLine();
		user.setUserDetails(name);
		System.out.println("Do you want to add account ");
		System.out.println("1)Yes \n2)No ");
		
		while(true) {
			int choice=sc.nextInt();
			sc.nextLine();
			if (choice == 2) break;
				System.out.println("Please select the account type");
				System.out.println("1)Current \n2)Savings");
				int accChoice=sc.nextInt();
				sc.nextLine();
				
					System.out.println("Enter the opening balance ");
					double balance=sc.nextDouble();
					sc.nextLine();
					
					Account account;
					if(accChoice==1) {
						account=(Account) context.getBean("currentAccount");
					}
					else
					{
						account=(Account) context.getBean("savingsAccount");
					}
					
					account.addBalance(balance);
					user.addAccount(account);
					
					System.out.println("Do you want to add more accounts ");
					System.out.println("1)Yes \n2)No ");
				
		}
				System.out.println("\nUser " + user.getName() + " has the following accounts:");
		        for (Account acc : user.getAllAccounts()) {
		            System.out.println(acc.getAccountType() + " - Balance: " + acc.getBalance() + " (Ref ID: " + acc.hashCode() + ")");
		        }

		 
		        sc.close();
		        context.close();
			
		
		
		
		
		

	}

}
