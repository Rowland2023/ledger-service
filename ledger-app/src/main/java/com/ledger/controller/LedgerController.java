package com.ledger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController // <--- THIS must be RestController, not just @Controller
@RequestMapping("/api/v1/ledger")
public class LedgerController {

    @GetMapping
    public ResponseEntity<List<Map<String, String>>> getLedgerData() {
        return ResponseEntity.ok(List.of(
            Map.of("id", "1", "amount", "500.00", "description", "Cloud Hosting"),
            Map.of("id", "2", "amount", "1200.00", "description", "Development Tools")
        ));
    }
}