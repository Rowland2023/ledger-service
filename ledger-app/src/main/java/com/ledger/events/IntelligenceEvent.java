package com.rowland.ledger.events;

import org.springframework.context.ApplicationEvent;

public class IntelligenceEvent extends ApplicationEvent {
    private final String transactionId;
    private final double amount;
    private final String transactionType;

    public IntelligenceEvent(Object source, String transactionId, double amount, String transactionType) {
        super(source);
        this.transactionId = transactionId;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public String getTransactionId() { return transactionId; }
    public double getAmount() { return amount; }
    public String getTransactionType() { return transactionType; }
}