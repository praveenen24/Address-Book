import java.io.Serializable;
import java.util.Scanner;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * This is used to create BuddyInfos for the addressBook
 * @author praveenensrikumaran
 *
 */
@SuppressWarnings("serial")
public class BuddyInfo implements Serializable {
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
	
	public String toXMLString() {
		return "<name>" + this.name + "</name>" 
			+ "<address>" + this.address + "</address>"
			+ "<phone>" + this.phone + "</phone>"
			+ "<age>" + this.age + "</age>";
	}

	public static BuddyInfo create(Element element) {
		BuddyInfo importedBuddy = new BuddyInfo("","","",0);
		
		NodeList nodeList;
		nodeList = element.getElementsByTagName("address");
		if(nodeList.getLength() > 0){
			importedBuddy.setAddress(nodeList.item(0).getTextContent());
		}
		
		nodeList = element.getElementsByTagName("phone");
		if(nodeList.getLength() > 0){
			importedBuddy.setPhone(nodeList.item(0).getTextContent());
		}
		
		nodeList = element.getElementsByTagName("name");
		if(nodeList.getLength() > 0){
			importedBuddy.setName(nodeList.item(0).getTextContent());
		}
		
		nodeList = element.getElementsByTagName("age");
		if(nodeList.getLength() > 0){
			importedBuddy.setAge(Integer.parseInt(nodeList.item(0).getTextContent()));
		}
		
		return importedBuddy;
	}
}
