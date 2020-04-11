package javafinalproject;

public class BillModel extends ItemModel {

	int quantity;
	
	public BillModel(int code, String name, float price, int quantity) {
		super(code, name, price);
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
