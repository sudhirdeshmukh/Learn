package com.learn.designpatterns.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller demonstrating Strategy Pattern
 */
@RestController
@RequestMapping("/api/strategy")
@Tag(name = "Strategy Pattern", description = "Demonstrates Strategy pattern for runtime algorithm selection")
public class StrategyController {
    
    @Autowired
    private PaymentContext paymentContext;
    
    @Autowired
    private CreditCardPaymentStrategy creditCardStrategy;
    
    @Autowired
    private PayPalPaymentStrategy payPalStrategy;
    
    @Autowired
    private CryptoPaymentStrategy cryptoStrategy;
    
    /**
     * Process payment with specified strategy
     */
    @PostMapping("/payment/process")
    @Operation(summary = "Process payment", 
               description = "Processes payment using specified payment strategy")
    public String processPayment(
            @RequestParam String method,
            @RequestParam double amount) {
        
        // Select strategy based on payment method
        // This demonstrates runtime strategy selection
        PaymentStrategy strategy = switch (method.toUpperCase()) {
            case "CREDIT_CARD" -> creditCardStrategy;
            case "PAYPAL" -> payPalStrategy;
            case "CRYPTO" -> cryptoStrategy;
            default -> throw new IllegalArgumentException("Unknown payment method: " + method);
        };
        
        // Set strategy and execute
        paymentContext.setPaymentStrategy(strategy);
        return paymentContext.executePayment(amount);
    }
    
    /**
     * Get supported payment methods
     */
    @GetMapping("/payment/methods")
    @Operation(summary = "Get payment methods", 
               description = "Lists all supported payment methods")
    public String[] getPaymentMethods() {
        return new String[]{"CREDIT_CARD", "PAYPAL", "CRYPTO"};
    }
    
    /**
     * Demonstrate strategy switching
     */
    @GetMapping("/demo")
    @Operation(summary = "Demo strategy switching", 
               description = "Shows how strategies can be switched at runtime")
    public String demonstrateStrategySwitching() {
        double amount = 100.00;
        StringBuilder result = new StringBuilder();
        result.append("Processing $100 with different strategies:\n\n");
        
        // Process with Credit Card
        paymentContext.setPaymentStrategy(creditCardStrategy);
        result.append("1. ").append(paymentContext.executePayment(amount));
        result.append("\n\n");
        
        // Switch to PayPal
        paymentContext.setPaymentStrategy(payPalStrategy);
        result.append("2. ").append(paymentContext.executePayment(amount));
        result.append("\n\n");
        
        // Switch to Crypto
        paymentContext.setPaymentStrategy(cryptoStrategy);
        result.append("3. ").append(paymentContext.executePayment(amount));
        result.append("\n\n");
        
        result.append("Notice how the same context (PaymentContext) uses different strategies!");
        
        return result.toString();
    }
}
