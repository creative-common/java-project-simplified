package javafinalproject;

import java.util.Scanner;


//Store Controller Class
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
		store.deleteItem(itemCode);
	}
	
	public void printStoreItems(Store store) {
		store.printItems();
	}
	
	
	public void addBillItem(Bill bill) {
		String itemName = ""; //Intialize empty here would be taken care by bill Class autoamtically
		int itemCode;
		float itemPrice = 0; //Intialize 0 here would be taken care by bill Class autoamtically
		int itemQty;
		
		Scanner itemCodeScanner = new Scanner(System.in);
		Scanner itemQtyScanner = new Scanner(System.in);
		
		print("Enter item code: ");
		itemCode = itemCodeScanner.nextInt();
		
		print("Enter item qty for "+itemCode + ":");
		itemQty = itemQtyScanner.nextInt();
			
		bill.addItem(new BillModel(itemCode, itemName, itemPrice, itemQty));
		
	}
	
	public void deleteBillItem(Bill bill) {
		int itemCode;
		Scanner itemCodeScanner = new Scanner(System.in);
		
		print("Enter item code: ");
		itemCode  = itemCodeScanner.nextInt();
		bill.deleteItem(itemCode);
		
	}
	
	public void printCurrentBill(Bill bill) {
		bill.printBill();
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	

	
}
