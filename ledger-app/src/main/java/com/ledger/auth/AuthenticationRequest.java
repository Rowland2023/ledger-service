package com.ledger.auth;

public record AuthenticationRequest(
    String email, 
    String password
) {}