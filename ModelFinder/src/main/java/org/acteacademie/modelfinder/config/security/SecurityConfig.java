package org.acteacademie.modelfinder.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
		.antMatchers(HttpMethod.POST,"/**").permitAll()
		.antMatchers(HttpMethod.GET, "/**").permitAll().and()
		.authorizeRequests()
		.anyRequest().authenticated().and()
		.httpBasic()
		.and().logout().logoutSuccessUrl("/").permitAll();

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
		
		http.csrf().disable();
	}

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery(
				"select email as username, password, is_activated as enabled " +
						"from USER " +
				"where email=?")
		.authoritiesByUsernameQuery(
				"select email as username, role from USER where email=?");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}

