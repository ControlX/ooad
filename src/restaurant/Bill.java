package restaurant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

public class Bill implements IBill {
	private int billId;
	private String customerId;
	private String dateTime;
	private List<Item> orderList;

	Bill(String customerId, List<Item> orderList){
		this.customerId = customerId;
		this.orderList = orderList;
	}
	
	public Bill fetchBill() {
		return this;
	}
	
	public int calculateTotal() {
		Stream<Item> orderStream = orderList.stream();
		Integer sum = orderStream.mapToInt(o -> o.getItemPrice()).sum();
		return sum;
	}

	private String itemsOrdered() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		for (Item item : orderList)
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

	private String dateTime() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		this.dateTime = localDate.toString() + "  " + localTime.toString();
		return dateTime;
	}

	private int billId() {
		return this.billId;
	}

	private String customerId() {
		return this.customerId;
	}
	
	@Override
	public String toString() {
		return "Items: " + itemsOrdered() + "\n\nTotal: " + calculateTotal() +  "\n\nDate: " + dateTime() + "\n\nCustomerId: " + customerId() + "\n------------------------\n\n";
	}
}
