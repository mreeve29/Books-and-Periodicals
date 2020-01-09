import java.util.ArrayList;

public class Library {
	
	//class objects
	private ArrayList<Item> items = new ArrayList<Item>(); //holds all items
	
	public void addItem(Item i) {
		items.add(i);
	}
	
	public Item getItem(int i) {
		return items.get(i);
	}
	
	public int getAmountOfItems() {
		return items.size();
	}
	
	public ArrayList<Item> getItems(){
		return items;
	}
	
	
	//constructor
	public Library() {
	}
}
