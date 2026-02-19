package com.rowland.security.autoconfigure;

import com.rowland.security.jwt.JwtAuthenticationFilter;
import com.rowland.security.jwt.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityAutoConfiguration {

    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            JwtService jwtService, 
            @Lazy UserDetailsService userDetailsService) { // Use @Lazy to prevent circular loops
        return new JwtAuthenticationFilter(jwtService, userDetailsService);
    }
}