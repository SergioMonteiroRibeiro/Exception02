package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("----------BANK ACCOUNT---------");
			System.out.println();
			System.out.print("Enter the account number: ");
			int number = sc.nextInt();
			System.out.print("Enter the account holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Enter the account initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Enter the account withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit); 
			
			System.out.println();
			System.out.print("Enter the amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
	
		sc.close();
	}
}
