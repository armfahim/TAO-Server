package io.naztech.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;


import io.naztech.model.ExamQuestion;

//@PropertySource("classpath:db.properties")
@Component
public class DbConfig {
//	
//	@Value("${jdbc.url}")
//	String url;
//	
//	@Value("${jdbc.username}")
//	String username;
//	
//	@Value("${jdbc.password}")
//	String password;
//	
//	@Value("${jdbc.driver}")
//	private String driverClassName;
//		
//	@Value("${jdbc.max.active}")
//	int maxActive;
//	
//	@Value("${jdbc.max.idle}")
//	int maxIdle;
//	
//	@Value("${jdbc.auto.commit}")
//	boolean defaultAutoCommit;
//	
//	@Value("${jdbc.inital.size}")
//	int initialSize;
//	
//	@Value("${jdbc.validator.query}")
//	String validationQuery;
	private static SessionFactory factory;
	private static Session session;
	
	public Session getSessionFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        
		   Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		factory = meta.getSessionFactoryBuilder().build();  
		session = factory.openSession();  
		return session;
	}
	
	public Transaction getTransaction() {
		Transaction t = session.beginTransaction();   
		return t;
	}
	
	public boolean closeAll() {
		factory.close();  
	    session.close();
	    return true;
	}
}

