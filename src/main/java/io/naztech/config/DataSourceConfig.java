//package io.naztech.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DataSourceConfig {
//	
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
//	@Bean
//	public DataSource getDataSource() {
//		return DataSourceBuilder.create().driverClassName(driverClassName)
//				.url(url).username(username).password(password)
//				.build(); 
//	}
//}
