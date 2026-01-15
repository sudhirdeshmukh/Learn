package com.learn.designpatterns.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller demonstrating Observer Pattern
 */
@RestController
@RequestMapping("/api/observer")
@Tag(name = "Observer Pattern", description = "Demonstrates Observer pattern for event notification")
public class ObserverController {
    
    @Autowired
    private NewsletterPublisher publisher;
    
    // Store subscribers for demo purposes
    private final Map<String, Observer> subscribers = new HashMap<>();
    
    /**
     * Subscribe to newsletter
     */
    @PostMapping("/subscribe")
    @Operation(summary = "Subscribe to newsletter", 
               description = "Adds a new observer to receive notifications")
    public String subscribe(
            @RequestParam String name,
            @RequestParam String contact,
            @RequestParam String type) {
        
        Observer observer;
        
        // Create appropriate observer type
        if ("EMAIL".equalsIgnoreCase(type)) {
            observer = new EmailSubscriber(name, contact);
        } else if ("SMS".equalsIgnoreCase(type)) {
            observer = new SmsSubscriber(name, contact);
        } else {
            return "Invalid subscription type. Use EMAIL or SMS";
        }
        
        // Attach observer to subject
        publisher.attach(observer);
        subscribers.put(name, observer);
        
        return name + " subscribed successfully via " + type;
    }
    
    /**
     * Unsubscribe from newsletter
     */
    @PostMapping("/unsubscribe")
    @Operation(summary = "Unsubscribe from newsletter", 
               description = "Removes an observer from receiving notifications")
    public String unsubscribe(@RequestParam String name) {
        Observer observer = subscribers.remove(name);
        
        if (observer != null) {
            publisher.detach(observer);
            return name + " unsubscribed successfully";
        }
        
        return "Subscriber not found: " + name;
    }
    
    /**
     * Publish article - notifies all subscribers
     */
    @PostMapping("/publish")
    @Operation(summary = "Publish article", 
               description = "Publishes article and notifies all subscribers (demonstrates Observer pattern)")
    public String publishArticle(@RequestParam String article) {
        return publisher.publishArticle(article);
    }
    
    /**
     * Get subscriber count
     */
    @GetMapping("/subscribers/count")
    @Operation(summary = "Get subscriber count", 
               description = "Returns number of active subscribers")
    public Map<String, Object> getSubscriberCount() {
        Map<String, Object> result = new HashMap<>();
        result.put("count", publisher.getSubscriberCount());
        result.put("latestArticle", publisher.getLatestArticle());
        return result;
    }
    
    /**
     * Demonstrate Observer pattern
     */
    @GetMapping("/demo")
    @Operation(summary = "Demo Observer pattern", 
               description = "Shows how observers get notified when subject changes")
    public String demonstrateObserver() {
        // Clear previous subscribers
        subscribers.clear();
        
        // Create observers
        Observer email1 = new EmailSubscriber("Alice", "alice@example.com");
        Observer email2 = new EmailSubscriber("Bob", "bob@example.com");
        Observer sms1 = new SmsSubscriber("Charlie", "+1234567890");
        
        // Attach observers
        NewsletterPublisher demoPublisher = new NewsletterPublisher();
        demoPublisher.attach(email1);
        demoPublisher.attach(email2);
        demoPublisher.attach(sms1);
        
        StringBuilder result = new StringBuilder();
        result.append("Demo: Observer Pattern\n\n");
        result.append("Initial subscribers: 3 (2 email, 1 SMS)\n\n");
        
        // Publish article - all observers get notified
        result.append("Publishing article...\n");
        demoPublisher.publishArticle("Understanding Design Patterns");
        result.append("\nAll 3 subscribers were notified!\n\n");
        
        // Remove one observer
        result.append("Unsubscribing Bob...\n");
        demoPublisher.detach(email2);
        
        // Publish again - only remaining observers get notified
        result.append("\nPublishing another article...\n");
        demoPublisher.publishArticle("Advanced Java Techniques");
        result.append("\nOnly 2 subscribers were notified (Bob is unsubscribed)\n\n");
        
        result.append("This demonstrates:\n");
        result.append("- One-to-many dependency (1 publisher, many subscribers)\n");
        result.append("- Automatic notification when state changes\n");
        result.append("- Dynamic subscription/unsubscription\n");
        result.append("- Loose coupling between publisher and subscribers");
        
        return result.toString();
    }
}
