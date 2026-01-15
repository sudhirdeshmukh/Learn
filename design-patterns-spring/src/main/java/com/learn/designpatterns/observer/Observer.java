package com.learn.designpatterns.observer;

/**
 * Observer Interface
 * 
 * WHAT IS OBSERVER PATTERN?
 * Observer pattern defines a one-to-many dependency between objects so that when
 * one object (Subject) changes state, all its dependents (Observers) are notified
 * and updated automatically.
 * 
 * WHY USE OBSERVER?
 * - Establishes loose coupling between Subject and Observers
 * - Allows dynamic addition/removal of observers
 * - Implements broadcast communication (one-to-many)
 * - Separates core functionality from side effects
 * 
 * WHEN TO USE:
 * - When changes to one object require changing others
 * - When you don't know how many objects need to be changed
 * - When an object should be able to notify other objects without assumptions about who they are
 * 
 * Real-World Examples:
 * - Event handling systems (UI events, message queues)
 * - Newsletter subscriptions
 * - Stock price updates
 * - Social media notifications
 */
public interface Observer {
    
    /**
     * Called when Subject's state changes
     * 
     * @param event Event containing update information
     */
    void update(String event);
    
    /**
     * Get observer name/identifier
     * 
     * @return Observer identifier
     */
    String getName();
}
