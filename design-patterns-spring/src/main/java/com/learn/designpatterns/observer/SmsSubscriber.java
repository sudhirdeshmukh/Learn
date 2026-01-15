package com.learn.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Observer: SMS Subscriber
 * 
 * Receives notifications and handles them by sending SMS
 * Demonstrates that different observers can handle updates differently
 */
public class SmsSubscriber implements Observer {
    
    private final String name;
    private final String phoneNumber;
    private final List<String> receivedNotifications = new ArrayList<>();
    
    public SmsSubscriber(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Handle update by sending SMS
     * Different implementation than EmailSubscriber
     */
    @Override
    public void update(String event) {
        // Simulate sending SMS notification
        String notification = String.format(
            "SMS sent to %s (%s): %s",
            name, phoneNumber, event
        );
        receivedNotifications.add(event);
        System.out.println(notification);
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public List<String> getReceivedNotifications() {
        return new ArrayList<>(receivedNotifications);
    }
}
