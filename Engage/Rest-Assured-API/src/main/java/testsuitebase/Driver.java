package testsuitebase;

import java.util.List;


import org.testng.TestNG;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;

public class Driver {
	static Driver objDriver = new Driver();
	
	public static void main(String[] args) {
		TestNG testng = new TestNG();
		String xmlFileName = System.getProperty("user.dir") + "\\src\\main\\resources\\testng.xml";
//		String xmlFileName = "C:\\Users\\Shanks\\eclipse-workspace-new\\MyProject\\src\\main\\resources";
		List<XmlSuite> suite;
		try {
			suite = (List<XmlSuite>)(new Parser(xmlFileName).parse());
			testng.setXmlSuites(suite);
			testng.run();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
