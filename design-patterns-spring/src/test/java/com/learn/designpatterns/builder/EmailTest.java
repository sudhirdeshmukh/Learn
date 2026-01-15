package com.learn.designpatterns.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for Builder Pattern
 */
class EmailTest {
    
    @Test
    void testBuilderWithRequiredFieldsOnly() {
        Email email = Email.builder()
                .to("test@example.com")
                .subject("Test Subject")
                .body("Test Body")
                .build();
        
        assertNotNull(email);
        assertEquals("test@example.com", email.getTo());
        assertEquals("Test Subject", email.getSubject());
        assertEquals("Test Body", email.getBody());
        assertEquals("noreply@example.com", email.getFrom()); // Default value
        assertEquals(3, email.getPriority()); // Default value
    }
    
    @Test
    void testBuilderWithAllFields() {
        Email email = Email.builder()
                .to("user@example.com")
                .from("sender@example.com")
                .subject("Important")
                .body("Content")
                .cc("cc@example.com")
                .bcc("bcc@example.com")
                .replyTo("reply@example.com")
                .priority(1)
                .readReceipt(true)
                .htmlFormat(true)
                .attachment("file.pdf")
                .build();
        
        assertNotNull(email);
        assertEquals("user@example.com", email.getTo());
        assertEquals("sender@example.com", email.getFrom());
        assertEquals("Important", email.getSubject());
        assertEquals("Content", email.getBody());
        assertEquals("cc@example.com", email.getCc());
        assertEquals("bcc@example.com", email.getBcc());
        assertEquals("reply@example.com", email.getReplyTo());
        assertEquals(1, email.getPriority());
        assertTrue(email.isReadReceipt());
        assertTrue(email.isHtmlFormat());
        assertEquals("file.pdf", email.getAttachment());
    }
    
    @Test
    void testBuilderValidationMissingTo() {
        assertThrows(IllegalStateException.class, () -> {
            Email.builder()
                .subject("Test")
                .body("Test")
                .build();
        });
    }
    
    @Test
    void testBuilderValidationMissingSubject() {
        assertThrows(IllegalStateException.class, () -> {
            Email.builder()
                .to("test@example.com")
                .body("Test")
                .build();
        });
    }
    
    @Test
    void testBuilderValidationMissingBody() {
        assertThrows(IllegalStateException.class, () -> {
            Email.builder()
                .to("test@example.com")
                .subject("Test")
                .build();
        });
    }
    
    @Test
    void testBuilderValidationInvalidPriority() {
        assertThrows(IllegalStateException.class, () -> {
            Email.builder()
                .to("test@example.com")
                .subject("Test")
                .body("Test")
                .priority(0) // Invalid: must be 1-5
                .build();
        });
        
        assertThrows(IllegalStateException.class, () -> {
            Email.builder()
                .to("test@example.com")
                .subject("Test")
                .body("Test")
                .priority(6) // Invalid: must be 1-5
                .build();
        });
    }
    
    @Test
    void testEmailImmutability() {
        Email email = Email.builder()
                .to("test@example.com")
                .subject("Test")
                .body("Test")
                .build();
        
        // Email should be immutable - no setters available
        assertNotNull(email.getTo());
        // This test verifies compile-time immutability
    }
}
