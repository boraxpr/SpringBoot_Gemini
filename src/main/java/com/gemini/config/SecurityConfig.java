package com.gemini.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("user")
				.password("{noop}pass")
				.roles("USER");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
            .authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/h2-console/**").permitAll()
            .anyRequest()
				.authenticated()
            	.and()
			.formLogin()
                .and()
            .httpBasic();

		http.csrf().disable();
        http.headers().frameOptions().disable();
	}
}