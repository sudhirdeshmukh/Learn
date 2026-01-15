package com.learn.designpatterns.factory;

/**
 * Product interface for Factory Pattern
 * 
 * Represents a notification that can be sent through different channels
 */
public interface Notification {
    
    /**
     * Send notification with a message
     * Each implementation will handle sending differently
     * 
     * @param message The message to send
     * @return Confirmation message
     */
    String send(String message);
    
    /**
     * Get the type of notification
     * 
     * @return Notification type as string
     */
    String getType();
}
