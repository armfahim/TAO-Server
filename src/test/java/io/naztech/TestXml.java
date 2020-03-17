package io.naztech;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.naztech.service.ScrapXml;
import io.naztech.service.TestService;

class TestXml {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws ParserConfigurationException, SAXException, IOException {
		TestService test = new TestService();
		test.extractData();
//		File file = new File("C:\\Users\\fahim.reza\\Desktop\\New folder\\Book1.xml");
//		File file = new File("D:\\Spring Workspace\\Book1.xml");
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		org.w3c.dom.Document doc = db.parse(file);
//		doc.getDocumentElement().normalize();
//
//		NodeList nodeList = doc.getElementsByTagName("Row");
//		System.out.println(nodeList.getLength());
//		for (int itr = 0; itr < nodeList.getLength(); itr++) {
//			Node node = nodeList.item(itr);
//			if (node.getNodeType() == Node.ELEMENT_NODE) {
//				Element eElement = (Element) node;
//				System.out.println(eElement.getElementsByTagName("Cell").item(9).getTextContent().trim());
//				System.out.println(eElement.getElementsByTagName("Cell").item(10).getTextContent().trim());
//			}
//
//		}
	}

}
