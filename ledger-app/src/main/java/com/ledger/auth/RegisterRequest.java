package com.ledger.auth;

import com.ledger.entity.Role; // Import the enum you created earlier

public record RegisterRequest(
    String email, 
    String password, 
    Role role
) {}