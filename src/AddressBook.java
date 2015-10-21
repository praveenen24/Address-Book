import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	List<BuddyInfo> contactList;
	
	public AddressBook() {
		contactList = new ArrayList<BuddyInfo>();
	}
	
	public void addContact(BuddyInfo c) {
		contactList.add(c);
	}
	
	public void removeContact(BuddyInfo c) {
		contactList.remove(c);
	}
	
	public List<BuddyInfo> getContacts() {
		return contactList;
		
	}
}
