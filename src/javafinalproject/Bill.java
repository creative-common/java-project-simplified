package javafinalproject;

import java.util.ArrayList;

public class Bill {
	
	ArrayList<BillModel> billItems;
	ArrayList<ItemModel> storeItems;
	private int taxPercentage;
	
	Bill(ArrayList<ItemModel> storeItems, int taxPercentage){
		this.billItems = new ArrayList<BillModel>();
		this.storeItems = storeItems;
		this.taxPercentage = taxPercentage;
	}
	
	public void newBill(){
		this.billItems = new ArrayList();
	}
	
	public void addItem(BillModel billItem) {
		//If billItem already exist update the quantity and price
		if(checkBillItem(billItem.getCode())) {
			
			//get index value of earlier value
			int earlierIndex = getBillItemIndexFromCode(billItem.getCode());
			
			//get earlier qty
			int earlierQuantity = this.billItems.get(earlierIndex).getQuantity();
			
			//calculate new qty
			int newQuantity = earlierQuantity + billItem.getQuantity();
			
			//set the new quantity
			this.billItems.get(earlierIndex).setQuantity(newQuantity);
			
			//set the billItem name
			this.billItems.get(earlierIndex).setName(this.storeItems.get(getStoreItemIndexFromCode(billItem.getCode())).getName());	
			
			//get per item price 
			
			int perItemPrice = (int) this.storeItems.get(getStoreItemIndexFromCode(billItem.getCode())).getPrice();
			
			//Calculate new price
			int newPriceTotal = perItemPrice * newQuantity;
			
			////set the new Price
			this.billItems.get(earlierIndex).setPrice(newPriceTotal);
			
		}else {
			
			//get index value of billItemIndexValue value
			int billItemIndexValue = getBillItemIndexFromCode(billItem.getCode());
			
			//set the billItem name
			this.billItems.get(billItemIndexValue).setName(this.storeItems.get(getStoreItemIndexFromCode(billItem.getCode())).getName());	
			
			
			this.billItems.add(billItem);
		}
		print("Bill item added successfully!");
		printBill();
	}
	
	//For deleting billItem from the billItem ArrayList
	public void deleteItem(int itemCode) {
		//check if exist or not
		if(checkBillItem(itemCode)) { //If exist
			//Get Item Index from code and delete the billItem from array
			this.billItems.remove(getBillItemIndexFromCode(itemCode));
		}else {
			print("Bill item not exist.");
		}
	}
	
	
	
	//Helper methods
	
	public void printBill() {
		print("---------------------------------------------");
		print("Item		Price");
		for(int i = 0; i< this.billItems.size(); i++) {
			print(this.billItems.get(i).getName() +"		"+ this.billItems.get(i).getPrice());
		}
		print("---------------------------------------------");
	}
	
	

	/****
	 * Private Helper Class Functions
	 * 
	 * ****/
	
	//For checking even billItem exist or not
	private boolean checkBillItem(int itemCode) {
			for(int i=0; i< this.billItems.size(); i++) {
				if(this.billItems.get(i).getCode() == itemCode) {
					return true;
				}
			}
			return false;
	}
	
	//For checking even billItem exist or not
		private boolean checkStoreItem(int itemCode) {
				for(int i=0; i< this.storeItems.size(); i++) {
					if(this.storeItems.get(i).getCode() == itemCode) {
						return true;
					}
				}
				return false;
		}
	
	
	private int getBillItemIndexFromCode(int itemCode) {
		for(int i=0; i< this.billItems.size(); i++) {
			if(this.billItems.get(i).getCode() == itemCode) {
				return i;
			}
		}
		return -1;
	}
	
	private int getStoreItemIndexFromCode(int itemCode) {
		for(int i=0; i< this.storeItems.size(); i++) {
			if(this.storeItems.get(i).getCode() == itemCode) {
				return i;
			}
		}
		return -1;
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	

}
