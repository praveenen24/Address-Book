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
	
	public List<BuddyInfo> getContacts() {
		return contactList;
		
	}
}
