package javafinalproject;

import java.util.Scanner;

public class Console {
	
	private int gstTax;
	private Store storeClass;
	private Bill billClass;
	
	Console(){
		storeClass = new Store();
		billClass = new Bill(storeClass.getStoreItems(), gstTax);
	}
	
	
	private void displayMenu() {
		print("*************************");
		print("Simple POS Module");
		print("*************************");
		print("1. Add Products");
		print("2. Delete Products");
		print("3. View Products");
		print("4. Generate Bill");
		print("5. Update Tax Percentage");
		print("Enter 1-5 to choose operation");
		
	}
	
	private void consoleManager() {
		Scanner selectedOperation = new Scanner(System.in);
		int menuSelection = selectedOperation.nextInt();
		switch(menuSelection){
			case 1: 
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			default:
				
				break;
		
		}
		
	}
	
	private void getTaxInfo() {
		print("Please enter new tax percentage.");
		Scanner taxInputScanner = new Scanner(System.in);
		gstTax = taxInputScanner.nextInt();
		print("Success! New tax percentage is " + gstTax);
		
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	

}
