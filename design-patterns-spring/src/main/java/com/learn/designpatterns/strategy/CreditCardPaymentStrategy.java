package com.learn.designpatterns.strategy;

import org.springframework.stereotype.Component;

/**
 * Concrete Strategy: Credit Card Payment
 * 
 * Implements PaymentStrategy for credit card processing
 */
@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {
    
    @Override
    public String processPayment(double amount) {
        // Simulate credit card payment processing
        return String.format(
            "Processing credit card payment of $%.2f\n" +
            "- Validating card number\n" +
            "- Checking credit limit\n" +
            "- Contacting payment gateway\n" +
            "- Payment successful via Credit Card",
            amount
        );
    }
    
    @Override
    public String getPaymentMethod() {
        return "CREDIT_CARD";
    }
}
