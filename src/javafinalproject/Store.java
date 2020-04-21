package javafinalproject;

import java.util.ArrayList;

public class Store {
	
	private ArrayList<ItemModel> storeItems;
	
	Store(){
		this.storeItems = new ArrayList();
	}
	
	
	public ArrayList<ItemModel> getStoreItems() {
		return this.storeItems;
	}
	
	
	//add Item check the item code already exist or not
	//and add the unique values
	public void addItem(ItemModel itemModel){
		
		int itemCode = itemModel.getCode();
		
		//Check Store Item don't Exist earlier
		if(checkItem(itemCode)) { 
			System.out.printf("Item %f already exist.\n", itemCode);
		}else {
			//Add Store Item
			this.storeItems.add(itemModel);
		}
		
	}
	
	public void deleteItem(int itemCode){
		//If itemCode exist
		if(checkItem(itemCode)) {
			//Get Item Index from code and delete the product from array
			this.storeItems.remove(getItemIndexFromCode(itemCode));
			print("Item code " + itemCode + " deleted successfully.");
		}else {
			//print error
			print("Item code " + itemCode + " don't exist.");
		}
	}
	
	//Print the items of the arrayList
	public void printItems() {
		for(int i=0; i< this.storeItems.size(); i++) {
			print("----------------------------------------------");
				print("Code: " + this.storeItems.get(i).getCode());
				print("Name: " + this.storeItems.get(i).getName());
				print("Price: $" + this.storeItems.get(i).getPrice());
			print("----------------------------------------------");
		}
	}
	
	
	//For checking even storeItem exist or not
	public boolean checkItem(int itemCode) {
		for(int i=0; i< this.storeItems.size(); i++) {
			if(this.storeItems.get(i).getCode() == itemCode) {
				return true;
			}
		}
		return false;
	}
	
	
	
	/****
	 * Private Helper Class Functions
	 * 
	 * ****/
	private int getItemIndexFromCode(int itemCode) {
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
