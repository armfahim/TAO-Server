package io.naztech.service;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import io.naztech.config.DbConfig;
import io.naztech.model.ExamQuestion;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ScrapXml {

	@Autowired
	DbConfig dbConfig;
	public boolean extractData() throws ParserConfigurationException, SAXException, IOException {
		ExamQuestion examQuestion = new ExamQuestion();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		org.w3c.dom.Document doc = builder.parse("C:/Users/fahim.reza/Desktop/qti.xml");
		

		org.w3c.dom.NodeList questionList = doc.getElementsByTagName("prompt");
		
		
		for (int i = 0; i < questionList.getLength(); i++) {
			Node n = questionList.item(i);
			

			examQuestion.setQuestion(n.getTextContent().toString().trim());
			System.out.println(examQuestion.getQuestion());
			examQuestion.setActionKey(0);
			examQuestion.setEnvkey(0);
			examQuestion.setEventKey(0);
			examQuestion.setIsActive(1);
			final String dateTime = "2012-02-22T02:06:58.147Z";
			DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
			final ZonedDateTime parsed = ZonedDateTime.parse(dateTime, formatter.withZone(ZoneId.of("UTC")));
		    System.out.println(parsed.toLocalDateTime());
			examQuestion.setModifiedDate(parsed.toLocalDateTime());
			examQuestion.setQuestionSet("a");
			examQuestion.setQuestionVer(0);
			examQuestion.setStateKey(0);
			examQuestion.setUserModKey(0);
			
			dbConfig.getSessionFactory().save(examQuestion);
			dbConfig.getTransaction().commit();
			dbConfig.closeAll();
		}
		
		return true;
//		org.w3c.dom.NodeList ansList = doc.getElementsByTagName("simpleChoice");
//		for (int j = 0; j < ansList.getLength(); j++) {
//			Node n = ansList.item(j);
//			System.out.println(n.getTextContent());
//		}
	}
}
