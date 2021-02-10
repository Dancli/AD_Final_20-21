package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
			.antMatchers("/", "/css/**",  "/img/**", "/js/**", "/vendor/**", "/inicio/**", "/pacientes/altaPaciente/**", "/pacientes/addPaciente/**").permitAll()
			.antMatchers(HttpMethod.POST, "/tienda/**").permitAll()
			.antMatchers(HttpMethod.PUT, "/tienda/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/tienda/**").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/auth/login")
			.defaultSuccessUrl("/inicio/", true)
			.loginProcessingUrl("/auth/login-post")
			.permitAll()
			.and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/auth/login?logout")
			.permitAll();
	}
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}