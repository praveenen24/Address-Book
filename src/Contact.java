
public class Contact {
	String name;
	String address;
	String phone;
	
	public Contact(String name, String address, String phone) {
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
	
	@Override
	public boolean equals(Object obj) {
		return this.equals(obj);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone + "\n\n";
	}
}
