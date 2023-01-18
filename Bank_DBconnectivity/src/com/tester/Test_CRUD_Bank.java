package com.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.pojo.Account;
import com.pojo.AccountDAL;

public class Test_CRUD_Bank {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		while(true) {
		    System.out.println("Enter ur choice:");
		    System.out.println("press 1 to add account");
			System.out.println("press 2 to delete account");
			System.out.println("press 3 to display account");
			System.out.println("press 4 to exit..");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				//add account
				System.out.println("Enter account ID:");
				int id=sc.nextInt();
				
				System.out.println("Enter account name:");
				String name=sc.next();
				
				System.out.println("Enter account type:");
				String type=sc.next();
				
				System.out.println("Enter account balance:");
				Double balance=sc.nextDouble();
				
				//create account object to store account details
				Account acc=new Account(id, name, type, balance);
				boolean ans=AccountDAL.insertAccountToDB(acc);
				if(ans) {
					System.out.println("account added successfully..");
				}
				else {
					System.out.println("something went wrong");
				}
				System.out.println(acc);
				break;
				
			case 2:
				//delete account
				System.out.println("enter account id to delete account:");
				int AccId = sc.nextInt();
				boolean f=AccountDAL.deleteAccount(AccId);
				
				if(f) {
					System.out.println("Deleted successfully...");
				}
				else {
					System.out.println("Something went wrong...");
				}
				break;
			
			case 3:
				//display
				AccountDAL.showAccountDetails();
				break;
				
			case 4:
				if(ch==4)
				break;
			}
		}
	}

}
