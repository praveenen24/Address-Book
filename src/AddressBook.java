import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	List<Contact> contactList;
	
	public AddressBook() {
		contactList = new ArrayList<Contact>();
	}
	
	public void addContact(Contact c) {
		contactList.add(c);
	}
	
	public void removeContact(Contact c) {
		contactList.remove(c);
	}
	
	public List<Contact> getContacts() {
		return contactList;
		
	}
}
