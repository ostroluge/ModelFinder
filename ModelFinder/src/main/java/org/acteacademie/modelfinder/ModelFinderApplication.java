package org.acteacademie.modelfinder;

import org.acteacademie.modelfinder.domain.Admin;
import org.acteacademie.modelfinder.repositories.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ModelFinderApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ModelFinderApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(ModelFinderApplication.class);
	}
    
    @Bean
	public CommandLineRunner demo(AdminRepository repository) {
		return (args) -> {
			log.info("Admin found with findAll():");
			log.info("-------------------------------");
			for (Admin admin : repository.findAll()) {
				log.info(admin.toString());
			}
		};
	}
}