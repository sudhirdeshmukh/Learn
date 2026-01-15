package com.learn.designpatterns.strategy;

import org.springframework.stereotype.Component;

/**
 * Concrete Strategy: Cryptocurrency Payment
 * 
 * Implements PaymentStrategy for cryptocurrency processing
 */
@Component
public class CryptoPaymentStrategy implements PaymentStrategy {
    
    @Override
    public String processPayment(double amount) {
        // Simulate cryptocurrency payment processing
        return String.format(
            "Processing cryptocurrency payment of $%.2f\n" +
            "- Generating wallet address\n" +
            "- Waiting for blockchain confirmation\n" +
            "- Verifying transaction\n" +
            "- Payment successful via Cryptocurrency",
            amount
        );
    }
    
    @Override
    public String getPaymentMethod() {
        return "CRYPTO";
    }
}
