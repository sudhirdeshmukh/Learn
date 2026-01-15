package com.learn.designpatterns.prototype;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Registry - manages prototype instances
 * 
 * This is a common extension to Prototype pattern that maintains
 * a registry of prototype objects that can be cloned on demand.
 */
@Component
public class DocumentRegistry {
    
    // Registry stores prototype instances
    private final Map<String, Document> prototypes = new HashMap<>();
    
    public DocumentRegistry() {
        // Initialize with common document templates
        loadPrototypes();
    }
    
    /**
     * Load common document prototypes
     * These act as templates that can be cloned and customized
     */
    private void loadPrototypes() {
        // Business Letter Template
        Document businessLetter = new Document(
            "[Company Name]",
            "Dear [Recipient],\n\n[Letter Content]\n\nBest Regards,\n[Sender]",
            "Template",
            "business-letter"
        );
        prototypes.put("business-letter", businessLetter);
        
        // Report Template
        Document report = new Document(
            "[Report Title]",
            "Executive Summary:\n\n1. Introduction\n2. Analysis\n3. Conclusion",
            "Template",
            "report"
        );
        prototypes.put("report", report);
        
        // Meeting Minutes Template
        Document meetingMinutes = new Document(
            "Meeting Minutes - [Date]",
            "Attendees:\n\nAgenda:\n\nDiscussion:\n\nAction Items:",
            "Template",
            "meeting-minutes"
        );
        prototypes.put("meeting-minutes", meetingMinutes);
    }
    
    /**
     * Get a cloned document from registry
     * 
     * WHY CLONING IS USEFUL HERE:
     * - Template documents are pre-configured with structure
     * - Cloning is faster than recreating the structure each time
     * - Each clone can be independently modified
     * 
     * @param templateName Name of the template
     * @return Cloned document ready for customization
     */
    public Document getDocument(String templateName) {
        Document prototype = prototypes.get(templateName);
        if (prototype == null) {
            throw new IllegalArgumentException("Template not found: " + templateName);
        }
        return prototype.clone();
    }
    
    /**
     * Add a new prototype to registry
     * 
     * @param name Template name
     * @param document Prototype document
     */
    public void addPrototype(String name, Document document) {
        prototypes.put(name, document);
    }
    
    /**
     * Get all available template names
     * 
     * @return Array of template names
     */
    public String[] getAvailableTemplates() {
        return prototypes.keySet().toArray(new String[0]);
    }
}
