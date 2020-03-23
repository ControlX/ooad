package restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InitRestaurant {
	private static List<String> customerStringList = new ArrayList<>();
	
	public static void main(String[] args) {

		HashMap<Integer, Item> menuMap = new HashMap<>();
		menuMap.put(1, new Item(1, "Paneer", 251));
		menuMap.put(2, new Item(2, "Aloo", 252));
		menuMap.put(3, new Item(3, "Dal Makhani", 253));
		menuMap.put(4, new Item(4, "Dal Toor", 254));
		menuMap.put(5, new Item(5, "Methi Aloo", 255));
		menuMap.put(6, new Item(6, "Mattar Gobhi", 256));
		menuMap.put(7, new Item(7, "Aloo Gobhi", 257));
		menuMap.put(8, new Item(8, "Mushroom", 258));
		menuMap.put(9, new Item(9, "Garlic Roti", 259));
		
		
		List<Tables> tableList = new ArrayList<>();
		tableList.add(new Tables(11, true, null));
		tableList.add(new Tables(12, true, null));
		tableList.add(new Tables(13, true, null));
		tableList.add(new Tables(14, true, null));
		tableList.add(new Tables(15, true, null));
		
		Restaurant restaurant = new Restaurant(tableList, menuMap);
		
		String s = restaurant.assignCustomer();
		if(s != null) {
			customerStringList.add(s);
		}
		
		s = restaurant.assignCustomer();
		if(s != null) {
			customerStringList.add(s);
		}
		
		s = restaurant.assignCustomer();
		if(s != null) {
			customerStringList.add(s);
		}
		
		restaurant.addToCustomerOrder(customerStringList.get(0), 1);
		restaurant.addToCustomerOrder(customerStringList.get(0), 4);
		restaurant.addToCustomerOrder(customerStringList.get(0), 9);
		restaurant.addToCustomerOrder(customerStringList.get(0), 9);
		
		restaurant.addToCustomerOrder(customerStringList.get(1), 2);
		restaurant.addToCustomerOrder(customerStringList.get(1), 9);
		
		System.out.println(restaurant.checkoutCustomer(customerStringList.get(0)));
		System.out.println(restaurant.checkoutCustomer(customerStringList.get(1)));
		System.out.println(restaurant.checkoutCustomer(customerStringList.get(2)));
	}
}
