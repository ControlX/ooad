package restaurant;
import java.util.List;

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
public class Restaurant {
	private List<Tables> tableList;
	private List<Customer> customerList;
	private List<Item> menuList;
	
	Restaurant(){
		
	}
}
