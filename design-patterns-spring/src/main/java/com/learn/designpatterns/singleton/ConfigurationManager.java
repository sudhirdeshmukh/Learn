package com.learn.designpatterns.singleton;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/**
 * Thread-Safe Singleton Pattern Implementation using Double-Checked Locking
 * 
 * WHAT IS SINGLETON?
 * Singleton ensures a class has only ONE instance and provides a global access point to it.
 * 
 * WHY USE SINGLETON?
 * - Controls access to shared resources (e.g., database connection pool, configuration)
 * - Reduces memory footprint by preventing multiple instances
 * - Provides a single point of coordination across the system
 * 
 * WHEN TO USE:
 * - Logger classes
 * - Configuration managers
 * - Database connection pools
 * - Cache managers
 * 
 * THREAD-SAFETY CONSIDERATIONS:
 * This implementation uses double-checked locking with volatile keyword to ensure:
 * 1. Only one instance is created even in multi-threaded environment
 * 2. Minimal synchronization overhead (only during first initialization)
 * 3. Proper memory visibility across threads
 * 
 * NOTE: This is a pure Java Singleton pattern for educational purposes.
 * In Spring applications, you would typically use @Component with @Scope("singleton")
 * instead of manual singleton implementation.
 * 
 * Real-World Example: Application Configuration Manager
 */
public class ConfigurationManager {
    
    // volatile ensures visibility of changes across threads
    // Without volatile, threads might see partially constructed object
    private static volatile ConfigurationManager instance;
    
    // Thread-safe map to store configuration
    private final Map<String, String> configurations;
    
    /**
     * Private constructor prevents external instantiation
     * WHY PRIVATE? To enforce single instance creation through getInstance()
     */
    private ConfigurationManager() {
        this.configurations = new ConcurrentHashMap<>();
        // Simulate loading configurations
        loadDefaultConfigurations();
    }
    
    /**
     * Double-Checked Locking Singleton Pattern
     * 
     * WHY DOUBLE-CHECKED?
     * - First check (outside synchronized): Avoids synchronization overhead after initialization
     * - Synchronized block: Ensures only one thread can create instance
     * - Second check (inside synchronized): Prevents multiple instance creation if multiple
     *   threads pass first check simultaneously
     * 
     * @return Singleton instance of ConfigurationManager
     */
    public static ConfigurationManager getInstance() {
        // First check without synchronization for performance
        if (instance == null) {
            // Synchronize only when instance is null
            synchronized (ConfigurationManager.class) {
                // Double-check after acquiring lock
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }
    
    /**
     * Load default configurations
     * This method is called only once during singleton initialization
     */
    private void loadDefaultConfigurations() {
        configurations.put("app.name", "Design Patterns Demo");
        configurations.put("app.version", "1.0.0");
        configurations.put("db.connection.pool.size", "10");
        configurations.put("cache.enabled", "true");
        configurations.put("max.upload.size", "10MB");
    }
    
    /**
     * Get configuration value by key
     * 
     * @param key Configuration key
     * @return Configuration value or null if not found
     */
    public String getConfig(String key) {
        return configurations.get(key);
    }
    
    /**
     * Set configuration value
     * Thread-safe due to ConcurrentHashMap
     * 
     * @param key Configuration key
     * @param value Configuration value
     */
    public void setConfig(String key, String value) {
        configurations.put(key, value);
    }
    
    /**
     * Get all configurations
     * 
     * @return Map of all configurations
     */
    public Map<String, String> getAllConfigs() {
        return new ConcurrentHashMap<>(configurations);
    }
    
    /**
     * Get instance ID to verify singleton behavior
     * All calls should return same ID
     * 
     * @return Object hash code as string
     */
    public String getInstanceId() {
        return Integer.toHexString(System.identityHashCode(this));
    }
}
