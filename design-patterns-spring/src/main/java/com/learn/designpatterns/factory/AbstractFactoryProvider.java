package com.learn.designpatterns.factory;

import org.springframework.stereotype.Component;

/**
 * Abstract Factory creator
 * 
 * Provides a way to get the appropriate UI factory based on OS
 */
@Component
public class AbstractFactoryProvider {
    
    /**
     * Get UI Factory based on operating system
     * 
     * WHY THIS IS USEFUL:
     * - Client code doesn't need to know which concrete factory to use
     * - Easy to add support for new operating systems
     * - Ensures consistency within each product family
     * 
     * @param os Operating system name
     * @return UIFactory instance for the OS
     */
    public UIFactory getUIFactory(String os) {
        return switch (os.toUpperCase()) {
            case "WINDOWS" -> new WindowsUIFactory();
            case "MAC" -> new MacUIFactory();
            default -> throw new IllegalArgumentException("Unsupported OS: " + os);
        };
    }
}
