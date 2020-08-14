package com.learning.bankappdemo;

import java.util.Scanner;

public class BankAccount {

	double balance=10000;
	double prevTrans;
	String customerName;
	String customerId;
	
	char storeVar;

	int trans= 0;
	
	BankAccount(String customerName, String customerId)
	{
		this.customerName = customerName;
		this.customerId = customerId;
		
	}
	
	void deposit(float amount)
	{
		double charge = 0;
		if(amount > 0)
		{
			if(storeVar=='d' && trans > 0)
			{
				charge=amount * 0.0020;
				balance = balance + ( amount - charge);
				prevTrans = amount;
				storeVar='d';
			}
			else if(storeVar=='w' && trans > 0)
			{
				charge=amount * 0.0040;
				balance = balance + ( amount - charge);
				prevTrans = amount;
				storeVar='d';
			}
			else 
			{
				balance = balance + amount;
				prevTrans= amount;
				trans++;
				storeVar='d';
			}
			
			System.out.println("You Deposited "+amount+" Rs.");
			System.out.println("The charge is "+charge+" and Balance : "+balance+" Rs.");
		}
		else
		{
			System.out.println("Invalid Amount");
		}
	}
	
	void withdraw(float amount)
	{
		double charge = 0;
		if(balance < amount)
		{
			System.out.println("Not Sufficient balance");
		}
		
		if(amount <= 0)
		{
			System.out.println("Invalid Amount");
		}
		else if(balance > amount)
		{
			if(storeVar=='w' && trans > 0)
			{
				charge=amount * 0.0025;
				balance = balance - (amount - charge);
				prevTrans = -amount;
				storeVar='w';
			}
			else if(storeVar=='d' && trans > 0)
			{
				charge=amount * 0.0050;
				balance = balance - ( amount - charge);
				prevTrans = -amount;
				storeVar='w';
			}
			else 
			{
				balance = balance - amount;
				prevTrans= -amount;
				trans++;
				storeVar='w';
			}
			
			System.out.println("You Withdrawed "+amount+" Rs.");
			System.out.println("The charge is "+charge+" and Balance : "+balance+" Rs.");
		}
		
	}
	
	void getPrevTrans()
	{
		if(prevTrans > 0)
		{
			System.out.println("Deposited : "+prevTrans);
		}
		else if(prevTrans < 0)
		{
			System.out.println("Withdrawn : "+Math.abs(prevTrans));
		}
		else 
		{
			System.out.println("No Transcation Occured!!!");
		}
	}
	
	void menu()
	{
		
		int choice;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*********************");
		System.out.println("Welcome :"+customerName);
		System.out.println("Your Id is : "+customerId);
		System.out.println("*********************");
		System.out.println();
		System.out.println("1.Balance");
		System.out.println("2.Deposit");
		System.out.println("3.Withdraw");
		System.out.println("4.Previous Transcation");
		System.out.println("5.Exit");
		System.out.println("*********************");
		System.out.println();
		
		
		do {
			
			System.out.println("Enter an option:");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1 : 
				System.out.println("---------------------------------------------");
				System.out.println("Balance :"+ balance);
				System.out.println("---------------------------------------------");
				System.out.println();
				break;
				
			case 2 :
				System.out.println("---------------------------------------------");
				System.out.println("Enter an amount to deposit :");
				float amt1=sc.nextInt();
				deposit(amt1);
				
				System.out.println("---------------------------------------------");
				System.out.println();
				break;
				
			case 3 :
				System.out.println("---------------------------------------------");
				System.out.println("Your Balance : "+ balance);
				System.out.println();
				System.out.println("Enter an amount to withdraw :");
				float amt2=sc.nextInt();
				withdraw(amt2);
				
				System.out.println("---------------------------------------------");
				System.out.println();
				break;
				
			case 4 :
				System.out.println("----------------------------------------------");
				getPrevTrans();
				System.out.println("----------------------------------------------");
				System.out.println();
				break;
				
			case 5:
				System.out.println("********************");
				break;
				
			default:
				System.out.println("********************");
				System.out.println("Invalid key please select the correct option!!!");
				System.out.println("********************");
				
			}
			
		}while(choice!=5);
		
		System.out.println("Thank You");
	}
}
