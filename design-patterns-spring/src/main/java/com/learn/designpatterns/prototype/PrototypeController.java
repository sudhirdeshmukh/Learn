package com.learn.designpatterns.prototype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST Controller demonstrating Prototype Pattern
 */
@RestController
@RequestMapping("/api/prototype")
@Tag(name = "Prototype Pattern", description = "Demonstrates Prototype pattern for efficient object cloning")
public class PrototypeController {
    
    @Autowired
    private DocumentRegistry documentRegistry;
    
    /**
     * Create document from template using Prototype pattern
     */
    @PostMapping("/document/create")
    @Operation(summary = "Create document from template", 
               description = "Clones a template document and customizes it")
    public Document createDocument(
            @RequestParam String template,
            @RequestParam String title,
            @RequestParam String author) {
        
        // Clone the prototype (fast operation)
        Document document = documentRegistry.getDocument(template);
        
        // Customize the cloned document
        document.setTitle(title);
        document.setAuthor(author);
        
        return document;
    }
    
    /**
     * Get available templates
     */
    @GetMapping("/templates")
    @Operation(summary = "Get available templates", 
               description = "Lists all available document templates")
    public String[] getTemplates() {
        return documentRegistry.getAvailableTemplates();
    }
    
    /**
     * Demonstrate cloning behavior
     */
    @GetMapping("/demo/clone")
    @Operation(summary = "Demo cloning behavior", 
               description = "Shows how cloning creates independent copies")
    public String demonstrateCloning() {
        // Get a template
        Document original = documentRegistry.getDocument("business-letter");
        original.setTitle("Original Document");
        original.setAuthor("Original Author");
        
        // Clone it
        Document cloned = original.clone();
        cloned.setTitle("Cloned Document");
        cloned.setAuthor("Cloned Author");
        
        // Show they are independent
        StringBuilder result = new StringBuilder();
        result.append("Original Document:\n");
        result.append(original.toString());
        result.append("\n\nCloned Document:\n");
        result.append(cloned.toString());
        result.append("\n\nNotice: Title and Author are different, proving they are independent copies.");
        result.append("\nMetadata timestamps are also different, showing deep copy behavior.");
        
        return result.toString();
    }
}
