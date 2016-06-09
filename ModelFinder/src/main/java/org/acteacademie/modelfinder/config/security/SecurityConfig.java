package org.acteacademie.modelfinder.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(prePostEnabled=true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers(HttpMethod.POST,"/login").permitAll().and()
		.authorizeRequests()
		.anyRequest().authenticated().and()
		.httpBasic()
		.and().logout().logoutSuccessUrl("/").permitAll()
		.and().csrf().disable();
		
		http.exceptionHandling().disable();

	}
}

