package com.rowland.ledger.events;

import com.rowland.identity.event.IntelligenceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Core Intelligence Orchestrator.
 * This service listens for system-wide events and generates simulated 
 * AI insights to demonstrate the modular orchestration architecture.
 */
@Service
public class CoreIntelligenceService {

    private static final Logger logger = LoggerFactory.getLogger(CoreIntelligenceService.class);

    /**
     * Listens for IntelligenceEvents published by other modules (e.g., Ledger).
     * This decouples the event source from the intelligence logic.
     */
    @EventListener
    public void handleIntelligenceRequest(IntelligenceEvent event) {
        logger.info("Intelligence Orchestrator: Received event for transaction ID: {}", event.getTransactionId());

        // Simulate AI processing delay and logic
        String insight = generateSimulatedInsight(event.getAmount(), event.getTransactionType());

        // In a real-world scenario, you might save this to a DB or send it back to a UI
        logger.info("AI INSIGHT GENERATED: {}", insight);
    }

    /**
     * Satisfies the 'Simulated AI' requirement.
     * Demonstrates how the architecture would process data to provide value.
     */
    private String generateSimulatedInsight(double amount, String type) {
        if (amount > 10000) {
            return "High-value " + type + " detected. Recommendation: Perform enhanced liquidity check.";
        } else if (amount < 0) {
            return "Negative balance anomaly detected. Potential accounting reconciliation required.";
        } else {
            return "Transaction patterns remain within standard baseline parameters.";
        }
    }
}