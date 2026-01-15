package com.learn.designpatterns.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Prototype Pattern Implementation
 * 
 * WHAT IS PROTOTYPE?
 * Prototype pattern creates new objects by cloning an existing object (prototype)
 * rather than creating new instances from scratch.
 * 
 * WHY USE PROTOTYPE?
 * - Reduces cost of creating objects when creation is expensive
 * - Hides complexity of creating new instances from client
 * - Reduces need for subclassing
 * - Allows adding/removing objects at runtime
 * 
 * WHEN TO USE:
 * - When object creation is expensive (database queries, network calls, complex initialization)
 * - When you want to avoid subclasses of object creators
 * - When instances of a class can have only a few different combinations of state
 * 
 * Real-World Example: Document templates
 * Creating a new document from a template is faster than creating from scratch
 */
@Getter
@Setter
@ToString
public class Document implements Cloneable {
    
    private String title;
    private String content;
    private String author;
    private String template;
    private DocumentMetadata metadata;
    
    public Document(String title, String content, String author, String template) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.template = template;
        
        // Simulate expensive initialization
        this.metadata = new DocumentMetadata();
        this.metadata.setCreatedAt(System.currentTimeMillis());
        this.metadata.setVersion("1.0");
    }
    
    /**
     * Clone method - creates a copy of this object
     * 
     * HOW IT WORKS:
     * 1. Java's clone() creates a shallow copy by default
     * 2. We perform deep copy for mutable objects (metadata)
     * 3. Immutable fields (String, primitives) are safely shared
     * 
     * SHALLOW vs DEEP COPY:
     * - Shallow: Copies object references (both objects share same nested objects)
     * - Deep: Creates new copies of nested objects (completely independent)
     * 
     * @return Cloned document with independent metadata
     */
    @Override
    public Document clone() {
        try {
            // Shallow clone using Object.clone()
            Document cloned = (Document) super.clone();
            
            // Deep copy for mutable nested objects
            // Without this, both documents would share same metadata object
            cloned.metadata = new DocumentMetadata();
            cloned.metadata.setCreatedAt(this.metadata.getCreatedAt());
            cloned.metadata.setVersion(this.metadata.getVersion());
            cloned.metadata.setModifiedAt(System.currentTimeMillis());
            
            return cloned;
        } catch (CloneNotSupportedException e) {
            // This should never happen as we implement Cloneable
            throw new RuntimeException("Clone failed", e);
        }
    }
    
    /**
     * Inner class representing document metadata
     * Used to demonstrate deep vs shallow copy
     */
    @Getter
    @Setter
    @ToString
    public static class DocumentMetadata {
        private long createdAt;
        private long modifiedAt;
        private String version;
    }
}
