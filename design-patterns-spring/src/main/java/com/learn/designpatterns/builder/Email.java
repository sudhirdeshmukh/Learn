package com.learn.designpatterns.builder;

import lombok.Getter;
import lombok.ToString;

/**
 * Product class for Builder Pattern
 * 
 * WHAT IS BUILDER PATTERN?
 * Builder pattern separates the construction of a complex object from its representation,
 * allowing the same construction process to create different representations.
 * 
 * WHY USE BUILDER?
 * - Handles complex object creation with many optional parameters
 * - Avoids telescoping constructor anti-pattern (constructors with many parameters)
 * - Makes code more readable and maintainable
 * - Allows step-by-step object construction
 * - Ensures object immutability
 * 
 * WHEN TO USE:
 * - When object has many optional fields
 * - When you want to create immutable objects
 * - When object creation requires multiple steps
 * - When you want to create different representations of the same object
 * 
 * Real-World Example: Building an Email with various optional components
 */
@Getter
@ToString
public class Email {
    
    // Required fields
    private final String to;
    private final String subject;
    private final String body;
    
    // Optional fields
    private final String from;
    private final String cc;
    private final String bcc;
    private final String replyTo;
    private final int priority;
    private final boolean readReceipt;
    private final boolean htmlFormat;
    private final String attachment;
    
    /**
     * Private constructor - only Builder can create Email objects
     * 
     * WHY PRIVATE?
     * - Enforces use of Builder for object creation
     * - Ensures all validation happens in Builder
     * - Makes the object immutable (no setters)
     */
    private Email(EmailBuilder builder) {
        this.to = builder.to;
        this.subject = builder.subject;
        this.body = builder.body;
        this.from = builder.from;
        this.cc = builder.cc;
        this.bcc = builder.bcc;
        this.replyTo = builder.replyTo;
        this.priority = builder.priority;
        this.readReceipt = builder.readReceipt;
        this.htmlFormat = builder.htmlFormat;
        this.attachment = builder.attachment;
    }
    
    /**
     * Static method to get Builder instance
     * Fluent API pattern starts here
     */
    public static EmailBuilder builder() {
        return new EmailBuilder();
    }
    
    /**
     * Builder class - Fluent API for Email construction
     * 
     * HOW IT WORKS:
     * 1. Each setter method returns 'this' (the builder itself)
     * 2. This enables method chaining: builder.setX().setY().setZ()
     * 3. build() method validates and creates the final object
     * 
     * BENEFITS:
     * - Readable: Email.builder().to("user@example.com").subject("Hello").build()
     * - Flexible: Can set only required + desired optional fields
     * - Safe: Validation happens before object creation
     */
    public static class EmailBuilder {
        // Required fields
        private String to;
        private String subject;
        private String body;
        
        // Optional fields with default values
        private String from = "noreply@example.com";
        private String cc;
        private String bcc;
        private String replyTo;
        private int priority = 3; // Default priority (1=highest, 5=lowest)
        private boolean readReceipt = false;
        private boolean htmlFormat = false;
        private String attachment;
        
        /**
         * Set recipient (required field)
         * Returns builder for method chaining
         */
        public EmailBuilder to(String to) {
            this.to = to;
            return this;
        }
        
        public EmailBuilder subject(String subject) {
            this.subject = subject;
            return this;
        }
        
        public EmailBuilder body(String body) {
            this.body = body;
            return this;
        }
        
        public EmailBuilder from(String from) {
            this.from = from;
            return this;
        }
        
        public EmailBuilder cc(String cc) {
            this.cc = cc;
            return this;
        }
        
        public EmailBuilder bcc(String bcc) {
            this.bcc = bcc;
            return this;
        }
        
        public EmailBuilder replyTo(String replyTo) {
            this.replyTo = replyTo;
            return this;
        }
        
        public EmailBuilder priority(int priority) {
            this.priority = priority;
            return this;
        }
        
        public EmailBuilder readReceipt(boolean readReceipt) {
            this.readReceipt = readReceipt;
            return this;
        }
        
        public EmailBuilder htmlFormat(boolean htmlFormat) {
            this.htmlFormat = htmlFormat;
            return this;
        }
        
        public EmailBuilder attachment(String attachment) {
            this.attachment = attachment;
            return this;
        }
        
        /**
         * Build method - validates and creates Email object
         * 
         * VALIDATION:
         * - Ensures required fields are set
         * - Validates field values
         * - Throws exception if validation fails
         * 
         * @return Immutable Email object
         * @throws IllegalStateException if required fields are missing
         */
        public Email build() {
            // Validate required fields
            if (to == null || to.isEmpty()) {
                throw new IllegalStateException("Recipient (to) is required");
            }
            if (subject == null || subject.isEmpty()) {
                throw new IllegalStateException("Subject is required");
            }
            if (body == null || body.isEmpty()) {
                throw new IllegalStateException("Body is required");
            }
            
            // Validate priority range
            if (priority < 1 || priority > 5) {
                throw new IllegalStateException("Priority must be between 1 and 5");
            }
            
            // Create and return immutable Email object
            return new Email(this);
        }
    }
}
