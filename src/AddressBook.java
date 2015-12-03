import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
public class AddressBook implements Serializable {
	List<BuddyInfo> contactList;
	
	public AddressBook() {
		contactList = new ArrayList<BuddyInfo>();
	}
	
	public void addContact(BuddyInfo buddy) {
		contactList.add(buddy);
	}
	
	public void removeContact(BuddyInfo buddy) {
		contactList.remove(buddy);
	}
	
	public boolean contains(BuddyInfo buddy) {
		return contactList.contains(buddy);
	}
	
	public int size() {
		return contactList.size();
	}
	
	public void clear() {
		contactList.clear();
	}
	
	public void export(String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for (BuddyInfo buddy : contactList) {
				writer.write(buddy.toString());
				writer.write(System.getProperty("line.separator"));
			}
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public static AddressBook importAddressBook(File file) {
		AddressBook importedAddressBook = new AddressBook();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String newBuddy;			
			while ((newBuddy = reader.readLine()) != null) {
				importedAddressBook.addContact(BuddyInfo.importBuddy(newBuddy));
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return importedAddressBook;
	}
	
	public void writeAddressBook(String file) {
		try {
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(this);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static AddressBook readAddressBook(File file) {
		AddressBook newBook = new AddressBook();
		try {
			FileInputStream f = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(f);
			newBook = (AddressBook) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newBook;
	}
	
	public void exportToXML(File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(toXML());
			writer.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static AddressBook importFromXML(File f) throws Exception {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(f);
		NodeList list = doc.getElementsByTagName("buddyinfo");
		AddressBook newBook = new AddressBook();
		for(int i = 0; i < list.getLength(); i++){
			newBook.addContact(BuddyInfo.create((Element)list.item(i)));
		}
		return newBook;
	}
	
	@Override
	public boolean equals(Object o) {
		AddressBook newBook = (AddressBook) o;
		return getContacts().equals(newBook.getContacts());		
	}
	
	public List<BuddyInfo> getContacts() {
		return contactList;
	}
	
	public String toXML() {
		StringBuilder b = new StringBuilder();
		b.append("<addressbook>");
		for (BuddyInfo buddy : contactList) {
			b.append("<buddyinfo>");
			b.append(buddy.toXMLString());
			b.append("</buddyinfo>");
		}
		b.append("</addressbook>");
		return b.toString();
	}
}
