import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	private BuddyInfo buddy = null;
	
	@Before
	public void setUp() throws Exception {
		buddy = new BuddyInfo("Thomas", "1125 Colonel by", "6131112222", 12);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		assertFalse(buddy.getName().equals("Fail Test"));
		assertEquals("Thomas", buddy.getName());
	}

	@Test
	public void testGetAddress() {
		assertFalse(buddy.getAddress().equals("Fail Test"));
		assertEquals("1125 Colonel by", buddy.getAddress());
	}

	@Test
	public void testGetPhone() {
		assertFalse(buddy.getPhone().equals("1234567789"));
		assertEquals("6131112222", buddy.getPhone());
	}

	@Test
	public void testGetAge() {
		assertFalse(buddy.getAge() == 22);
		assertTrue(buddy.getAge() == 12);
	}

	@Test
	public void testSetName() {
		buddy.setName("Praveenen");
		assertFalse(buddy.getName().equals("Thomas"));
		assertEquals("Praveenen", buddy.getName());
	}

	@Test
	public void testSetAddress() {
		buddy.setAddress("test address");
		assertFalse(buddy.getAddress().equals("1125 Colonel by"));
		assertEquals("test address", buddy.getAddress());
	}

	@Test
	public void testSetPhone() {
		buddy.setPhone("6132221111");
		assertFalse(buddy.getPhone().equals("6131112222"));
		assertEquals("6132221111", buddy.getPhone());
	}

	@Test
	public void testSetAge() {
		buddy.setAge(22);
		assertFalse(buddy.getAge() == 12);
		assertTrue(buddy.getAge() == 22);
	}
	
	@Test
	public void testIsOver18() {
		assertFalse(buddy.isOver18());
		buddy.setAge(19);
		assertTrue(buddy.isOver18());
	}
	
	@Test
	public void testGreeting() {
		assertFalse(buddy.getGreeting().equals("Fail Test"));
		assertEquals("Welcome " + buddy.getName() + " you have been created", buddy.getGreeting());
	}
	
	@Test
	public void testBuddyInfoCopyConstructor() {
		BuddyInfo buddy1 = new BuddyInfo(buddy);
		assertTrue(buddy1.equals(buddy));
	}

}
