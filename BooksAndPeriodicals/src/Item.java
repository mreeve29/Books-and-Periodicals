
public abstract class Item implements Comparable{
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
	
	public abstract int compareTo(Object o);
}
