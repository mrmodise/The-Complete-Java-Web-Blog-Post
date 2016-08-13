package com.mrmodise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**").antMatchers("/console/**");
	}

	@Autowired
	protected void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(userDetailsService);

		auth.inMemoryAuthentication()
		.withUser("admin@gmail.com").password("morebodikagiso").roles("ADMIN")
		.and().withUser("kagisomodise@gmail.com").password("morebodikagiso").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/resources/**").permitAll().antMatchers("/admin/**")
				.hasAnyRole("USER", "ADMIN").anyRequest().permitAll().and().formLogin().loginPage("/login")
				.usernameParameter("email").permitAll().and().logout().logoutSuccessUrl("/login?logout").permitAll();
	}
}
