package com.rowland.ledger.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CoreIntelligenceService {
    private static final Logger logger = LoggerFactory.getLogger(CoreIntelligenceService.class);

    @EventListener
    public void handleIntelligenceRequest(IntelligenceEvent event) {
        logger.info("Intelligence Orchestrator: Received event for ID: {}", event.getTransactionId());
        String insight = generateSimulatedInsight(event.getAmount(), event.getTransactionType());
        logger.info("AI INSIGHT GENERATED: {}", insight);
    }

    private String generateSimulatedInsight(double amount, String type) {
        if (amount > 10000) return "High-value " + type + " detected. Perform liquidity check.";
        if (amount < 0) return "Negative balance anomaly detected.";
        return "Transaction within standard parameters.";
    }
}