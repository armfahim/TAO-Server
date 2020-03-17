package io.naztech.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.naztech.config.AppConfig;
import io.naztech.model.ExamQuestion;
import io.naztech.model.ExamQuestionOption;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TestService {
	@Autowired
	AppConfig appConfig;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	int itr = 0;
	int flag = 100000;
	boolean isTrue = true;

	public boolean extractData() throws ParserConfigurationException, SAXException, IOException {
		ExamQuestion examQuestion = new ExamQuestion();
		String fileName = "Book1.xml";
		String fileName2 = "Book2.xml";

		for (int itrQ = 0; itrQ < getNodeList(fileName).getLength(); itrQ++,flag++) {
			Node node = getNodeList(fileName).item(itrQ);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				
				//examQuestion.setFlag(flag);
				examQuestion.setQuestion(eElement.getElementsByTagName("Cell").item(9).getTextContent().trim());
				examQuestion.setQuestionSet(eElement.getElementsByTagName("Cell").item(10).getTextContent().trim());
				examQuestion.setActionKey(0);
				examQuestion.setEnvkey(0);
				examQuestion.setEventKey(0);
				examQuestion.setIsActive(1);
				LocalDateTime now = LocalDateTime.now();
				examQuestion.setModifiedDate(dtf.format(now));
				examQuestion.setQuestionVer(0);
				examQuestion.setStateKey(0);
				examQuestion.setUserModKey(0);

//				examQuestion.getExamQuestionOptions().add(examQuestionOption);
//				dbConfig.getSessionFactory().save(examQuestion);
//				dbConfig.getTransaction().commit();
//				dbConfig.closeAll();

				appConfig.getSessionFactory().save(getQuestionOption(fileName2, examQuestion));
				appConfig.getTransaction().commit();
				appConfig.closeAll();
			}
		}
		return true;
	}

	private ExamQuestion getQuestionOption(String fileName2, ExamQuestion examQuestion) throws ParserConfigurationException, SAXException, IOException {

		List<ExamQuestionOption> optionList = new ArrayList<>();
		File file = new File("D:\\Spring Workspace\\Book2.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		
		NodeList nodeList = doc.getElementsByTagName("Row");
		System.out.println(nodeList.getLength());
		
	

		for ( ; itr < nodeList.getLength(); itr++) {
			ExamQuestionOption examQuestionOption = new ExamQuestionOption();
			
			Node node = nodeList.item(itr);				
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				int noQues = Integer.parseInt(eElement.getElementsByTagName("Cell").item(10).getTextContent().trim());
				System.out.println("question noo: "+noQues);
				System.out.println("question key: "+flag);
				
//				if(noQues == 100006 && isTrue == true) {
//					flag = flag +1;
//					isTrue=false;
//				}
				
				if(flag == noQues) {
					examQuestionOption.setOptionName(eElement.getElementsByTagName("Cell").item(9).getTextContent().trim());
					examQuestionOption
							.setIsAnswer(Integer.parseInt(eElement.getElementsByTagName("Cell").item(11).getTextContent().trim()));
					examQuestionOption.setActionKey(0);
					examQuestionOption.setEnvkey(0);
					examQuestionOption.setEventKey(0);
					examQuestionOption.setIsActive(1);
					LocalDateTime now = LocalDateTime.now();
					examQuestionOption.setModifiedDate(dtf.format(now));
					examQuestionOption.setOptionVer(0);
					examQuestionOption.setStateKey(0);
					examQuestionOption.setUserModKey(0);
					examQuestionOption.setExamQuestion(examQuestion);
					optionList.add(examQuestionOption);
				}else {
					break;
				}
				

			}
		}
		examQuestion.setExamQuestionOptions(optionList);
		return examQuestion;
	}

	private NodeList getNodeList(String fileName) {
		File file = new File("D:\\\\Spring Workspace\\" + fileName);
		// File file = new File("D:\\Spring Workspace\\qti.xml");
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(file);
			doc.getDocumentElement().normalize();

			return doc.getElementsByTagName("Row");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			log.warn("Document dbuilding status: UNSUCCESSFUL");
			return null;
		}
	}

//	private NodeList getNodeList(Element eElement) {
//		try {
//			return eElement.getElementsByTagName("simpleChoice");
//		} catch (ElementInstantiationException e) {
//			log.warn("Element Found status: UNSUCCESSFUL");
//			return null;
//		}
//	}

}
