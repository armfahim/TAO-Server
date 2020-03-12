package io.naztech;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.xml.sax.SAXException;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TaoServerApplication {
	
	private static DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SpringApplication.run(TaoServerApplication.class, args);
		
//		  StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
//        
//		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
//		  
//		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
//		Session session = factory.openSession();  
//		Transaction t = session.beginTransaction();  
//		
//		ExamQuestion examQuestion = new ExamQuestion();
//		DocumentBuilderFactory factoryDocument = DocumentBuilderFactory.newInstance();
//		DocumentBuilder builder = factoryDocument.newDocumentBuilder();
//		org.w3c.dom.Document doc = builder.parse("C:\\Users\\fahim.reza\\Desktop\\qti.xml");
//		System.out.println(doc.getDocumentElement().getNodeName());
//
//		org.w3c.dom.NodeList questionList = doc.getElementsByTagName("prompt");
//
//		for (int i = 0; i < questionList.getLength(); i++) {
//			Node n = questionList.item(i);
//			
//			examQuestion.setQuestion(n.getTextContent());
//			examQuestion.setActionKey(0);
//			examQuestion.setEnvkey(0);
//			examQuestion.setEventKey(0);
//			examQuestion.setIsActive(1);
//			final String dateTime = "2012-02-22T02:06:58.147Z";
//			DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
//			final ZonedDateTime parsed = ZonedDateTime.parse(dateTime, formatter.withZone(ZoneId.of("UTC")));
//		    System.out.println(parsed.toLocalDateTime());
//			examQuestion.setModifiedDate(parsed.toLocalDateTime());
//			examQuestion.setQuestionSet("a");
//			examQuestion.setQuestionVer(0);
//			examQuestion.setStateKey(0);
//			examQuestion.setUserModKey(0);
//			System.out.println(n.getTextContent());
//		}
//		org.w3c.dom.NodeList ansList = doc.getElementsByTagName("simpleChoice");
//		for (int j = 0; j < ansList.getLength(); j++) {
//			Node n = ansList.item(j);
//			System.out.println(n.getTextContent());
//		}
	
		
//		session.save(examQuestion);  
//	    t.commit();  
//	    System.out.println("successfully saved");    
//	    factory.close();  
//	    session.close();
	}

}
