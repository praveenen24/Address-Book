import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * GUI Portion of the AddressBook
 */
public class GUI {
	private static AddressBook addressBook;
	private static JMenu contactMenu;
	private static JMenuItem create;
	private static JMenuItem save;
	private static JMenuItem display;
	private static JMenuItem addMenu;
	private static JList<BuddyInfo> list;
	private static JPanel listPanel;
	private static JPanel buttonPanel;
	private static JFrame frame;
	private static DefaultListModel<BuddyInfo> listModel = new DefaultListModel<>();
	
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
			listPanel.setVisible(true);
			buttonPanel.setVisible(true);
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
				String name = textNameField.getText() + ".txt";
				addressBook.export(name);
			}
		}
	};
	
	private static ActionListener importListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser choose = new JFileChooser();
			int result = choose.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
				AddressBook newAddressBook = AddressBook.importAddressBook(choose.getSelectedFile());
				addressBook = newAddressBook;
				listModel.clear();
				for (BuddyInfo info : addressBook.getContacts()) {
					listModel.addElement(info);
				}
			}
			contactMenu.setVisible(true);
			save.setVisible(true);
			display.setVisible(true);
			addMenu.setVisible(true);
		}
	};
	
	private static ActionListener addListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panel = new JPanel(new GridLayout(0,1));
			JTextField nameField = new JTextField();
			JTextField addressField = new JTextField();
			JTextField phoneField = new JTextField();
			JTextField ageField = new JTextField();
			panel.add(new JLabel("Name"));
			panel.add(nameField);
			panel.add(new JLabel("Address"));
			panel.add(addressField);
			panel.add(new JLabel("Phone"));
			panel.add(phoneField);
			panel.add(new JLabel("Age"));
			panel.add(ageField);
			int result = JOptionPane.showConfirmDialog(frame, panel, "Contact Info", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (result == 0) {
				BuddyInfo newContact = new BuddyInfo(nameField.getText(),
						addressField.getText(), phoneField.getText(), Integer.parseInt(ageField.getText()));
				addressBook.addContact(newContact);
				listModel.addElement(newContact);
			}
		}
	};
	
	private static ActionListener deleteListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (list.getSelectedIndex() != -1) {
				addressBook.removeContact(list.getSelectedValue());
				listModel.remove(list.getSelectedIndex());
			} else {
				JOptionPane.showMessageDialog(frame, "No Contact is Selected");
			}
		}
	};
	
	private static ActionListener editListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (list.getSelectedIndex() != -1) {
				JPanel panel = new JPanel(new GridLayout(0,1));
				JTextField nameField = new JTextField(list.getSelectedValue().getName());
				JTextField addressField = new JTextField(list.getSelectedValue().getAddress());
				JTextField phoneField = new JTextField(list.getSelectedValue().getPhone());
				panel.add(new JLabel("Name"));
				panel.add(nameField);
				panel.add(new JLabel("Address"));
				panel.add(addressField);
				panel.add(new JLabel("Phone"));
				panel.add(phoneField);
				int result = JOptionPane.showConfirmDialog(frame, panel, "Contact Info", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (result == 0) {
					list.getSelectedValue().setName(nameField.getText());
					list.getSelectedValue().setAddress(addressField.getText());
					list.getSelectedValue().setPhone(phoneField.getText());
					list.repaint();
				}
			} else {
				JOptionPane.showMessageDialog(frame, "No Contact was Selected");
			}
		}
	};
	
	public static void setMenu() {
		JMenuBar menu = new JMenuBar();	
		
		// Address Menu
		JMenu addressBookMenu = new JMenu("Address Book");
		create = new JMenuItem("Create");
		save = new JMenuItem("Save");
		display = new JMenuItem("Display");
		JMenuItem importMenu = new JMenuItem("Import");
		addressBookMenu.add(create);
		create.addActionListener(createListener);
		addressBookMenu.add(save);
		save.addActionListener(saveListener);
		addressBookMenu.add(display);
		display.addActionListener(displayListener);
		addressBookMenu.add(importMenu);
		importMenu.addActionListener(importListener);
		save.setVisible(false);
		display.setVisible(false);
		menu.add(addressBookMenu);  

		// Contact Menu
		contactMenu = new JMenu("BuddyInfo");
		contactMenu.setVisible(false);
		addMenu = new JMenuItem("Add");
		addMenu.addActionListener(addListener);
		addMenu.setVisible(false);
		contactMenu.add(addMenu);
		menu.add(contactMenu);
		frame.setJMenuBar(menu);
		frame.setVisible(true);
	}
	

	public static void main(String[] args) throws Exception {
		frame = new JFrame("Address Book");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list = new JList<BuddyInfo>(listModel);
		list.setPreferredSize(new Dimension(200, 200));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(0,1));
		
		// List of Contacts
		listPanel = new JPanel();
		listPanel.setSize(500, 250);
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setPreferredSize(new Dimension(500, 250));
		listPanel.add(scrollPane);
		listPanel.setVisible(false);
		
		//Buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JButton delete = new JButton("Delete");
		JButton edit = new JButton("Edit");
		delete.addActionListener(deleteListener);
		edit.addActionListener(editListener);
		buttonPanel.add(delete);
		buttonPanel.add(edit);
		buttonPanel.setVisible(false);
		
		setMenu();
		
		frame.add(listPanel);
		frame.add(buttonPanel);
		frame.pack();

	}
}
