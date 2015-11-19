import java.util.Scanner;

/**
 * This is used to create BuddyInfos for the addressBook
 * @author praveenensrikumaran
 *
 */
public class BuddyInfo {
	private String name;
	private String address;
	private String phone;
	private int age;

	public BuddyInfo(String name, String address, String phone, int age) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}

	public BuddyInfo(BuddyInfo buddy) {
		this.name = buddy.name;
		this.address = buddy.address;
		this.phone = buddy.phone;
		this.age = buddy.age;
	}

	public String getName() {
		return  name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isOver18() {
		if (age > 18) return true;
		return false;
	}
	
	@SuppressWarnings("resource")
	public static BuddyInfo importBuddy(String s) {
		Scanner sc = new Scanner(s).useDelimiter("!");
		BuddyInfo newBuddy = new BuddyInfo(sc.next(), sc.next(), sc.next(), sc.nextInt());
		sc.close();
		return newBuddy;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BuddyInfo) {
			BuddyInfo buddy = (BuddyInfo) obj;
			if (buddy.getName().equals(this.name) && buddy.getAddress().equals(this.address) 
					&& buddy.getAge() == this.age && buddy.getPhone().equals(this.phone)) {
				return true;
			}
		}
		return false;
	}

	public String getGreeting() {
		return "Welcome " + name + " you have been created";
	}

	@Override
	public String toString() {
		return name + "!" + address + "!" + phone + "!" + age;
	}
}
