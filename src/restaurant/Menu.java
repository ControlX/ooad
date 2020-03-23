package restaurant;
import java.util.List;

// List of item
public class Menu {
	private List<Item> menuItems;
	
	Menu(List<Item> menuItems){
		this.menuItems = menuItems;
	}

	public List<Item> getMenuItems() {
		return menuItems;
	}
}
