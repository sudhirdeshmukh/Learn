package com.learn.designpatterns.builder;

import org.springframework.stereotype.Service;

/**
 * Service to demonstrate Builder Pattern usage
 */
@Service
public class EmailService {
    
    /**
     * Send email using Builder Pattern
     * 
     * @param email Email object built using Builder
     * @return Confirmation message
     */
    public String sendEmail(Email email) {
        // Simulate sending email
        StringBuilder result = new StringBuilder();
        result.append("Email sent successfully!\n");
        result.append("Details:\n");
        result.append(email.toString());
        
        return result.toString();
    }
    
    /**
     * Example: Create and send a simple email
     */
    public String sendSimpleEmail(String to, String subject, String body) {
        // Using Builder Pattern - clean and readable
        Email email = Email.builder()
                .to(to)
                .subject(subject)
                .body(body)
                .build();
        
        return sendEmail(email);
    }
    
    /**
     * Example: Create and send a complex email with all options
     */
    public String sendComplexEmail() {
        // Builder shines when dealing with many optional parameters
        Email email = Email.builder()
                .to("user@example.com")
                .from("admin@example.com")
                .subject("Important Update")
                .body("Please review the attached document.")
                .cc("manager@example.com")
                .bcc("archive@example.com")
                .replyTo("support@example.com")
                .priority(1) // High priority
                .readReceipt(true)
                .htmlFormat(true)
                .attachment("document.pdf")
                .build();
        
        return sendEmail(email);
    }
}
