package com.learn.designpatterns.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller demonstrating Factory and Abstract Factory patterns
 */
@RestController
@RequestMapping("/api/factory")
@Tag(name = "Factory Patterns", description = "Demonstrates Factory Method and Abstract Factory patterns")
public class FactoryController {
    
    @Autowired
    private NotificationFactory notificationFactory;
    
    @Autowired
    private AbstractFactoryProvider abstractFactoryProvider;
    
    /**
     * Demonstrate Factory Method Pattern
     */
    @PostMapping("/notification/send")
    @Operation(summary = "Send notification using Factory Method", 
               description = "Creates appropriate notification type and sends message")
    public String sendNotification(@RequestParam String type, @RequestParam String message) {
        // Factory creates the right notification type
        Notification notification = notificationFactory.createNotification(type);
        return notification.send(message);
    }
    
    /**
     * Demonstrate Abstract Factory Pattern
     */
    @GetMapping("/ui/render")
    @Operation(summary = "Render UI using Abstract Factory", 
               description = "Creates OS-specific UI components using Abstract Factory")
    public Map<String, String> renderUI(@RequestParam String os) {
        // Get the appropriate factory for the OS
        UIFactory factory = abstractFactoryProvider.getUIFactory(os);
        
        // Create components - all from same family (same OS)
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();
        
        Map<String, String> result = new HashMap<>();
        result.put("os", os);
        result.put("button", button.render());
        result.put("checkbox", checkbox.render());
        
        return result;
    }
    
    /**
     * Get supported notification types
     */
    @GetMapping("/notification/types")
    @Operation(summary = "Get supported notification types")
    public String[] getSupportedNotificationTypes() {
        return new String[]{"EMAIL", "SMS", "PUSH"};
    }
    
    /**
     * Get supported operating systems
     */
    @GetMapping("/ui/supported-os")
    @Operation(summary = "Get supported operating systems")
    public String[] getSupportedOS() {
        return new String[]{"WINDOWS", "MAC"};
    }
}
