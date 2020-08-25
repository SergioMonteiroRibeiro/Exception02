package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
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
		
		if (account.getBalance() == 0 || amount > account.getWithdrawLimit()) {
			System.out.println("Withdraw error: The amount exceeds withdraw limit ");
		}
		else {
			account.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f",account.getBalance()));
		}
		
		sc.close();
	}
}
