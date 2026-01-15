package com.learn.designpatterns.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller demonstrating Builder Pattern
 */
@RestController
@RequestMapping("/api/builder")
@Tag(name = "Builder Pattern", description = "Demonstrates Builder pattern for complex object creation")
public class BuilderController {
    
    @Autowired
    private EmailService emailService;
    
    /**
     * Send simple email with required fields only
     */
    @PostMapping("/email/simple")
    @Operation(summary = "Send simple email", 
               description = "Creates email with required fields using Builder pattern")
    public String sendSimpleEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body) {
        
        return emailService.sendSimpleEmail(to, subject, body);
    }
    
    /**
     * Send email with all optional fields
     */
    @PostMapping("/email/complex")
    @Operation(summary = "Send complex email", 
               description = "Creates email with all optional fields using Builder pattern")
    public String sendComplexEmail(
            @RequestParam String to,
            @RequestParam String subject,
            @RequestParam String body,
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String cc,
            @RequestParam(required = false) String bcc,
            @RequestParam(required = false) String replyTo,
            @RequestParam(required = false, defaultValue = "3") int priority,
            @RequestParam(required = false, defaultValue = "false") boolean readReceipt,
            @RequestParam(required = false, defaultValue = "false") boolean htmlFormat,
            @RequestParam(required = false) String attachment) {
        
        // Demonstrate Builder Pattern with optional parameters
        Email.EmailBuilder builder = Email.builder()
                .to(to)
                .subject(subject)
                .body(body);
        
        // Add optional fields only if provided
        if (from != null) builder.from(from);
        if (cc != null) builder.cc(cc);
        if (bcc != null) builder.bcc(bcc);
        if (replyTo != null) builder.replyTo(replyTo);
        if (attachment != null) builder.attachment(attachment);
        
        builder.priority(priority)
               .readReceipt(readReceipt)
               .htmlFormat(htmlFormat);
        
        Email email = builder.build();
        return emailService.sendEmail(email);
    }
    
    /**
     * Demonstrate builder with pre-configured example
     */
    @GetMapping("/email/demo")
    @Operation(summary = "Demo complex email", 
               description = "Sends a pre-configured complex email to demonstrate Builder pattern")
    public String demoComplexEmail() {
        return emailService.sendComplexEmail();
    }
}
