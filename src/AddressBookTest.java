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
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddContact() {
		addressBook.addContact(buddy);
		assertTrue(addressBook.contains(buddy));
	}

	@Test
	public void testRemoveContact() {
		addressBook.addContact(buddy);
		assertTrue(addressBook.contains(buddy));
		addressBook.removeContact(buddy);
		assertFalse(addressBook.contains(buddy));
	}
	
	@Test
	public void testSize() {
		addressBook.addContact(new BuddyInfo("","","",0));
		assertEquals(1, addressBook.size());
		addressBook.addContact(new BuddyInfo("","","",0));
		addressBook.addContact(new BuddyInfo("","","",0));
		addressBook.addContact(new BuddyInfo("","","",0));
		assertEquals(4, addressBook.size());
	}
	
	@Test
	public void testClear() {
		addressBook.clear();
		assertTrue(addressBook.size() == 0);
	}	
	
}
