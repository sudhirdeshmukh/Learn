package com.learn.designpatterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Unit tests for Singleton Pattern
 * Tests thread-safety and single instance behavior
 */
class ConfigurationManagerTest {
    
    @Test
    void testSingletonInstance() {
        // Get two instances
        ConfigurationManager instance1 = ConfigurationManager.getInstance();
        ConfigurationManager instance2 = ConfigurationManager.getInstance();
        
        // They should be the same object
        assertSame(instance1, instance2, "Both instances should be the same object");
        assertEquals(instance1.getInstanceId(), instance2.getInstanceId());
    }
    
    @Test
    void testConfigurationStorage() {
        ConfigurationManager manager = ConfigurationManager.getInstance();
        
        // Test setting and getting configuration
        manager.setConfig("test.key", "test.value");
        assertEquals("test.value", manager.getConfig("test.key"));
        
        // Verify default configurations are loaded
        assertNotNull(manager.getConfig("app.name"));
        assertEquals("Design Patterns Demo", manager.getConfig("app.name"));
    }
    
    @Test
    void testThreadSafety() throws InterruptedException {
        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);
        AtomicInteger successCount = new AtomicInteger(0);
        String[] instanceIds = new String[threadCount];
        
        // Create multiple threads to get singleton instance
        for (int i = 0; i < threadCount; i++) {
            final int index = i;
            new Thread(() -> {
                ConfigurationManager manager = ConfigurationManager.getInstance();
                instanceIds[index] = manager.getInstanceId();
                successCount.incrementAndGet();
                latch.countDown();
            }).start();
        }
        
        // Wait for all threads to complete
        latch.await();
        
        // Verify all threads got the same instance
        assertEquals(threadCount, successCount.get());
        String firstId = instanceIds[0];
        for (String id : instanceIds) {
            assertEquals(firstId, id, "All threads should get same singleton instance");
        }
    }
    
    @Test
    void testPersistenceAcrossAccess() {
        ConfigurationManager manager1 = ConfigurationManager.getInstance();
        manager1.setConfig("persistence.test", "value1");
        
        // Get another reference and verify value persists
        ConfigurationManager manager2 = ConfigurationManager.getInstance();
        assertEquals("value1", manager2.getConfig("persistence.test"));
    }
}
