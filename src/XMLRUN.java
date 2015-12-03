import java.io.File;

public class XMLRUN {

	public static void main(String[] args) {
		
		File f = new File("file.xml");
		try {
			AddressBook a = new AddressBook();
			a.addContact(new BuddyInfo("Praveenen", "test", "test", 12));
			a.addContact(new BuddyInfo("Testing", "test2", "test2", 24));
			a.exportToXML(f);
			//XML.readDom(f);
			XML.readSAX(f);
			AddressBook newBook = AddressBook.importFromXML(f);
			System.out.println(a.equals(newBook));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
