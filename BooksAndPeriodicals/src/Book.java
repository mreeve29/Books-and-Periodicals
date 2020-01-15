
public class Book extends Item{

	//class object
	private String author;
	
	//constructor
	public Book(String str, String a) {
		super(str);
		author = a;
	}
	
	//author setter
	public void setAuthor(String str) {
		author = str;
	}

	//author getter
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String print() {
		return "Name: " + getName() + '\n' +
				"Author: " + getAuthor();
	}

	//compare method, compares author to other books
	@Override
	public int compareTo(Item o) throws ClassCastException {
		if(!(o instanceof Book)) {
			throw new ClassCastException("Cannot cast object to Book");
		}
		Book b = (Book)o;
		
		return b.getAuthor().toLowerCase().compareTo(author.toLowerCase());
	}

	@Override
	public String info() {
		return getName() +  " - " + author;
	}

}
