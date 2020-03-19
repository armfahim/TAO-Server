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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.naztech.service.ScrapXml;

class TestXml {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() throws ParserConfigurationException, SAXException, IOException {
//		File file = new File("D:\\Spring Workspace\\allquestion&options.xml");
		File file = new File("C:\\GIT\\Projects\\TAO-Server\\files\\allquestion&options.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("choiceInteraction");
		for (int itr = 0; itr < nodeList.getLength(); itr++) {
			Node node = nodeList.item(itr);
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
			NodeList nodeList2 = eElement.getElementsByTagName("IsAnswer");
			System.out.println(nodeList2.item(i).getTextContent());
		}
	}
	}

