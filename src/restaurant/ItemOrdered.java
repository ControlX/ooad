package restaurant;

import java.util.ArrayList;
import java.util.List;

public class ItemOrdered {
	private List<Item> orderedItem;
	private String customerId;
	
	ItemOrdered(String customerId){
		this.customerId = customerId;
		orderedItem = new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		orderedItem.add(item);
	}
	
	public void removeItem(Item item) {
		orderedItem.remove(item);
	}
	
	public String getCustomerId() {
		return this.customerId;
	}
	
	public List<Item> getOrderedItems(){
		return this.orderedItem;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Item item : orderedItem)
		{
		    sb.append(item.getItemId());
		    sb.append("\t");
		    sb.append(item.getItemName());
		    sb.append("\t");
		    sb.append(item.getItemPrice());
		    sb.append("\n");
		}
		return sb.toString();
	}
}
