package com.Technosignia.Azown.configuration;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	UserDetailsService  UerDetails() {
		
		UserDetails owner=User.withUsername("Ram").password(passwordEncoder().encode("Ram@Owner")).roles("owner").build();
		UserDetails property=User.withUsername("Om").password(passwordEncoder().encode("Om@Admin")).roles("product").build();
		UserDetails broker=User.withUsername("Sham").password(passwordEncoder().encode("Sham@Broker")).roles("broker").build();
		
		return new InMemoryUserDetailsManager(owner,property,broker);
		
	}

	@Bean
	public SecurityFilterChain SecurityFiterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(customizer -> customizer.disable())
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults())
		.authorizeHttpRequests(authorize -> authorize
		.requestMatchers("/owner").hasRole("owner")
		.requestMatchers("/property").hasRole("product")
		.requestMatchers("/broker").hasRole("broker")
		.anyRequest().authenticated());
		
		return httpSecurity.build();
		
	}
}
