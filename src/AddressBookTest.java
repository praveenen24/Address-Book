

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {
	private AddressBook addressBook = null;
	private BuddyInfo buddy = null;
	
	@Before
	public void setUp() throws Exception {
		addressBook = new AddressBook();
		buddy = new BuddyInfo("Name", "Address", "Phone", 20);
		addressBook.addContact(buddy);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddContact() {
		assertTrue(addressBook.contains(buddy));
	}

	@Test
	public void testRemoveContact() {
		addressBook.removeContact(buddy);
		assertTrue(!addressBook.contains(buddy));
	}
}
