package com.rowland.ledger.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class LedgerEventService {
    private static final Logger logger = LoggerFactory.getLogger(LedgerEventService.class);
    private final ApplicationEventPublisher eventPublisher;

    public LedgerEventService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void emitTransactionEvent(String transactionId, double amount, String type) {
        logger.info("Ledger Module: Emitting event for transaction {}", transactionId);
        IntelligenceEvent event = new IntelligenceEvent(this, transactionId, amount, type);
        eventPublisher.publishEvent(event);
    }
}