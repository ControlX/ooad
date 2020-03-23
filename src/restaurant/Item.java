package restaurant;
// ID, Name, Price
public class Item {
	private int itemId;
	private String itemName;
	private int itemPrice;
	
	Item(int itemId, String itemName, int itemPrice){
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}
}
