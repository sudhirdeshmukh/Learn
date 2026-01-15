package com.learn.designpatterns.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Factory Pattern
 */
class NotificationFactoryTest {
    
    private final NotificationFactory factory = new NotificationFactory();
    
    @Test
    void testCreateEmailNotification() {
        Notification notification = factory.createNotification("EMAIL");
        
        assertNotNull(notification);
        assertInstanceOf(EmailNotification.class, notification);
        assertEquals("EMAIL", notification.getType());
        assertTrue(notification.send("Test").contains("Email sent"));
    }
    
    @Test
    void testCreateSmsNotification() {
        Notification notification = factory.createNotification("SMS");
        
        assertNotNull(notification);
        assertInstanceOf(SmsNotification.class, notification);
        assertEquals("SMS", notification.getType());
        assertTrue(notification.send("Test").contains("SMS sent"));
    }
    
    @Test
    void testCreatePushNotification() {
        Notification notification = factory.createNotification("PUSH");
        
        assertNotNull(notification);
        assertInstanceOf(PushNotification.class, notification);
        assertEquals("PUSH", notification.getType());
        assertTrue(notification.send("Test").contains("Push notification sent"));
    }
    
    @Test
    void testFactoryWithInvalidType() {
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createNotification("INVALID");
        });
    }
    
    @Test
    void testFactoryWithNullType() {
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createNotification(null);
        });
    }
    
    @Test
    void testFactoryCaseInsensitive() {
        Notification email1 = factory.createNotification("email");
        Notification email2 = factory.createNotification("EMAIL");
        Notification email3 = factory.createNotification("Email");
        
        assertEquals(email1.getType(), email2.getType());
        assertEquals(email2.getType(), email3.getType());
    }
}
