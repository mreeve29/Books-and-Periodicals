
public abstract class Item implements Comparable<Item>{
	//class 
	private String name;
	
	//constructor
	public Item(String str) {
		name = str;
	}
	
	//name setter
	public void setName(String str) {
		name = str;
	}
	
	//name getter
	public String getName() {
		return name;
	}
	
	//abstracts
	
	//prints all info
	public abstract String print();
	
	//prints basic info
	public abstract String info();
	
	//compares other items to each other
	public abstract int compareTo(Item o);
}
