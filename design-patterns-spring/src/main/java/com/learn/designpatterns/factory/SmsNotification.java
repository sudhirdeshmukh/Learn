package com.learn.designpatterns.factory;

/**
 * Concrete Product: SMS Notification
 * 
 * Implements the Notification interface for SMS delivery
 */
public class SmsNotification implements Notification {
    
    @Override
    public String send(String message) {
        // Simulate sending SMS
        return String.format("SMS sent: %s [via SMS Gateway]", message);
    }
    
    @Override
    public String getType() {
        return "SMS";
    }
}
