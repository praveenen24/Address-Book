import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {
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
	
	public List<BuddyInfo> getContacts() {
		return contactList;
	}
}
