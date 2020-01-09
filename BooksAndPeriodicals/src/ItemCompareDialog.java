import BreezySwing.*;

import java.awt.Font;

import javax.swing.*;
@SuppressWarnings("serial")
public class ItemCompareDialog extends GBDialog{

	//class objects
	private Library lib;
	
	private JLabel instructions = addLabel("Click item to compare it",1,1,1,1);
	private JList<String> itemList = addList(2,1,1,1);
	
	private JLabel beforeLabel = addLabel("Items before:",1,2,1,1);
	private JTextArea itemBeforeArea = addTextArea("",2,2,1,1);
	
	private JLabel afterLabel = addLabel("Items after:",1,3,1,1);
	private JTextArea itemAfterArea = addTextArea("",2,3,1,1);
	
	private JLabel equalsLabel = addLabel("Items that equal:",1,4,1,1);
	private JTextArea itemEqualsArea = addTextArea("",2,4,1,1);
	
	private JButton closeButton = addButton("Close",3,2,1,1);
	
	private Item selected;
	
	public void buttonClicked(JButton button) {
		if(button == closeButton) {
			dispose();
		}
	}
	
	//constructor
	public ItemCompareDialog(JFrame parent, Library l) {
		super(parent);
		
		lib = l;
		
		itemBeforeArea.setEditable(false);
		itemBeforeArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		itemAfterArea.setEditable(false);
		itemAfterArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		itemEqualsArea.setEditable(false);
		itemEqualsArea.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		populateList();
		
		this.setTitle("Compare Items");
		this.setSize(800,500);
		this.setVisible(true);
	}

	//adds items to list
	private void populateList() {
		if(lib.getItems().size() == 0)return;
		for(Item i : lib.getItems()) {
			addItemToList(i.getName());
		}
	}
	
	//helper method to add single String to list
	private void addItemToList(String add) {
		DefaultListModel<String> model = (DefaultListModel<String>)itemList.getModel();
        model.addElement(add);
	}
	
	//list event listeners
	public void listItemSelected(JList<String> list) {
		selected = lib.getItem(list.getSelectedIndex());
		compare();
	}
	
	public void listDoubleClicked(JList<String> list, String itemClicked) {
		selected = lib.getItem(list.getSelectedIndex());
		compare();
	}
	
	private void compare() {
		itemBeforeArea.setText("");
		itemAfterArea.setText("");
		itemEqualsArea.setText("");
		for(Item i : lib.getItems()) {
			if(i == selected)continue;
			int compare;
			try {
				compare = selected.compareTo(i);
			}catch (ClassCastException e){
				continue;
			}
			if(compare > 0) {
				//add to before
				itemBeforeArea.append(i.print() + "\n\n");
			}else if (compare < 0) {
				//add to after
				itemAfterArea.append(i.print() + "\n\n");
			}else {
				//same
				itemEqualsArea.append(i.print() + "\n\n");
			}
		}
	}

}