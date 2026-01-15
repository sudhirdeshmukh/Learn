package com.learn.designpatterns.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Strategy Pattern
 */
class PaymentContextTest {
    
    private PaymentContext context;
    private CreditCardPaymentStrategy creditCardStrategy;
    private PayPalPaymentStrategy payPalStrategy;
    private CryptoPaymentStrategy cryptoStrategy;
    
    @BeforeEach
    void setUp() {
        context = new PaymentContext();
        creditCardStrategy = new CreditCardPaymentStrategy();
        payPalStrategy = new PayPalPaymentStrategy();
        cryptoStrategy = new CryptoPaymentStrategy();
    }
    
    @Test
    void testStrategyExecution() {
        context.setPaymentStrategy(creditCardStrategy);
        String result = context.executePayment(100.00);
        
        assertNotNull(result);
        assertTrue(result.contains("credit card"));
    }
    
    @Test
    void testStrategySwitch() {
        // Start with credit card
        context.setPaymentStrategy(creditCardStrategy);
        assertEquals("CREDIT_CARD", context.getCurrentPaymentMethod());
        
        // Switch to PayPal
        context.setPaymentStrategy(payPalStrategy);
        assertEquals("PAYPAL", context.getCurrentPaymentMethod());
        
        // Switch to Crypto
        context.setPaymentStrategy(cryptoStrategy);
        assertEquals("CRYPTO", context.getCurrentPaymentMethod());
    }
    
    @Test
    void testPaymentStrategies() {
        double amount = 50.00;
        
        // Test Credit Card
        context.setPaymentStrategy(creditCardStrategy);
        String ccResult = context.executePayment(amount);
        assertTrue(ccResult.contains("Credit Card"));
        
        // Test PayPal
        context.setPaymentStrategy(payPalStrategy);
        String ppResult = context.executePayment(amount);
        assertTrue(ppResult.contains("PayPal"));
        
        // Test Crypto
        context.setPaymentStrategy(cryptoStrategy);
        String cryptoResult = context.executePayment(amount);
        assertTrue(cryptoResult.contains("Cryptocurrency"));
    }
    
    @Test
    void testExecuteWithoutStrategy() {
        assertThrows(IllegalStateException.class, () -> {
            context.executePayment(100.00);
        });
    }
}
