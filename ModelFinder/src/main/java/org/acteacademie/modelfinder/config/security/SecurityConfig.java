package org.acteacademie.modelfinder.config.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS,"/user/**").permitAll()
		.antMatchers(HttpMethod.POST,"/login").permitAll().and()
		.authorizeRequests()
		.anyRequest().authenticated().and()
		.httpBasic();

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
				"select pseudo as username , passwd as password, isActive as enabled " +
						"from appliuser " +
				"where pseudo=?")
		.authoritiesByUsernameQuery(
				"select pseudo as username, 'ROLE_USER' from appliuser where pseudo=?");
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}

