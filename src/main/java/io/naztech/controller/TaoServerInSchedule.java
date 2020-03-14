package io.naztech.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.xml.sax.SAXException;

import io.naztech.config.AppConfig;
import io.naztech.service.ScrapXml;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TaoServerInSchedule {
	
	@Autowired
	ScrapXml scrapXml;
	@Autowired
	AppConfig dbConfig;
	
	@Scheduled(fixedRate = 210000, initialDelay = 500)
	public void examQuestionScheduling() throws ParserConfigurationException, SAXException, IOException {
	
		scrapXml.extractData();
		
	}

}
