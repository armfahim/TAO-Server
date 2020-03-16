package io.naztech;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class TestXml {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws ParserConfigurationException, SAXException, IOException {
		File file = new File("C:\\Users\\fahim.reza\\Desktop\\New folder\\Book1.xml");
		// File file = new File("D:\\Spring Workspace\\qti.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		
		NodeList nodeList = doc.getElementsByTagName("Row");
		System.out.println(nodeList.getLength());

		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			NodeList childList = node.getChildNodes();
			System.out.println(childList.getLength());
			for(int i = 9; i< childList.getLength();i++) {
				Elements eElement = (Elements) childList;
				 Node child = childList.item(i);
//				 System.out.println(child.getTextContent());
			}
//			System.out.println("\nNode Name :" + node.getNodeName());
//			if (node.getNodeType() == Node.ELEMENT_NODE) {
//				Element eElement = (Element) node;
//				System.out.println(eElement.getE);
//				System.out.println("Student id: " + eElement.getElementsByTagName("id").item(0).getTextContent());
			}
		}
	}
