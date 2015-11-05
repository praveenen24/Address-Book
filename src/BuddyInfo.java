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
	
	public BuddyInfo(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		age = 0;
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
	
	@Override
	public String toString() {
		return "Name: " + name + "	|	Address: " + address + "	|	Phone: " + phone + "\n";
	}
}
