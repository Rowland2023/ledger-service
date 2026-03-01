package com.rowland.ledger.controller;

import com.rowland.ledger.service.LedgerEventService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/ledger")
public class LedgerController {

    private static final Logger logger = LoggerFactory.getLogger(LedgerController.class);
    private final LedgerEventService ledgerEventService;

    public LedgerController(LedgerEventService ledgerEventService) {
        this.ledgerEventService = ledgerEventService;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TransactionRequest {
        private String id;
        private double amount;
        private String type;

        public void setId(String id) { this.id = id; }
        public void setAmount(double amount) { this.amount = amount; }
        public void setType(String type) { this.type = type; }

        public String getId() { return id; }
        public double getAmount() { return amount; }
        public String getType() { return type; }
    }

    /**
     * Requirement 4a: Trigger the Intelligence Orchestration.
     * Updated with enhanced error reporting to debug the 500 status.
     */
    @PostMapping("/transaction")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionRequest request) {
        try {
            // Log incoming data for the video demo
            logger.info("REST Request received for TXN: {}", request.getId());

            if (request.getId() == null || request.getId().isEmpty()) {
                return ResponseEntity.badRequest().body("Error: Transaction ID is required.");
            }

            // Publish to Event Bus
            ledgerEventService.emitTransactionEvent(
                request.getId(), 
                request.getAmount(), 
                request.getType()
            );
            
            return ResponseEntity.ok("Success: Transaction " + request.getId() + " emitted to Intelligence Hub.");

        } catch (Exception e) {
            // DEBUG: This prints the full stack trace to your terminal/IDE console
            e.printStackTrace(); 
            logger.error("CRITICAL ORCHESTRATION FAILURE: ", e);
            
            return ResponseEntity.internalServerError()
                    .body("Orchestration Error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Map<String, String>>> getLedgerData() {
        return ResponseEntity.ok(List.of(
            Map.of("id", "1", "amount", "500.00", "description", "Cloud Hosting"),
            Map.of("id", "2", "amount", "1200.00", "description", "Development Tools")
        ));
    }
}