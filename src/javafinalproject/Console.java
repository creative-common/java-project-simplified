package javafinalproject;

import java.util.Scanner;

public class Console {
	
	private int gstTax = 0;
	private Store storeClass;
	private Bill billClass;
	
	Console(){
		storeClass = new Store();
		if(gstTax == 0) {
			getTaxInfo();
		}
				
	}
	
	
	private void displayMenu() {
		print("*************************");
		print("Simple POS Module");
		print("*************************");
		print("1. Add Products");
		print("2. Delete Products");
		print("3. View Products");
		print("4. Update Tax Percentage");
		print("5. Reset Bill");
		print("6. Add Bill Item");
		print("7. Delete Bill Item");
		print("8. View Bill");
		print("Enter 1-8 to choose operation");
		
	}
	
	private void consoleManager() {
		StoreConsoleManager storeConsoleManager = new StoreConsoleManager();
		Scanner selectedOperation = new Scanner(System.in);
		int menuSelection = selectedOperation.nextInt();
		switch(menuSelection){
			case 1: 
				storeConsoleManager.addStoreItem(storeClass);
				break;
			case 2:
				storeConsoleManager.deleteStoreItem(storeClass);
				break;
			case 3:
				storeConsoleManager.printStoreItems(storeClass);
				break;
			case 4:
				getTaxInfo();
				break;
			case 5:
				billClass.newBill();
				break;
			case 6:
				storeConsoleManager.addBillItem(billClass);
				break;	
			case 7:
				storeConsoleManager.deleteBillItem(billClass);
				break;
			case 8:
				storeConsoleManager.printCurrentBill(billClass);
				break;
			default:
				print("Choose the correct option from 1-8");
				break;
		
		}
		
	}
	
	private void getTaxInfo() {
		print("Please enter new tax percentage.");
		Scanner taxInputScanner = new Scanner(System.in);
		gstTax = taxInputScanner.nextInt();
		print("Success! New tax percentage is " + gstTax);
		
		//Intialize the class after taking tax value
		billClass = new Bill(storeClass.getStoreItems(), gstTax);
		
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	

}
