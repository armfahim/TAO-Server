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
import org.springframework.util.AutoPopulatingList.ElementInstantiationException;
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
public class ScrapXml {

	@Autowired
	AppConfig appConfig;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   	
	
	public boolean extractData() {
		ExamQuestion examQuestion = new ExamQuestion();
		String fileName = "qti.xml";
	
		for (int itrQ = 0; itrQ < getNodeList(fileName).getLength(); itrQ++) {
			Node node = getNodeList(fileName).item(itrQ);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;

				examQuestion.setQuestion(eElement.getElementsByTagName("prompt").item(0).getTextContent());
				examQuestion.setActionKey(0);
				examQuestion.setEnvkey(0);
				examQuestion.setEventKey(0);
				examQuestion.setIsActive(1);
				LocalDateTime now = LocalDateTime.now();
				examQuestion.setModifiedDate(dtf.format(now));
				examQuestion.setQuestionSet("a");
				examQuestion.setQuestionVer(0);
				examQuestion.setStateKey(0);
				examQuestion.setUserModKey(0);
				
//				examQuestion.getExamQuestionOptions().add(examQuestionOption);
//				dbConfig.getSessionFactory().save(examQuestion);
//				dbConfig.getTransaction().commit();
//				dbConfig.closeAll();
				
				appConfig.getSessionFactory().save(getQuestionOption(eElement, examQuestion));
				appConfig.getTransaction().commit();
				appConfig.closeAll();
			}
		}
		return true;
	}

	private ExamQuestion getQuestionOption(Element eElement, ExamQuestion examQuestion) {
		
		List<ExamQuestionOption> optionList = new ArrayList<>();
		for (int itrOp = 0; itrOp < getNodeList(eElement).getLength(); itrOp++) {
			ExamQuestionOption examQuestionOption = new ExamQuestionOption();
			examQuestionOption.setOptionName(getNodeList(eElement).item(itrOp).getTextContent());
			examQuestionOption.setActionKey(0);
			examQuestionOption.setEnvkey(0);
			examQuestionOption.setEventKey(0);
			examQuestionOption.setIsActive(1);
			LocalDateTime now = LocalDateTime.now();
			examQuestionOption.setModifiedDate(dtf.format(now));
			examQuestionOption.setOptionVer(0);
			examQuestionOption.setStateKey(0);
			examQuestionOption.setUserModKey(0);
			examQuestionOption.setIsAnswer(0);
			examQuestionOption.setExamQuestion(examQuestion);
			optionList.add(examQuestionOption);

//			appConfig.getSessionFactory().save(examQuestionOption);
//			appConfig.getTransaction().commit();
//			appConfig.closeAll();
//
//			appConfig.getSessionFactory().save(examQuestion);
//			appConfig.getTransaction().commit();
//			appConfig.closeAll();

		}
		examQuestion.setExamQuestionOptions(optionList);
		return examQuestion;
	}
	
	private NodeList getNodeList(String fileName) {
		File file = new File("C:\\Users\\fahim.reza\\Desktop\\XMLFile.xml");
		//	File file = new File("D:\\Spring Workspace\\qti.xml");
			try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			org.w3c.dom.Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			
			return doc.getElementsByTagName("choiceInteraction");
			}catch(ParserConfigurationException | SAXException |IOException e) {
				log.warn("Document dbuilding status: UNSUCCESSFUL");
				return null;
			}
	}
	
	private NodeList getNodeList(Element eElement) {
			try {
				return eElement.getElementsByTagName("simpleChoice");
			}catch(ElementInstantiationException e) {
				log.warn("Element Found status: UNSUCCESSFUL");
				return null;
			}
	}
}
