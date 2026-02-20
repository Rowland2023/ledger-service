package com.ledger.systems.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 1. Scan for Beans/Controllers in both your app and the starter
@ComponentScan(basePackages = {"com.ledger", "com.rowland.security"})
// 2. Scan for your JpaRepository interfaces
@EnableJpaRepositories(basePackages = "com.ledger.entity")
// 3. Scan for your @Entity classes (User.java)
@EntityScan(basePackages = "com.ledger.entity")
public class LedgerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LedgerServiceApplication.class, args);
    }
}