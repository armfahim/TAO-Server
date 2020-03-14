package io.naztech.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
	   	
	
	public boolean extractData() throws ParserConfigurationException, SAXException, IOException {

//		File file = new File("C:\\Users\\fahim.reza\\Desktop\\qti.xml");
		File file = new File("D:\\Spring Workspace\\qti.xml");

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		org.w3c.dom.NodeList nodeList = doc.getElementsByTagName("choiceInteraction");
		for (int itrQ = 0; itrQ < nodeList.getLength(); itrQ++) {
			Node node = nodeList.item(itrQ);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				ExamQuestion examQuestion = new ExamQuestion();

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
				getQuestionOption(eElement, examQuestion);
//				examQuestion.getExamQuestionOptions().add(examQuestionOption);
//				dbConfig.getSessionFactory().save(examQuestion);
//				dbConfig.getTransaction().commit();
//				dbConfig.closeAll();
			}
		}
		return true;
	}

	private void getQuestionOption(Element eElement, ExamQuestion examQuestion) {

		org.w3c.dom.NodeList optionList = eElement.getElementsByTagName("simpleChoice");
		for (int itrOp = 0; itrOp < optionList.getLength(); itrOp++) {
			ExamQuestionOption examQuestionOption = new ExamQuestionOption();

			examQuestionOption.setOptionName(optionList.item(itrOp).getTextContent());
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

			examQuestion.getExamQuestionOptions().add(examQuestionOption);

			appConfig.getSessionFactory().save(examQuestionOption);
			appConfig.getTransaction().commit();
			appConfig.closeAll();

			appConfig.getSessionFactory().save(examQuestion);
			appConfig.getTransaction().commit();
			appConfig.closeAll();

		}
	}
}
