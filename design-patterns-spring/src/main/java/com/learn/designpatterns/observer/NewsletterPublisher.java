package com.learn.designpatterns.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject: Newsletter Publisher
 * 
 * HOW OBSERVER PATTERN WORKS:
 * 1. Observers register with the Subject (subscribe)
 * 2. Subject maintains a list of all registered Observers
 * 3. When Subject's state changes, it notifies all Observers
 * 4. Each Observer receives the notification and updates itself
 * 
 * BENEFITS:
 * - Subject doesn't need to know concrete Observer classes
 * - Observers can be added/removed at runtime
 * - Subject and Observers are loosely coupled
 */
@Component
public class NewsletterPublisher implements Subject {
    
    // List of all subscribed observers
    private final List<Observer> observers = new ArrayList<>();
    
    // Publisher's state
    private String latestArticle;
    
    /**
     * Subscribe an observer
     * Observer will receive all future notifications
     */
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(observer.getName() + " subscribed to newsletter");
        }
    }
    
    /**
     * Unsubscribe an observer
     * Observer will no longer receive notifications
     */
    @Override
    public void detach(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println(observer.getName() + " unsubscribed from newsletter");
        }
    }
    
    /**
     * Notify all observers about an event
     * This is where the "push" happens
     */
    @Override
    public void notifyObservers(String event) {
        System.out.println("Notifying " + observers.size() + " subscribers...");
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
    
    /**
     * Publish a new article
     * This triggers notification to all subscribers
     * 
     * @param article Article content
     * @return Confirmation message
     */
    public String publishArticle(String article) {
        this.latestArticle = article;
        
        // Notify all observers about the new article
        notifyObservers("New article published: " + article);
        
        return "Article published and " + observers.size() + " subscribers notified";
    }
    
    /**
     * Get number of subscribers
     */
    public int getSubscriberCount() {
        return observers.size();
    }
    
    /**
     * Get latest article
     */
    public String getLatestArticle() {
        return latestArticle;
    }
}
