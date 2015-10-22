
public class BuddyInfo {
	String name;
	String address;
	String phone;
	
	public BuddyInfo(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.equals(obj);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "	|	Address: " + address + "	|	Phone: " + phone + "\n";
	}
}
