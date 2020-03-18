package io.naztech;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class AllQuesOptions {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() throws ParserConfigurationException, SAXException, IOException {
		File file = new File("D:\\Spring Workspace\\allquestion&options.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("choiceInteraction");
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
			System.out.println("\nNode Name :" + node.getNodeName());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				System.out.println(eElement.getElementsByTagName("prompt").item(0).getTextContent());
				getOptions(eElement);
			}
		}

	}

	private void getOptions(Element eElement) {
		NodeList nodeList = eElement.getElementsByTagName("simpleChoice");
		for(int i = 0; i<nodeList.getLength();i++) {
			System.out.println(nodeList.item(i).getTextContent());
			Node node = nodeList.item(i);
			Element e = (Element) node;
			System.out.println(e.getElementsByTagName("IsAnswer").item(0).getTextContent());
		}
	}
}
