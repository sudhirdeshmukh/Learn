package com.learn.designpatterns.strategy;

/**
 * Strategy Interface for Payment Processing
 * 
 * WHAT IS STRATEGY PATTERN?
 * Strategy pattern defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable. Strategy lets the algorithm vary independently
 * from clients that use it.
 * 
 * WHY USE STRATEGY?
 * - Eliminates conditional statements for selecting behavior
 * - Makes it easy to add new strategies without modifying existing code
 * - Allows runtime selection of algorithm
 * - Promotes Open/Closed Principle (open for extension, closed for modification)
 * 
 * WHEN TO USE:
 * - When you have multiple ways to perform an operation
 * - When you want to avoid exposing complex algorithm implementation details
 * - When you need to switch between different algorithms at runtime
 * - When you have many related classes that differ only in their behavior
 * 
 * Real-World Example: Payment Processing
 * Different payment methods (Credit Card, PayPal, Crypto) have different processing logic
 */
public interface PaymentStrategy {
    
    /**
     * Process payment using the specific strategy
     * 
     * @param amount Amount to process
     * @return Payment confirmation message
     */
    String processPayment(double amount);
    
    /**
     * Get payment method name
     * 
     * @return Payment method identifier
     */
    String getPaymentMethod();
}
