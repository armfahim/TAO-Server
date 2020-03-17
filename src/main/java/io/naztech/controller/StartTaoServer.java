package io.naztech.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;

import io.naztech.config.AppConfig;
import io.naztech.service.ScrapXml;
import io.naztech.service.TestService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StartTaoServer {
	
	@Autowired
	ScrapXml scrapXml;
	@Autowired
	TestService testService;
	
	@Autowired
	AppConfig dbConfig;
	
	//@Scheduled(fixedRate = 210000, initialDelay = 500)
	@EventListener(ApplicationReadyEvent.class)
	public void startExtracting() throws ParserConfigurationException, SAXException, IOException {
	
//		scrapXml.extractData();.
		testService.extractData();
		
	}

}
