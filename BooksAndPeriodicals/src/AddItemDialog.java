import BreezySwing.*;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
@SuppressWarnings("serial")
public class AddItemDialog extends GBDialog{

	//swing elements
	
	private ButtonGroup itemTypeBG = new ButtonGroup();
	private JRadioButton bookButton = addRadioButton("Book",1,1,1,1);
	private JRadioButton periodicalButton = addRadioButton("Periodical",1,2,1,1);
	
	
	
	@SuppressWarnings("unused")
	private JLabel titleLabel = addLabel("Title:",2,1,1,1);
	private JTextField titleField = addTextField("",2,2,1,1);
	
	private JLabel bookAuthorLabel = addLabel("Book Author:",3,1,1,1);
	private JTextField bookAuthorField = addTextField("",3,2,1,1);
	
	private JLabel periodicalNumberLabel = addLabel("Issue Number:",3,1,1,1);
	private IntegerField periodicalNumberField = addIntegerField(0,3,2,1,1);
	
	private JButton enterButton = addButton("Add book to library",4,2,1,1);
	private JButton cancelButton = addButton("Cancel",4,1,1,1);
	
	private Library lib;
	
	public void buttonClicked(JButton button) {
		if(button == enterButton) {
			String title = titleField.getText();
			if(isBlank(title)) {
				messageBox("Empty title");
				return;
			}
			if(bookButton.isSelected()) {
				String author = bookAuthorField.getText();
				if(isBlank(author)) {
					messageBox("Empty author");
					return;
				}
				lib.addItem(new Book(title,author));
			}else {
				if(!periodicalNumberField.isValidNumber()) {
					messageBox("Invalid issue number");
					return;
				}
				int issueNumber = periodicalNumberField.getNumber();
				if(issueNumber < 0 ) {
					messageBox("Cannot have negative issue number");
					return;
				}
				lib.addItem(new Periodical(title, issueNumber));
			}
			
			dispose();
		}else if(button == cancelButton) {
			dispose();
		}
	}
	
	private ChangeListener cl = new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			if(e.getSource().equals(bookButton) && bookButton.isSelected()) {
				//show book elements
				periodicalNumberLabel.setVisible(false);
				periodicalNumberField.setVisible(false);
				bookAuthorLabel.setVisible(true);
				bookAuthorField.setVisible(true);
			}else if(e.getSource().equals(periodicalButton) && periodicalButton.isSelected()) {
				//show periodical elements
				periodicalNumberLabel.setVisible(true);
				periodicalNumberField.setVisible(true);
				bookAuthorLabel.setVisible(false);
				bookAuthorField.setVisible(false);
			}	
		}
	};
	
	
	//error checking helper method
	private boolean isBlank(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isWhitespace(s.charAt(i))) return false;
		}
		return true;
	}
	
	//constructor
	public AddItemDialog(JFrame parent, Library l) {
		super(parent);
		lib = l;
		itemTypeBG.add(bookButton);
		itemTypeBG.add(periodicalButton);
		
		bookButton.addChangeListener(cl);
		periodicalButton.addChangeListener(cl);
		
		bookButton.setSelected(true);
		
		periodicalNumberLabel.setVisible(false);
		periodicalNumberField.setVisible(false);
		
		this.setVisible(true);
		this.setSize(400,400);
	}
	
}
