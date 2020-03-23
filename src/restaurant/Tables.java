package restaurant;
// Booked or Free
// Customer Id if booked
public class Tables {
	private int tableId;
	private boolean isAvailable;
	private String customerAssigned;
	
	Tables(int tableId, boolean isAvailable, String customerAssigned){
		this.tableId = tableId;
		this.isAvailable = isAvailable;
		this.customerAssigned = customerAssigned;
	}

	public int getTableId() {
		return tableId;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public String getCustomerAssigned() {
		return customerAssigned;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setCustomerAssigned(String customerId) {
		this.customerAssigned = customerId;
	}
}
