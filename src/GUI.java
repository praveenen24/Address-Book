import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	private static AddressBook addressBook;
	private static JMenu contactMenu;
	private static JMenuItem create;
	private static JMenuItem save;
	private static JMenuItem display;
	private static JMenuItem addMenu;
	private static JTextArea textArea;
	private static JList<BuddyInfo> list;
	private static JFrame frame;
	
	private static ActionListener createListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			addressBook = new AddressBook();
			contactMenu.setVisible(true);
			save.setVisible(true);
			display.setVisible(true);
			addMenu.setVisible(true);
		}
	};
	
	private static ActionListener displayListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			textArea.setVisible(true);
		}
	};
	
	private static ActionListener saveListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new GridLayout(0,1));
			
			JTextField textNameField = new JTextField();
			panel.add(new JLabel("Text File Name"));
			panel.add(textNameField);
			int result = JOptionPane.showConfirmDialog(frame, panel, "Txt Name?", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				try {
					FileWriter fw = new FileWriter(textNameField.getText() + ".txt");
					textArea.write(fw);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	};
	
	private static ActionListener addListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new GridLayout(0,1));
			JTextField nameField = new JTextField();
			JTextField addressField = new JTextField();
			JTextField phoneField = new JTextField();
			panel.add(new JLabel("Name"));
			panel.add(nameField);
			panel.add(new JLabel("Address"));
			panel.add(addressField);
			panel.add(new JLabel("Phone"));
			panel.add(phoneField);
			int result = JOptionPane.showConfirmDialog(frame, panel, "Contact Info", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (result == 0) {
				BuddyInfo newContact = new BuddyInfo(nameField.getText(),
						addressField.getText(), phoneField.getText());
				addressBook.addContact(newContact);
				textArea.append(newContact.toString());
			}
		}
	};
	

	public static void main(String[] args) {
		frame = new JFrame("Address Book");
		textArea = new JTextArea("Address Book\n\n");
		textArea.setVisible(false);
		frame.setSize(500, 500);
		frame.add(textArea);
		JMenuBar menu = new JMenuBar();
		
		// Address Menu
		JMenu addressBookMenu = new JMenu("Address Book");
		create = new JMenuItem("Create");
		save = new JMenuItem("Save");
		display = new JMenuItem("Display");
		addressBookMenu.add(create);
		create.addActionListener(createListener);
		addressBookMenu.add(save);
		save.addActionListener(saveListener);
		addressBookMenu.add(display);
		display.addActionListener(displayListener);
		save.setVisible(false);
		display.setVisible(false);
		menu.add(addressBookMenu);  
		
		// Contact Menu
		contactMenu = new JMenu("Contact");
		contactMenu.setVisible(false);
		addMenu = new JMenuItem("Add");
		addMenu.addActionListener(addListener);
		addMenu.setVisible(false);
		contactMenu.add(addMenu);
		menu.add(contactMenu);
		frame.setJMenuBar(menu);
		frame.setVisible(true);
	}

}
