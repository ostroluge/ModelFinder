package org.acteacademie.modelfinder.config.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomMvcConfig extends WebMvcConfigurerAdapter{

	
	@Bean(name="dataSource")
	public DriverManagerDataSource dataSource(){
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://mysql-miage.alwaysdata.net:3306/miage_modelfinder_security");
		driverManagerDataSource.setUsername("miage");
		driverManagerDataSource.setPassword("miage");
		return driverManagerDataSource;
	}
}
