
public class Book extends Item implements Comparable{

	private String author;
	
	public Book(String str, String a) {
		super(str);
		author = a;
	}
	
	public void setAuthor(String str) {
		author = str;
	}

	public String getAuthor() {
		return author;
	}
	
	@Override
	public String print() {
		return "Name: " + getName() + '\n' +
				"Author: " + getAuthor();
	}

	@Override
	public int compareTo(Object o) throws ClassCastException {
		if(!(o instanceof Book)) {
			throw new ClassCastException("Cannot cast object to Book");
		}
		Book b = (Book)o;
		
		return author.compareTo(b.getAuthor());
	}

}
