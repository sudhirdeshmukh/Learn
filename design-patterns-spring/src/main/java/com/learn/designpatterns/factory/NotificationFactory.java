package com.learn.designpatterns.factory;

import org.springframework.stereotype.Component;

/**
 * Factory Method Pattern Implementation
 * 
 * WHAT IS FACTORY METHOD?
 * Factory Method defines an interface for creating objects, but lets subclasses decide
 * which class to instantiate. It delegates the instantiation logic to child classes.
 * 
 * WHY USE FACTORY METHOD?
 * - Eliminates the need to bind application-specific classes into your code
 * - Promotes loose coupling by eliminating the need to instantiate concrete classes directly
 * - Makes code more flexible and easier to extend (Open/Closed Principle)
 * - Centralizes object creation logic
 * 
 * WHEN TO USE:
 * - When you don't know beforehand the exact types and dependencies of objects
 * - When you want to provide a library of products and expose only their interfaces
 * - When you want to delegate the instantiation logic to derived classes
 * 
 * Real-World Example: Notification System
 * Different notification types (Email, SMS, Push) are created based on user preference
 */
@Component
public class NotificationFactory {
    
    /**
     * Factory Method to create notification objects
     * 
     * HOW IT WORKS:
     * Instead of using 'new EmailNotification()' directly in client code,
     * we use this factory method which decides which concrete class to instantiate
     * based on the type parameter.
     * 
     * BENEFITS:
     * - Client code doesn't need to know about concrete classes
     * - Easy to add new notification types without modifying client code
     * - Centralized creation logic makes it easier to add features like caching, logging
     * 
     * @param type Type of notification (EMAIL, SMS, PUSH)
     * @return Notification instance
     * @throws IllegalArgumentException if type is not supported
     */
    public Notification createNotification(String type) {
        // Factory decides which concrete class to instantiate
        // This logic is centralized and easy to extend
        
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("Notification type cannot be null or empty");
        }
        
        return switch (type.toUpperCase()) {
            case "EMAIL" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
    
    /**
     * Example of factory method with additional logic
     * Shows how factory can add cross-cutting concerns
     * 
     * @param type Notification type
     * @param enableLogging Whether to enable logging
     * @return Notification instance
     */
    public Notification createNotificationWithLogging(String type, boolean enableLogging) {
        Notification notification = createNotification(type);
        
        if (enableLogging) {
            // Here you could wrap the notification with a logging proxy
            // or add logging behavior
            System.out.println("Created notification of type: " + notification.getType());
        }
        
        return notification;
    }
}
