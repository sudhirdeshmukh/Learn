package com.learn.designpatterns.decorator;

/**
 * Component Interface for Decorator Pattern
 * 
 * WHAT IS DECORATOR PATTERN?
 * Decorator pattern attaches additional responsibilities to an object dynamically.
 * Decorators provide a flexible alternative to subclassing for extending functionality.
 * 
 * WHY USE DECORATOR?
 * - Adds functionality to objects without modifying their code
 * - More flexible than static inheritance
 * - Avoids class explosion (too many subclasses)
 * - Allows adding/removing responsibilities at runtime
 * - Follows Single Responsibility Principle
 * 
 * WHEN TO USE:
 * - When you need to add functionality to objects without affecting other objects
 * - When extension by subclassing is impractical
 * - When you want to add responsibilities dynamically and transparently
 * 
 * Real-World Examples:
 * - Java I/O classes (BufferedReader decorates FileReader)
 * - Coffee shop (coffee + milk + sugar + whipped cream)
 * - Text formatting (bold + italic + underline)
 * 
 * This Example: Coffee ordering system
 */
public interface Coffee {
    
    /**
     * Get coffee description
     * 
     * @return Description of the coffee with all additions
     */
    String getDescription();
    
    /**
     * Get total cost
     * 
     * @return Total cost including all additions
     */
    double getCost();
}
