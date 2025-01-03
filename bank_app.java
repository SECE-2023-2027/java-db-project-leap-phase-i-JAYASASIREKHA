package com.org.bank;

import java.util.Scanner;
import com.org.bank.dao.AccountDAO;
import com.org.bank.dao.AccountDaoImpl;
import com.org.bank.dao.TransactionDAO;
import com.org.bank.dao.transactiondaoimpl;
import com.org.bank.model.Account;



public class bank_app {
	public static void main(String args[]) throws Exception {
		AccountDAO accountDAO = new AccountDaoImpl();
		TransactionDAO transactionDAO = new transactiondaoimpl();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n=== Banking Application Menu ===");
			System.out.println("1.Create a new Account");
			System.out.println("2.View Account Details");
			System.out.println("3.Update Account Information");
			System.out.println("4.Deposit Money");
			System.out.println("5.Withdraw Money");
			System.out.println("6.Transfer Money");
			System.out.println("7.View Transaction");
			System.out.println("8.Check Balance");
			System.out.println("9.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Account Holder Name: ");
				String accountholder = sc.nextLine();
				System.out.println("Enter account type (Savings/Current):");
				String accountType = sc.nextLine();
				System.out.println("Enter Initial balance");
				double balance = sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter address: ");
				String address = sc.nextLine();
				System.out.println("Enter conrtact number: ");
				String contactNumber = sc.nextLine();
				Account newAccount = new Account(0,accountholder, accountType,balance,address,contactNumber);
				try {
					accountDAO.createAccount(newAccount);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.print("Enter account ID to view:");
				int viewAccountId = sc.nextInt();
				Account retrievedAccount = accountDAO.viewAccount(viewAccountId);
				if(retrievedAccount !=null) {
					System.out.println("Account Details:"+retrievedAccount);
				
				}
				else {
					System.out.println("Account not found");
				}
				break;
			case 3:
				System.out.print("Enter account ID to update:");
				int updateAccountId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter new address:");
				String newAddress = sc.nextLine();
				System.out.print("Enter new contact number:");
				String newContact = sc.nextLine();
				accountDAO.updateAccountInfo(updateAccountId, newAddress, newContact);
				break;
			
			case 4:
			        	   System.out.println("Enter Account ID for deposit:");
			               int depositAccountId = sc.nextInt();
			               System.out.print("Enter deposit amount: ");
			               double depositAmount = sc.nextDouble();
			               transactionDAO.deposit(depositAccountId, depositAmount);
			               
			           break;
			case 5:
				System.out.print("Enter account ID to withdraw from:");
				int withdrawAccountId = sc.nextInt();
				System.out.print("Enter amount to withdraw:");
				double withdrawAmount = sc.nextDouble();
				transactionDAO.withdraw(withdrawAccountId, withdrawAmount);
				break;
			}
			}
	}

}
