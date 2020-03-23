package restaurant;

interface IRestaurant {

	boolean isTableAvailable();
	
	String assignCustomer();

	String checkoutCustomer(String customerId);
}