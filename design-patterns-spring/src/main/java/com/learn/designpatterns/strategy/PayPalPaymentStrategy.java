package com.learn.designpatterns.strategy;

import org.springframework.stereotype.Component;

/**
 * Concrete Strategy: PayPal Payment
 * 
 * Implements PaymentStrategy for PayPal processing
 */
@Component
public class PayPalPaymentStrategy implements PaymentStrategy {
    
    @Override
    public String processPayment(double amount) {
        // Simulate PayPal payment processing
        return String.format(
            "Processing PayPal payment of $%.2f\n" +
            "- Redirecting to PayPal\n" +
            "- Authenticating user\n" +
            "- Confirming transaction\n" +
            "- Payment successful via PayPal",
            amount
        );
    }
    
    @Override
    public String getPaymentMethod() {
        return "PAYPAL";
    }
}
