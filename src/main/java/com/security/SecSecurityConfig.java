package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shop.service.OldUserService;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	OldUserService userService;
	
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
    	http.logout()
        .logoutUrl("/logout")
        .and()
    .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/login");
    	/*
        http.authorizeRequests()
        .antMatchers("/admin").hasRole("ADMIN")
        .antMatchers("/user").hasAnyRole("ADMIN", "USER")
        .antMatchers("/login").permitAll()
        .and().formLogin()
        .loginPage("/login");*/
    }

//    @Bean 
//    public PasswordEncoder passwordEncoder() { 
//     		return new BCryptPasswordEncoder();
//    		return NoOpPasswordEncoder.getInstance();
//    }
}