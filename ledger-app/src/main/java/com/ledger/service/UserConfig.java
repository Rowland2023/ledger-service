package com.ledger.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // We only provide the UserDetailsService. 
        // The PasswordEncoder is already provided by your Security Starter!
        UserDetails user = User.withUsername("admin")
                .password("password") // If the starter uses BCrypt, you might need {noop}password
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}