package javafinalproject;

public class Console {
	
	private int gstTax;
	private Store storeClass;
	private Bill billClass;
	
	Console(){
		storeClass = new Store();
		billClass = new Bill(storeClass.getStoreItems(), gstTax);
	}
	
	
	private void displayMenu() {
		
	}
	
	private void getTaxInfo() {
		
	}
	
	

}
