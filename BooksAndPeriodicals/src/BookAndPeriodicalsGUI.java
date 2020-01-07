import BreezySwing.*;
import javax.swing.*;

public class BookAndPeriodicalsGUI extends GBFrame{

	private Library lib = new Library();

	private JButton addItemButton = addButton("Add Item",1,1,1,1);
	private JButton printAllButton = addButton("Print All",2,1,1,1);
	
	
	public void buttonClicked(JButton button) {
		if(button == addItemButton) {
			new AddItemDialog(this, lib);
		}else if(button == printAllButton) {
			new OutputDialog(this,lib.getItems(),"All Items:","All Items");
		}
	}
	
	public static void main(String[] args) {
		BookAndPeriodicalsGUI frm = new BookAndPeriodicalsGUI();
		
		Item book1 = new Book("Dictionary", "Webster");
		Item Magazine1  = new Periodical("Sports Illustrated", 345);

		System.out.println(book1.print());
		System.out.println(Magazine1.print());
		
	}
	
	public BookAndPeriodicalsGUI() {
		setTitle("Books and Periodicals");
		setSize(400,400);
		setVisible(true);
	}

}
