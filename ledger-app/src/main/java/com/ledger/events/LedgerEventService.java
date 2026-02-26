package com.rowland.ledger.events;

import com.rowland.identity.event.IntelligenceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Ledger Event Producer.
 * This service is responsible for broadcasting ledger activities 
 * so that other modules (like Intelligence) can react to them.
 */
@Service
public class LedgerEventService {

    private static final Logger logger = LoggerFactory.getLogger(LedgerEventService.class);
    private final ApplicationEventPublisher eventPublisher;

    // Spring automatically injects the publisher
    public LedgerEventService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * Publishes an event to the internal system bus.
     * This fulfills the 'Modular Orchestration' requirement by 
     * ensuring the Ledger doesn't call the Intelligence service directly.
     */
    public void emitTransactionEvent(String transactionId, double amount, String type) {
        logger.info("Ledger Module: Emitting event for transaction {}", transactionId);
        
        // Create the event payload
        IntelligenceEvent event = new IntelligenceEvent(this, transactionId, amount, type);
        
        // Push the event onto the internal Spring bus
        eventPublisher.publishEvent(event);
    }
}