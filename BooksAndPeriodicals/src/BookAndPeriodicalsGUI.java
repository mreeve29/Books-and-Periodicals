import BreezySwing.*;
import javax.swing.*;

public class BookAndPeriodicalsGUI extends GBFrame{

	//class objects & swing elements
	private Library lib = new Library();

	private JButton addItemButton = addButton("Add Item",1,1,1,1);
	private JButton printItemsButton = addButton("Print Items",2,1,1,1);
	private JButton compareButton = addButton("Compare Items",3,1,1,1);
	private JButton quitButton = addButton("Quit",4,1,1,1);
	
	//button event listener
	public void buttonClicked(JButton button) {
		if(button == addItemButton) {
			new AddItemDialog(this, lib);
		}else if (button == printItemsButton){
			new OutputDialog(this,lib.getItems(),"All Items:","All Items");
		}else  if(button == compareButton) {
			new ItemCompareDialog(this,lib);
		}else if(button == quitButton) {
			System.exit(1);
		}
	}
	
	//main
	public static void main(String[] args) {
		BookAndPeriodicalsGUI frm = new BookAndPeriodicalsGUI();
	}
	
	//constructor
	public BookAndPeriodicalsGUI() {
		setTitle("Books and Periodicals");
		setSize(400,400);
		setVisible(true);
	}

}
