package javafinalproject;

import java.util.Scanner;

public class StoreConsoleManager {

	public void addStoreItem(Store store) {
		String itemName;
		int itemCode;
		float itemPrice;
		
		Scanner itemNameInputScanner = new Scanner(System.in);
		Scanner itemCodeScanner = new Scanner(System.in);
		Scanner itemPriceScanner = new Scanner(System.in);
		
		print("Enter item code: ");
		itemCode = itemCodeScanner.nextInt();
		
		if(store.checkItem(itemCode)) {
			//give error
			print("Item code already exist");
			//restart the addItem
			addStoreItem(store);
		}else {
			print("Enter item name: ");
			itemName = itemCodeScanner.nextLine();
			
			print("Enter item price for "+itemName + ":");
			itemPrice = itemPriceScanner.nextFloat();
			store.addItem(new ItemModel(itemCode, itemName, itemPrice));
		}
		
	}
	
	
	public void deleteStoreItem(Store store) {
		int itemCode;
		Scanner itemCodeScanner = new Scanner(System.in);
		
		print("Enter item code: ");
		itemCode  = itemCodeScanner.nextInt();
		
		if(!store.checkItem(itemCode)) {
			store.deleteItem(itemCode);
		}else {
			print("Item code do not exist.");
		}
		
	}
	
	
	private void print(String message) {
		System.out.println(message);
	}

	
}
