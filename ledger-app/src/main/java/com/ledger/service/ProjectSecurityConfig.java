package com.ledger.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Disable CSRF so Curl works easily
            .csrf(csrf -> csrf.disable()) 
            // 2. Permit our specific orchestration API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/ledger/transaction").permitAll()
                .anyRequest().authenticated()
            );
        
        return http.build();
    }
}