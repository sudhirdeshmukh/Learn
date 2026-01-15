package com.learn.designpatterns.singleton;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.Map;

/**
 * REST Controller to demonstrate Singleton Pattern
 * 
 * This controller shows how singleton behaves in a real application:
 * - Same instance is used across all HTTP requests
 * - Configuration changes persist across requests
 * - Instance ID remains constant
 */
@RestController
@RequestMapping("/api/singleton")
@Tag(name = "Singleton Pattern", description = "Demonstrates thread-safe Singleton pattern")
public class SingletonController {
    
    /**
     * Get configuration by key
     * Demonstrates that singleton maintains state across requests
     */
    @GetMapping("/config/{key}")
    @Operation(summary = "Get configuration value", 
               description = "Retrieves configuration from singleton ConfigurationManager")
    public String getConfig(@PathVariable String key) {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        String value = manager.getConfig(key);
        return value != null ? value : "Configuration not found for key: " + key;
    }
    
    /**
     * Get all configurations
     */
    @GetMapping("/config")
    @Operation(summary = "Get all configurations", 
               description = "Retrieves all configurations from singleton")
    public Map<String, String> getAllConfigs() {
        return ConfigurationManager.getInstance().getAllConfigs();
    }
    
    /**
     * Set configuration
     * Demonstrates that changes persist in singleton across requests
     */
    @PostMapping("/config")
    @Operation(summary = "Set configuration", 
               description = "Sets a configuration value in singleton (persists across requests)")
    public String setConfig(@RequestParam String key, @RequestParam String value) {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        manager.setConfig(key, value);
        return "Configuration set: " + key + " = " + value;
    }
    
    /**
     * Get instance ID to verify singleton behavior
     * The ID should be the same across all requests
     */
    @GetMapping("/instance-id")
    @Operation(summary = "Get singleton instance ID", 
               description = "Returns the instance ID - should be same across all requests")
    public String getInstanceId() {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        return "Singleton Instance ID: " + manager.getInstanceId();
    }
}
