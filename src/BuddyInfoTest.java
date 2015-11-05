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
		assertEquals("Thomas", buddy.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("1125 Colonel by", buddy.getAddress());
	}

	@Test
	public void testGetPhone() {
		assertEquals("6131112222", buddy.getPhone());
	}

	@Test
	public void testGetAge() {
		assertTrue(buddy.getAge() == 12);
	}

	@Test
	public void testSetName() {
		buddy.setName("Praveenen");
		assertEquals("Praveenen", buddy.getName());
	}

	@Test
	public void testSetAddress() {
		buddy.setAddress("test address");
		assertEquals("test address", buddy.getAddress());
	}

	@Test
	public void testSetPhone() {
		buddy.setPhone("6132221111");
		assertEquals("6132221111", buddy.getPhone());
	}

	@Test
	public void testSetAge() {
		buddy.setAge(22);
		assertTrue(buddy.getAge() == 22);
	}
	
	@Test
	public void testIsOver18True() {
		buddy.setAge(19);
		assertTrue(buddy.isOver18());
	}
	
	@Test
	public void testIsOver18False() {
		assertFalse(buddy.isOver18());
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Welcome " + buddy.getName() + " you have been created", buddy.getGreeting());
	}

}
