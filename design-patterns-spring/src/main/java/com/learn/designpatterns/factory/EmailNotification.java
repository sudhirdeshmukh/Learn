package com.learn.designpatterns.factory;

/**
 * Concrete Product: Email Notification
 * 
 * Implements the Notification interface for email delivery
 */
public class EmailNotification implements Notification {
    
    @Override
    public String send(String message) {
        // Simulate sending email
        return String.format("Email sent: %s [via SMTP server]", message);
    }
    
    @Override
    public String getType() {
        return "EMAIL";
    }
}
