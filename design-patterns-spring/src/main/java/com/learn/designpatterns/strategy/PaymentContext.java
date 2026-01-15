package com.learn.designpatterns.strategy;

import org.springframework.stereotype.Service;

/**
 * Context class that uses PaymentStrategy
 * 
 * HOW STRATEGY PATTERN WORKS:
 * 1. Context (this class) maintains a reference to a Strategy object
 * 2. Context delegates work to the Strategy object instead of implementing multiple algorithms
 * 3. Strategy can be changed at runtime
 * 
 * BENEFITS:
 * - No need for if-else or switch statements
 * - Easy to add new payment methods (just create new Strategy)
 * - Client can choose strategy at runtime
 */
@Service
public class PaymentContext {
    
    private PaymentStrategy strategy;
    
    /**
     * Set the payment strategy at runtime
     * This is the key feature of Strategy pattern
     * 
     * @param strategy Payment strategy to use
     */
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Execute payment using current strategy
     * 
     * Context doesn't know HOW payment is processed,
     * it just delegates to the current strategy
     * 
     * @param amount Amount to process
     * @return Payment result
     */
    public String executePayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy not set");
        }
        
        return strategy.processPayment(amount);
    }
    
    /**
     * Get current payment method
     * 
     * @return Current payment method name
     */
    public String getCurrentPaymentMethod() {
        return strategy != null ? strategy.getPaymentMethod() : "NONE";
    }
}
