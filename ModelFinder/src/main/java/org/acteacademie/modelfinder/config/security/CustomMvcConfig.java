package org.acteacademie.modelfinder.config.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomMvcConfig extends WebMvcConfigurerAdapter{

	private static final String alwaysDataURL = "jdbc:mysql://mysql-miage.alwaysdata.net:3306/miage_modelfinder_security";
	private static final String localDbURL = "jdbc:mysql://127.0.0.1:3306/model_finder_local";
	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl(localDbURL);
//		driverManagerDataSource.setUsername("miage");
		driverManagerDataSource.setUsername("root");
//		driverManagerDataSource.setPassword("miage");
		return driverManagerDataSource;
	}
}
