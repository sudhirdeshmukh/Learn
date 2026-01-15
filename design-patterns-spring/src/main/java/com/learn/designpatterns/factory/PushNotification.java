package com.learn.designpatterns.factory;

/**
 * Concrete Product: Push Notification
 * 
 * Implements the Notification interface for push notifications
 */
public class PushNotification implements Notification {
    
    @Override
    public String send(String message) {
        // Simulate sending push notification
        return String.format("Push notification sent: %s [via FCM/APNS]", message);
    }
    
    @Override
    public String getType() {
        return "PUSH";
    }
}
