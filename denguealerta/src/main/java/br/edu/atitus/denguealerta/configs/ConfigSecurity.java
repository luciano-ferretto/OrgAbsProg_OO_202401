package br.edu.atitus.denguealerta.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.atitus.denguealerta.components.AuthToken;

@Configuration
public class ConfigSecurity {
	
	@Bean
	SecurityFilterChain getSecurity(HttpSecurity http, AuthToken authToken) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/ws**", "/ws/**").authenticated()
					.anyRequest().permitAll()
					)
			.addFilterBefore(authToken, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
