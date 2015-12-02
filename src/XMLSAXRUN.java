import java.io.File;

public class XMLSAXRUN {

	public static void main(String[] args) {
		
		File f = new File("file.xml");
		try {
			XMLSax.readSAX(f);
			XMLSax.readDom(f);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
