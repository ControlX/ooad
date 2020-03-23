package restaurant;


//Customer id, Food ordered, 
public class Customer {
	private String customerId;
	private ItemOrdered itemsOrdered;
	// pass menu
	// create common interface to have itemId as common which will be used at other places
	
	Customer(String customerId){
		this.customerId = customerId;
		itemsOrdered = new ItemOrdered(customerId);
	}
	
	public void addToOrder(Item item) {
		itemsOrdered.addItem(item);
	}
	
	public void removeFromOrder(Item item) {
		itemsOrdered.removeItem(item);
	}
	
	public ItemOrdered checkOutCustomer() {
		return this.itemsOrdered;
	}
	
	public String getCustomerId() {
		return this.customerId;
	}
}
