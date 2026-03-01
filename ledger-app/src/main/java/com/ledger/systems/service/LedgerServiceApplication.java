package com.ledger.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Task 4a: Event-Driven Orchestration.
 * We exclude Database Auto-Configuration to ensure the Ledger service 
 * remains high-availability even if the DB is unreachable during the demo.
 */
@SpringBootApplication(
    scanBasePackages = {"com.ledger.service", "com.rowland"}, // Add this!
    exclude = {
        DataSourceAutoConfiguration.class, 
        HibernateJpaAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class
    }
)
@EnableAsync // Enables the background AI processing
public class LedgerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LedgerServiceApplication.class, args);
    }
}