package restaurant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Abhishek Verma
 *
 *Restaurant
 *Tables
 *Menu
 *Items
 *Bill
 *Customer
 *Order
 *
 *
 * Restaurant <>- Tables
 * Menu -<> Restaurant
 * Items -<> Menu
 * Restaurant -> Customers
 * Order -<> Customer
 * Bill -<> Customer
 * 
 */
class Restaurant implements IRestaurant {
	private List<Tables> tableList;
	private List<Customer> customerList;
	private HashMap<Integer, Item> menuMap;
	private static AtomicLong idCounter = new AtomicLong();
	
	Restaurant(List<Tables> tableList, HashMap<Integer, Item> menuMap){
		this.tableList = tableList;
		this.menuMap = menuMap;
	}
	
	@Override
	public String assignCustomer(){
		//Check if is tableAvailable
		//Assign customerId;
		//Book table;
		//return customerId
		if(isTableAvailable()) {
			for (Tables table : tableList) {
				if(table.isAvailable()) {
					String customerId = createCustomerID();
					//book table
					table.setAvailable(false);
					table.getTableId();
					table.setCustomerAssigned(customerId);
					//init customer
					if(customerList == null) {
						customerList = new ArrayList<Customer>();
					}
					Customer customer = new Customer(customerId);
					customerList.add(customer);
					
					return customerId;
				}
			}
		}
		return null;
	}
	
	@Override
	public String checkoutCustomer(String customerId) {
		//generate bill
		//make table free
		if(customerId != null) {
			for(Customer customer : customerList) {
				if(customer.getCustomerId().equals(customerId)) {
					ItemOrdered itemOrdered = customer.checkOutCustomer();
					List<Item> items = itemOrdered.getOrderedItems();
					Bill bill = new Bill(customerId, items);
					
					for (Tables table : tableList) {
						if(null != table.getCustomerAssigned() && table.getCustomerAssigned().equals(customerId)) {
							//free table
							table.setAvailable(true);
							table.setCustomerAssigned(null);
							//remove customer
							customerList.remove(customer);
							
							return bill.toString();
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean isTableAvailable() {
		for (Tables table : tableList) {
			if(table.isAvailable())
				return true;
		}
		return false;
	}
	
	public List<Customer> getDiningCustomers(){
		return this.customerList;
	}
	
	public boolean addToCustomerOrder(String customerId, int itemId) {
		for(Customer customer : customerList) {
			if(customer.getCustomerId().equals(customerId)) {
				customer.addToOrder(menuMap.get(itemId));
				return true;
			}
		}
		return false;
	}
	
	public boolean removeFromCustomerOrder(String customerId, int itemId) {
		for(Customer customer : customerList) {
			if(customer.getCustomerId().equals(customerId)) {
				customer.removeFromOrder(menuMap.get(itemId));
				return true;
			}
		}
		return false;
	}
	
	private static String createCustomerID()
	{
	    return String.valueOf(idCounter.getAndIncrement());
	}
}
