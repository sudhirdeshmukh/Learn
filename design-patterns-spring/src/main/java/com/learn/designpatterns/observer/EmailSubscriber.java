package com.learn.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Observer: Email Subscriber
 * 
 * Receives notifications and handles them by sending emails
 */
public class EmailSubscriber implements Observer {
    
    private final String name;
    private final String email;
    private final List<String> receivedNotifications = new ArrayList<>();
    
    public EmailSubscriber(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    /**
     * Called by Subject when state changes
     * Each observer can handle the update differently
     */
    @Override
    public void update(String event) {
        // Simulate sending email notification
        String notification = String.format(
            "Email sent to %s (%s): %s",
            name, email, event
        );
        receivedNotifications.add(event);
        System.out.println(notification);
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public List<String> getReceivedNotifications() {
        return new ArrayList<>(receivedNotifications);
    }
}
