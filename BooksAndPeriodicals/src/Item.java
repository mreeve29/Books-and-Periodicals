
public abstract class Item implements Comparable<Item>{
	private String name;
	
	public Item(String str) {
		name = str;
	}
	
	public void setName(String str) {
		name = str;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String print();
	
	public abstract String info();
	
	public abstract int compareTo(Item o);
}
