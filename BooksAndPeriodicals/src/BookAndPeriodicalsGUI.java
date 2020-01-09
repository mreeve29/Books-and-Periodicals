import BreezySwing.*;

import java.util.Collections;

import javax.swing.*;

public class BookAndPeriodicalsGUI extends GBFrame{

	private Library lib = new Library();

	private JButton addItemButton = addButton("Add Item",1,1,1,1);
	private JButton compareButton = addButton("Compare Items",3,1,1,1);
	
	
	public void buttonClicked(JButton button) {
		if(button == addItemButton) {
			new AddItemDialog(this, lib);
		}else  if(button == compareButton) {
			new ItemCompareDialog(this,lib);
		}
	}
	
	public static void main(String[] args) {
		BookAndPeriodicalsGUI frm = new BookAndPeriodicalsGUI();
	}
	
	public BookAndPeriodicalsGUI() {
		setTitle("Books and Periodicals");
		setSize(400,400);
		setVisible(true);
	}

}
