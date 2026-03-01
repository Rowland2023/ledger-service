package com.rowland.ledger.service;

import com.rowland.ledger.events.IntelligenceEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class LedgerEventService {

    private final ApplicationEventPublisher eventPublisher;

    public LedgerEventService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    // REMOVE @Transactional if it is here!
    public void emitTransactionEvent(String id, double amount, String type) {
        System.out.println("DEBUG: Emitting event for " + id);
        eventPublisher.publishEvent(new IntelligenceEvent(this, id, amount, type));
    }
}